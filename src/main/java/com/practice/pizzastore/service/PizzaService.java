package com.practice.pizzastore.service;

import java.util.List;
import java.util.Map;

import com.practice.pizzastore.bean.PizzaOrderBean;

public interface PizzaService {
    public List<PizzaOrderBean> getOrderDetails(double fromBill,double toBill) throws Exception;
    public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean );
    public Map<Integer, String> findAllPizzaDetails();
}
