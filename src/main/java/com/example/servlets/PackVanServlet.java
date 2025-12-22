package com.example.servlets;

import com.example.Coffee;
import com.example.CoffeeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PackVanServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/pack-van.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String vanVolumeStr = request.getParameter("vanVolume");
            String targetAmountStr = request.getParameter("targetAmount");
            String maxWeightStr = request.getParameter("maxWeight");

            Double vanVolume = vanVolumeStr != null && !vanVolumeStr.isEmpty() ?
                    Double.parseDouble(vanVolumeStr) : null;
            Double targetAmount = targetAmountStr != null && !targetAmountStr.isEmpty() ?
                    Double.parseDouble(targetAmountStr) : null;
            Double maxWeight = maxWeightStr != null && !maxWeightStr.isEmpty() ?
                    Double.parseDouble(maxWeightStr) : null;

            CoffeeDAO coffeeDAO = new CoffeeDAO();
            List<Coffee> packedCoffees = coffeeDAO.packVan(vanVolume, targetAmount, maxWeight);
            coffeeDAO.close();

            // Рассчитываем итоги
            double totalVolume = packedCoffees.stream()
                    .mapToDouble(c -> c.getVolume() * c.getQuantity())
                    .sum();
            double totalAmount = packedCoffees.stream()
                    .mapToDouble(c -> c.getPrice() * c.getQuantity())
                    .sum();
            double totalWeight = packedCoffees.stream()
                    .mapToDouble(c -> c.getTotalWeight() * c.getQuantity())
                    .sum();

            request.setAttribute("packedCoffees", packedCoffees);
            request.setAttribute("totalVolume", totalVolume);
            request.setAttribute("totalAmount", totalAmount);
            request.setAttribute("totalWeight", totalWeight);
            request.setAttribute("vanVolume", vanVolume);
            request.setAttribute("targetAmount", targetAmount);
            request.setAttribute("maxWeight", maxWeight);

            request.getRequestDispatcher("/packing-result.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error packing van");
        }
    }
}