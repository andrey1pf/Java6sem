package com.example.lab2.Config.DAOs;

import com.example.lab2.Config.Entities.Customer;
import com.example.lab2.Config.Entities.Service;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Service.class)
public abstract class ServiceCriteria {
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, String> description;
    public static volatile SingularAttribute<Customer, Integer> qualification;
    public static volatile SingularAttribute<Customer, Integer> amount_workers;

    public static final String ID = "id";
    public static final String DESCRIPTION = "description";
    public static final String QUALIFICATION = "qualification";
    public static final String AMOUNT_WORKERS = "amount_workers";
}
