/*
 * This file is a servlet which will take the properties from 'index.html' and pass name and phone 
 * in a hidden field.
 * this file will also do some backend error validation so that incase you get through the html attributes 
 * and javascript, it will stop and send you to the error page
 */
package com.mycompany.luka_necajev_a1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
public class StartOrder extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void startOrder(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            //checking if the name is empty
            if (name.equals("")){
//                 JOptionPane.showMessageDialog(null, "Error in name validation","failure",JOptionPane.ERROR_MESSAGE);
                RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
                rd.forward(request, response);
              }
              // checking if the phone is empty
            if (phone.equals("")){
                RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
                rd.forward(request, response);
              }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>StartOrderServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Hi  " + name + "</h1>");
            out.println("<h3>" + phone + "</h3>");
//The form with the action of the jsp path, for when you click the send Order button
//chooseing if you want to pick up or deliver using the names "deliver" for delivery 
//"pick up" for pick up and "select" for the select statment
            out.write("<form action=\"PlaceOrder.do\" method=\"POST\">"
                    + "<select name=\"select\">\n"
                    + "Pick up or Deliver?"
                    + "<option value=\"deliver\"> Deliver</option>\n"
                    + "<option value=\"pickUp\">Pick up</option>\n"
                    + "</select> <br>");
//now here are the small medium and large radio buttons
//the name is "size" 
//each value is "small","medium" or "large"
            out.write(
                    "<input type=\"radio\" value=\"small\" name=\"size\">Small(5$)\n"
                    + "<input type=\"radio\"  checked=\"checked\" value=\"medium\" name=\"size\"> Medium (7$)\n"
//                    + "<input type=\"radio\" value=\"medium\" name=\"size\"> Medium (7$)\n"
                    + "<input type=\"radio\" value=\"large\" name=\"size\">Large(9$)  <br>\n");

            //setting the hidden values of the 
            out.println(
                      "<input type=\"text\" \" name=\"name\" hidden=\"\" value=\"" + name + "\">"
                    + "<input type=\"text\" name=\"phone\"  hidden=\"\" value=\"" + phone + "\">");
//here are the toppings
// each has a value and name of the topping name 
            out.write(
                      "<input type=\"checkbox\" value=\"Peperoni\" name=\"toppings\">Peperoni <br>\n"
                    + "<input type=\"checkbox\" value=\"Sausage\" name=\"toppings\">Sausage <br>\n"
                    + "<input type=\"checkbox\" value=\"Baby Spinach\" name=\"toppings\">Baby Spinach <br> \n"
                    + "<input type=\"checkbox\" value=\"Peper\" name=\"toppings\"> Peper <br>\n"
                    + "<input type=\"submit\" value=\"Place My Order\" />\n");

            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void incorrectPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Wrong Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>You are using POST not GET, Please change method back to GET</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        startOrder(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        incorrectPost(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
