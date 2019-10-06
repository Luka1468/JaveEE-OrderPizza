<%-- 
    Document   : displayOrder
    Created on : Sep 17, 2019, 1:11:56 PM
    Author     : Gunar
<%
            out.println(order.getSize());
            out.write(request.getParameter("phone"));  
            %>

<%
            String name = request.getParameter("name");
            String phone=request.getParameter("phone");
            %>


--%>

<%@page import="java.util.Arrays"%>
<%@page import="com.mycompany.luka_necajev_a1.model.PizzaOrder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
            <%
            String name = request.getParameter("name");
            String phone=request.getParameter("phone");
            %>
<!DOCTYPE html>
<html>
   <% PizzaOrder order= (PizzaOrder)request.getAttribute("order"); %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display Order</title>
    </head>
    <body>
        <h1>Welcome to my Pizza Ordering App!</h1>
        
        <h2>
           <% out.println(name); %> total $ <% out.println(order.getPrice()); %>
        </h2>
        <h3>
            Your pizza will be ready for pickup in
            <% 
            if(order.isDelivery() == true){
                out.print(" 40 minutes");
            }else{
                out.print("20 minutes");
            }
            %>
        </h3>
        <h3>
            <% out.print(order.getSize()); %>
            pizza with <br>
                <%  
//                 if (order.getToppings() ==null){
//                    out.println("no toppings");
//                 }else
//                  out.write(Arrays.toString(order.getToppings()));
//                 }
                if (order.getToppings() ==null){
                     out.println("no toppings");
                }else{
                     for(int x=0;x<order.getToppings().length;x++){
                %> 
                <br>
                <%
                          out.println(order.getToppings()[x].toString());
                     }
                }
                  
            
                %>
            
        </h3>
        
        
       
        
           </body>
</html>
