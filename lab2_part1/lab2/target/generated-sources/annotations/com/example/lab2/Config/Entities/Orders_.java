package com.example.lab2.Config.Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Orders.class)
public abstract class Orders_ {

	public static volatile SingularAttribute<Orders, Customer> id_customer;
	public static volatile SingularAttribute<Orders, Float> price;
	public static volatile SingularAttribute<Orders, Integer> paid;
	public static volatile SingularAttribute<Orders, Service> id_task;
	public static volatile SingularAttribute<Orders, Integer> id;

	public static final String ID_CUSTOMER = "id_customer";
	public static final String PRICE = "price";
	public static final String PAID = "paid";
	public static final String ID_TASK = "id_task";
	public static final String ID = "id";

}

