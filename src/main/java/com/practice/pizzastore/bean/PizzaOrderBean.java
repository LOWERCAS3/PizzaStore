package com.practice.pizzastore.bean;

public class PizzaOrderBean {
 private int orderId;
 private int pizzaId;
 private String customerName;
 private String contactNumber;
 private double bill;
 private int numberOfPiecesOrdered;
public int getOrderId() {
    return orderId;
}
public void setOrderId(int orderId) {
    this.orderId = orderId;
}
public int getPizzaId() {
    return pizzaId;
}
public void setPizzaId(int pizzaId) {
    this.pizzaId = pizzaId;
}
public String getCustomerName() {
    return customerName;
}
public void setCustomerName(String customerName) {
    this.customerName = customerName;
}
public String getContactNumber() {
    return contactNumber;
}
public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
}
public double getBill() {
    return bill;
}
public void setBill(double bill) {
    this.bill = bill;
}
public int getNumberOfPiecesOrdered() {
    return numberOfPiecesOrdered;
}
public void setNumberOfPiecesOrdered(int numberOfPiecesOrdered) {
    this.numberOfPiecesOrdered = numberOfPiecesOrdered;
}
 
 
}
