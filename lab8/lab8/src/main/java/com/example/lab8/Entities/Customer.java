package com.example.lab8.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {

    int id;
    String surname;
    String name;

    /**
     * Method for Customer
     * @param id - id
     * @param surname - surname
     * @param name - name
     */
    public Customer(int id, String surname, String name){
        this.id = id;
        this.surname = surname;
        this.name = name;
    }

    public Customer() {

    }

    /**
     * Method for returning name of customer
     * @return customer name
     */

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method for returning surname of customer
     * @return customer surname
     */
    public String getSurname(){
        return surname;
    }
    public void setSurname(String surname) { this.surname = surname; }

    /**
     * Method for returning customer id
     * @return customer id
     */

    @Id
    public Integer getId(){ return id; }
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get customer object as string
     * @return string
     */
    @Override
    public String toString() {
        return String.format("Customer: { id: %d, surname: %s, name: %s };", this.id, this.surname, this.name);
    }


}
