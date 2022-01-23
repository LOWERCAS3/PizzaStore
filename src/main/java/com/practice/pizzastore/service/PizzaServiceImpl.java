package com.practice.pizzastore.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.practice.pizzastore.bean.PizzaBean;
import com.practice.pizzastore.bean.PizzaOrderBean;
import com.practice.pizzastore.dao.PizzaDAOWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PizzaServiceImpl implements PizzaService{
    @Autowired
    private PizzaDAOWrapper pizzaDAOWrapper;

    @Override
    public List<PizzaOrderBean> getOrderDetails(double fromBill, double toBill) throws Exception {
        List<PizzaOrderBean> list = pizzaDAOWrapper.getOrderDetails(fromBill, toBill);
        if(list == null || list.size() == 0){
            throw new Exception("No records found for the entered bill range!!!");
        }
        return list;
    }

    @Override
    public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) {
        // Calculating pizza bill needed to create pizzaOrder 
        double price = pizzaDAOWrapper.getPizzaPrice(pizzaOrderBean.getPizzaId());
        double bill = pizzaOrderBean.getNumberOfPiecesOrdered()*price;
        pizzaOrderBean.setBill(bill);
        return pizzaOrderBean = pizzaDAOWrapper.addPizzaOrderDetails(pizzaOrderBean);
    }

    @Override
    public Map<Integer, String> findAllPizzaDetails() {
        List<PizzaBean> pizzaList = pizzaDAOWrapper.findAllPizzaDetails();
        Map<Integer, String> pizzaMap =  new HashMap<Integer, String>();
        for(PizzaBean bean : pizzaList){
            pizzaMap.put(bean.getPizzaId(), bean.getPizzaName());
        }
        return pizzaMap;
    }
    
}
