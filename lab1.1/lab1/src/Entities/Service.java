package Entities;

public class Service {

    int id;
    String description;
    int qualification;
    int amount_workers;

    /**
     * Method of Service
     * @param id - id
     * @param description - description of service
     * @param qualification - qualification of workers
     * @param amount_workers - amount of workers
     */
    public Service(int id, String description, int qualification, int amount_workers){
        this.id = id;
        this.description = description;
        this.qualification = qualification;
        this.amount_workers = amount_workers;
    }

    /**
     * Method for return service id
     * @return service id
     */
    public int getIdService(){
        return id;
    }

    /**
     * Method for return description
     * @return description
     */
    public String getDescriptionService(){
        return description;
    }

    /**
     * Method for return qualification of workers
     * @return qualification
     */
    public int getQualificationService() {
        return qualification;
    }

    /**
     * Method for return amount of workers
     * @return amount of workers
     */
    public int getAmountWorkersService() {
        return amount_workers;
    }

    /**
     * Get customer object as string
     * @return string
     */
    @Override
    public String toString() {
        return String.format("Service: { id: %d, description: %s, qualification: %d, amount_workers: %d };", this.id, this.description, this.qualification, this.amount_workers);
    }
}
