package com.example.servlets;

import com.example.Coffee;
import com.example.CoffeeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindCoffeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/find-coffee.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String typeStr = request.getParameter("type");
            String minWeightStr = request.getParameter("minWeight");
            String maxWeightStr = request.getParameter("maxWeight");
            String minPriceStr = request.getParameter("minPrice");
            String maxPriceStr = request.getParameter("maxPrice");
            String minPricePerKgStr = request.getParameter("minPricePerKg");
            String maxPricePerKgStr = request.getParameter("maxPricePerKg");

            Coffee.CoffeeType type = typeStr != null && !typeStr.isEmpty() ?
                    Coffee.CoffeeType.valueOf(typeStr) : null;
            Double minWeight = parseDouble(minWeightStr);
            Double maxWeight = parseDouble(maxWeightStr);
            Double minPrice = parseDouble(minPriceStr);
            Double maxPrice = parseDouble(maxPriceStr);
            Double minPricePerKg = parseDouble(minPricePerKgStr);
            Double maxPricePerKg = parseDouble(maxPricePerKgStr);

            CoffeeDAO coffeeDAO = new CoffeeDAO();
            List<Coffee> foundCoffees = coffeeDAO.findCoffeeByRange(
                    type, minWeight, maxWeight, minPrice, maxPrice, minPricePerKg, maxPricePerKg);
            coffeeDAO.close();

            request.setAttribute("foundCoffees", foundCoffees);
            request.setAttribute("searchParams", request.getParameterMap());
            request.getRequestDispatcher("/find-coffee-result.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error searching coffee");
        }
    }

    private Double parseDouble(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
    }
}