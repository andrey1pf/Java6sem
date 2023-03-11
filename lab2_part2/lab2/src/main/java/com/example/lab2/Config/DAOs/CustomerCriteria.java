package com.example.lab2.Config.DAOs;


import com.example.lab2.Config.Entities.Customer;
import com.example.lab2.Config.Entities.Customer_;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Customer.class)
public abstract  class CustomerCriteria {
    public static volatile SingularAttribute<Customer, Integer> id;
    public static volatile SingularAttribute<Customer, String> surname;
    public static volatile SingularAttribute<Customer, String> name;

    public static final String ID = "id";
    public static final String SURNAME = "surname";
    public static final String NAME = "name";
}
