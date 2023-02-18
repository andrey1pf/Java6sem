package Entities;

public class Workers {
    int id;
    int qualification;
    float salary;
    int employment;

    /**
     * Method of Workers
     * @param id - workers id
     * @param qualification - workers qualification
     * @param salary - workers salary
     * @param employment - employment of workers
     */
    public Workers(int id, int qualification, float salary, int employment){
        this.id = id;
        this.qualification = qualification;
        this.salary = salary;
        this.employment = employment;
    }

    /**
     * Method for return worker id
     * @return worker id
     */
    public int getIdWorkers(){
        return id;
    }

    /**
     * Method for return workers qualification
     * @return qualification
     */
    public int getQualificationWorkers() {
        return qualification;
    }

    /**
     * Method for return salary of workers
     * @return salary
     */
    public float getSalaryWorkers() {
        return salary;
    }

    /**
     * Method for return workers employment
     * @return employment
     */
    public int getEmploymentWorkers() {
        return employment;
    }

    /**
     * Get customer object as string
     * @return string
     */
    @Override
    public String toString() {
        return String.format("Workers: { id: %d, qualification: %d, salary: %f, employment: %d };", this.id, this.qualification, this.salary, this.employment);
    }

}
