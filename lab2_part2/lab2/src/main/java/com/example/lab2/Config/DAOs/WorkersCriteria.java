package com.example.lab2.Config.DAOs;

import com.example.lab2.Config.Entities.Customer;
import com.example.lab2.Config.Entities.Workers;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Workers.class)
public abstract class WorkersCriteria {
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, Integer> qualification;
    public static volatile SingularAttribute<Customer, Float> salary;
    public static volatile SingularAttribute<Customer, Integer> employment;

    public static final String ID = "id";
    public static final String QUALIFICATION = "qualification";
    public static final String SALARY = "salary";
    public static final String EMPLOYMENT = "employment";
}
