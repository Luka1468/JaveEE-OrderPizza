/*
 * This file will set all of the attributes
 * and will also do some validation in case the last one fails :)
https://necajevla1.herokuapp.com/
 */
package com.mycompany.luka_necajev_a1.servlets;

import com.mycompany.luka_necajev_a1.model.PizzaOrder;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gunar
 */
public class PlaceOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PizzaOrder order = new PizzaOrder();

        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String selectPickup = request.getParameter("select");
        String size = request.getParameter("size");

        String[] toppings = request.getParameterValues("toppings");

//            setting the toppings in the order class
        order.setToppings(toppings);

//            if the choice chosen was delivery, then set the setDelivery status to true
//            if the pickUp was chosen, then setDelivery's status will be false
        if (selectPickup.equals("deliver")) {
            order.setDelivery(true);
        } else if (selectPickup.equals("pickUp")) {
            order.setDelivery(false);
        } else {
        }

//            passing the size variable to the order object
        order.setSize(size);

//            NOT NEEDED IN PROJECT
//            
        //checking if name is empty
        if (name.equals("")) {
            RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
            rd.forward(request, response);
        }
        //checking if the phone is empty
        if (phone.equals("")) {
            RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
            rd.forward(request, response);
        }
        //making sure that one size is checked
        if (size == null) {
            RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
            rd.forward(request, response);
        }

        request.setAttribute("order", order);
        RequestDispatcher rd = request.getRequestDispatcher("displayOrder.jsp");
        rd.forward(request, response);
//              
//              Pattern pattern=Pattern.compile("/^[1-9]\\d{2}-\\d{3}-\\d{4}$/g");
//              Matcher m= pattern.matcher(phone);
//               if(m.equals(true)){
//               }else{
//                RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
//                rd.forward(request, response);
//               }

    }

}
