package com.example.lab2.Config.Entities;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@NamedQueries({
        @NamedQuery(name = "Customer.findAll", query = "select a from Customer a"),
        @NamedQuery(name = "Customer.findById", query = "select a from Customer a where a.id = :id"),
        @NamedQuery(name = "Customer.deleteById", query = "delete from Customer a where a.id = :id")
})

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "surname")
    String surname;
    @Column(name = "name")
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

    /**
     * Method for returning customer id
     * @return customer id
     */

    public int getId(){ return id; }
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
