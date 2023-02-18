package Entities;

public class Orders {
    int id;
    int id_customer;
    int id_task;
    float price;
    int paid;

    public Orders(int id, int id_customer, int id_task, float price, int paid){
        this.id = id;
        this.id_customer = id_customer;
        this.id_task = id_task;
        this.price = price;
        this.paid = paid;
    }

    public int getId_customer(){
        return id_customer;
    }

    public int getId_task() {
        return id_task;
    }

    public float getPrice() {
        return price;
    }

    public int getPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return String.format("Order: { id: %d, id_customer: %d, id_task: %d, price: %f, paid: %d };", this.id, this.id_customer, this.id_task, this.price, this.paid);
    }
}
