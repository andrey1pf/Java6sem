package com.example.lab2.Config.Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Service.class)
public abstract class Service_ {

	public static volatile SingularAttribute<Service, Integer> qualification;
	public static volatile SingularAttribute<Service, Integer> amount_workers;
	public static volatile SingularAttribute<Service, String> description;
	public static volatile SingularAttribute<Service, Integer> id;

	public static final String QUALIFICATION = "qualification";
	public static final String AMOUNT_WORKERS = "amount_workers";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";

}

