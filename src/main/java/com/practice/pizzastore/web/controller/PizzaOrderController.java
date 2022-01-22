package com.practice.pizzastore.web.controller;

import java.util.Map;

import com.practice.pizzastore.bean.PizzaOrderBean;
import com.practice.pizzastore.service.PizzaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PizzaOrderController {
    
    @Autowired
    private PizzaService pizzaService;

    public ModelAndView loadSavePizza(){
        return null;
    }
    public ModelAndView addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean, BindingResult bindingResult){
        return null;
    }
    public Map<Integer, String> populatePizzaNames(){
        return null;
    }
    public ModelAndView handleAllExceptions(Exception exception){
        return null;
    }
}
