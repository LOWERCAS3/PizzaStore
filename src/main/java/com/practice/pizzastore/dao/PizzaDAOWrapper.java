package com.practice.pizzastore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.practice.pizzastore.bean.PizzaBean;
import com.practice.pizzastore.bean.PizzaOrderBean;
import com.practice.pizzastore.entity.PizzaEntity;
import com.practice.pizzastore.entity.PizzaOrderEntity;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(value = "txManager")
public class PizzaDAOWrapper {
    
    @Autowired 
    private PizzaDAO pizzaDAO;

    @Autowired
    private PizzaOrderDAO pizzaOrderDAO;

    @PersistenceContext
    EntityManager entityManager;

    public List<PizzaBean> findAllPizzaDetails(){
        List<PizzaBean> list = new ArrayList<PizzaBean>();
        List<PizzaEntity> listEntity = new ArrayList<PizzaEntity>();
        for(PizzaEntity pizzaEntity : listEntity){
            PizzaBean pizzaBean = convertPizzaOrderEntityToBean(pizzaEntity);
            list.add(pizzaBean);
        }
        return list;
    }

    public PizzaOrderBean addPizzaOrderDetails( PizzaOrderBean pizzaOrderBean){
        return null;
    }

    public double getPizzaPrice(int pizzaId){
        return 0;
    }
    public List<PizzaOrderBean> getOrderDetails(double fromBill, double toBill){
        return null;
    }

    //Utility methods
    public static PizzaOrderEntity convertPizzaOrderBeantoEntity(PizzaOrderBean bean){
        PizzaOrderEntity entity = new PizzaOrderEntity();
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }

    public static PizzaOrderBean convertPizzaOrderEntityToBean(PizzaOrderEntity entity){
        PizzaOrderBean bean = new PizzaOrderBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }
    public static PizzaEntity convertPizzaBeantoEntity(PizzaBean bean){
        PizzaEntity entity = new PizzaEntity();
        BeanUtils.copyProperties(bean, entity);
        return entity;
    }

    public static PizzaBean convertPizzaOrderEntityToBean(PizzaEntity entity){
        PizzaBean bean = new PizzaBean();
        BeanUtils.copyProperties(entity, bean);
        return bean;
    }
}
