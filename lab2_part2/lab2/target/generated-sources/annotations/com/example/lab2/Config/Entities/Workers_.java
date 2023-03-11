package com.example.lab2.Config.Entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Workers.class)
public abstract class Workers_ {

	public static volatile SingularAttribute<Workers, Integer> qualification;
	public static volatile SingularAttribute<Workers, Integer> id;
	public static volatile SingularAttribute<Workers, Integer> employment;
	public static volatile SingularAttribute<Workers, Float> salary;

	public static final String QUALIFICATION = "qualification";
	public static final String ID = "id";
	public static final String EMPLOYMENT = "employment";
	public static final String SALARY = "salary";

}

