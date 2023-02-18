package Entities;

public class Customer {
    int id;
    String surname;
    String name;

    public Customer(int id, String surname, String name){
        this.id = id;
        this.surname = surname;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public int getId(){ return id; }

    /**
     * Get customer object as string
     * @return string
     */
    @Override
    public String toString() {
        return String.format("Customer: { id: %d, surname: %s, name: %s };", this.id, this.surname, this.name);
    }
}
