package com.example.servlets;

import com.example.Coffee;
import com.example.CoffeeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCoffeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));

            CoffeeDAO coffeeDAO = new CoffeeDAO();
            Coffee coffee = coffeeDAO.getCoffeeById(id);
            coffeeDAO.close();

            if (coffee != null) {
                request.setAttribute("coffee", coffee);
                request.getRequestDispatcher("/edit-coffee.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Coffee not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Coffee.CoffeeType type = Coffee.CoffeeType.valueOf(request.getParameter("type"));
            Double weight = Double.parseDouble(request.getParameter("weight"));
            Double volume = Double.parseDouble(request.getParameter("volume"));
            Double price = Double.parseDouble(request.getParameter("price"));
            Double packageWeight = Double.parseDouble(request.getParameter("packageWeight"));
            String packageType = request.getParameter("packageType");
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));

            Coffee coffee = new Coffee(id, name, type, weight, volume, price, packageWeight, packageType, quantity);

            CoffeeDAO coffeeDAO = new CoffeeDAO();
            coffeeDAO.updateCoffee(coffee);
            coffeeDAO.close();

            response.sendRedirect("coffees");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating coffee");
        }
    }
}