package Entities;

public class Service {

    int id;
    String description;
    int qualification;
    int amount_workers;

    public Service(int id, String description, int qualification, int amount_workers){
        this.id = id;
        this.description = description;
        this.qualification = qualification;
        this.amount_workers = amount_workers;
    }

    public int getIdService(){
        return id;
    }

    public String getDescriptionService(){
        return description;
    }

    public int getQualificationService() {
        return qualification;
    }

    public int getAmountWorkersService() {
        return amount_workers;
    }

    @Override
    public String toString() {
        return String.format("Service: { id: %d, description: %s, qualification: %d, amount_workers: %d };", this.id, this.description, this.qualification, this.amount_workers);
    }
}
