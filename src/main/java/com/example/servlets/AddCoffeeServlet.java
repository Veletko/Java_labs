package com.example.servlets;

import com.example.Coffee;
import com.example.CoffeeDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCoffeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/add-coffee.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            Coffee.CoffeeType type = Coffee.CoffeeType.valueOf(request.getParameter("type"));
            Double weight = Double.parseDouble(request.getParameter("weight"));
            Double volume = Double.parseDouble(request.getParameter("volume"));
            Double price = Double.parseDouble(request.getParameter("price"));
            Double packageWeight = Double.parseDouble(request.getParameter("packageWeight"));
            String packageType = request.getParameter("packageType");
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));

            Coffee coffee = new Coffee(name, type, weight, volume, price, packageWeight, packageType, quantity);

            CoffeeDAO coffeeDAO = new CoffeeDAO();
            coffeeDAO.insertCoffee(coffee);
            coffeeDAO.close();

            response.sendRedirect("coffees");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error adding coffee");
        }
    }
}