/*
 * This is the model file, it will be used to create the objects in the assignment
 * It will also calculate the price of the pizza
 */
package com.mycompany.luka_necajev_a1.model;

/**
 *
 * @author Gunar
 */
public class PizzaOrder {

    private String[] toppings;
    private String size;
    private boolean delivery;

    public PizzaOrder() {
    }

    /**
     * @return gets the toppings in a String array
     */
    public String[] getToppings() {

        return toppings;
    }

    /**
     * @param toppings sets the values taken from the StartOrder.java page
     */
    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    /**
     * @return the size of the pizza
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size sets the size of the pizza
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * @return returns if they want the delivery is true or false
     */
    public boolean isDelivery() {
        return delivery;
    }

    /**
     * @param delivery the delivery to set
     */
    public void setDelivery(boolean delivery) {
        this.delivery = delivery;
    }

    public double getPrice() {
        double price = 0;
        //if they get a small, add 5$ to the price, if medium add7$
        // if they get a large add 9$
        if (size.equals("small")) {
            price += 5;
        } else if (size.equals("medium")) {
            price += 7;
        } else {
            price += 9;
        }
        //if they are delivering, then add 2 for a delivery fee
        if (delivery == true) {
            price += 2;
        }

        if (toppings != null) {
            for (int x = 0; x < toppings.length; x++) {
                price = price + 1;
            }
        }
        return price;
    }

}
