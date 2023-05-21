package com.example.lab8.Entities;

public class Orders {
    int id;
    Customer id_customer;

    Service id_task;
    float price;
    int paid;

    /**
     * Method for order
     * @param id - id
     * @param id_customer - foreign key of customer
     * @param id_task - foreign key of task
     * @param price - order price
     * @param paid - paid or not
     */
    public Orders(int id, Customer id_customer, Service id_task, float price, int paid){
        this.id = id;
        this.id_customer = id_customer;
        this.id_task = id_task;
        this.price = price;
        this.paid = paid;
    }

    public Orders() {

    }

    public int getId(){ return id;}

    /**
     * Method for return customer id
     * @return customer id
     */
    public int getId_customer(){
        return id_customer.id;
    }

    /**
     * Method for return task id
     * @return task id
     */
    public int getId_task() {
        return id_task.id;
    }

    /**
     * Method for return price
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Method for return paid or not
     * @return paid or not
     */
    public int getPaid() {
        return paid;
    }

    /**
     * Get customer object as string
     * @return string
     */
    @Override
    public String toString() {
        return String.format("Order: { id: %d, id_customer: %d, id_task: %d, price: %f, paid: %d };", this.id, this.id_customer, this.id_task, this.price, this.paid);
    }
}
