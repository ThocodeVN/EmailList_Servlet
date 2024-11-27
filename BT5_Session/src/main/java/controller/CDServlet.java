/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Database.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Database.ListCD;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Duy Thanh
 */
public class CDServlet extends HttpServlet {

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.jsp";
        
        String action = request.getParameter("action");
        System.out.println(action);
        if (action == null) {
            action = "join"; // default action
        }
        
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }
          
        // perform action and set URL to appropriate page
        if (action.equals("join")) {
            url = "/index.jsp"; // the "join" page
        }
        else if (action.equals("add")) {
            LineCD lineCD = cart.getLineCDByName(request.getParameter("name"));  
            if( lineCD == null){
                lineCD = new LineCD();
                lineCD.setNumber(lineCD.getNumber()+1);
                lineCD.setPrice(Double.parseDouble(request.getParameter("price")));
                lineCD.setName(request.getParameter("name"));
                double priceCD = Double.parseDouble(request.getParameter("price"));
                lineCD.setAmount(lineCD.getNumber() * priceCD);
                cart.addToCart(lineCD);
            }
            else {
                lineCD.setNumber(lineCD.getNumber()+1);
                double priceCD = Double.parseDouble(request.getParameter("price"));
                lineCD.setAmount(lineCD.getNumber() * priceCD);
            }
            url = "/cart.jsp";
        }
        else if (action.equals("update")){
            LineCD lineCD = cart.getLineCDByName(request.getParameter("name"));  
            lineCD.setNumber(Integer.parseInt(request.getParameter("number")));
            double priceCD = Double.parseDouble(request.getParameter("price"));
            lineCD.setAmount(lineCD.getNumber() * priceCD);
            url = "/cart.jsp";
        }
        else if (action.equals("remove")){
            LineCD lineCD = cart.getLineCDByName(request.getParameter("name"));
            cart.removeFromCart(lineCD.getName());
            url = "/cart.jsp";
        }
        
        session.setAttribute("cart", cart);
            
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
    }
}
