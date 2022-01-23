package com.practice.pizzastore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
        PizzaOrderBean pizzaOrderBeanRet = null;
        PizzaOrderEntity pizzaOrderEntity = convertPizzaOrderBeantoEntity(pizzaOrderBean);
        pizzaOrderBeanRet = convertPizzaOrderEntityToBean(pizzaOrderDAO.save(pizzaOrderEntity));
        return pizzaOrderBeanRet;
    }
    public double getPizzaPrice(int pizzaId){
        double price = 0;
        PizzaEntity pizzaEntity =  entityManager.find(PizzaEntity.class, pizzaId);
        if(pizzaEntity != null){
            price = pizzaEntity.getPrice();
        }
        return price;
    }
    public List<PizzaOrderBean> getOrderDetails(double fromBill, double toBill){
        List<PizzaOrderBean> listPizzaOrderBean = null;
        Query query =  entityManager.createQuery("select k from PizzaOrderEntity where k.bill>=?1 and k.bill<=?2");
        query.setParameter(1, fromBill);
        query.setParameter(2, toBill);
        List<PizzaOrderEntity> listPizzaOrderEntity = query.getResultList();
        listPizzaOrderBean = new ArrayList<PizzaOrderBean>();
        for (PizzaOrderEntity entity : listPizzaOrderEntity){
            PizzaOrderBean bean = convertPizzaOrderEntityToBean(entity);
            listPizzaOrderBean.add(bean);
        }
        return listPizzaOrderBean;
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
