package com.example.lab2.Config.DAOs;

import com.example.lab2.Config.Entities.Customer;
import com.example.lab2.Config.Entities.Orders;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orders.class)
public abstract class OrdersCriteria {
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, Integer> id_customer;
    public static volatile SingularAttribute<Customer, Integer> id_task;
    public static volatile SingularAttribute<Customer, Integer> price;
    public static volatile SingularAttribute<Customer, Integer> paid;

    public static final String ID = "id";
    public static final String ID_CUSTOMER = "id_customer";
    public static final String ID_TASK = "id_task";
    public static final String PRICE = "price";
    public static final String PAID = "paid";
}
