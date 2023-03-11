package com.example.lab2.Config.Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract class Customer_ {

	public static volatile SingularAttribute<Customer, String> surname;
	public static volatile SingularAttribute<Customer, String> name;
	public static volatile SingularAttribute<Customer, Integer> id;

	public static final String SURNAME = "surname";
	public static final String NAME = "name";
	public static final String ID = "id";

}

