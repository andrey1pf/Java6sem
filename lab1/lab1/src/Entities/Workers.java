package Entities;

public class Workers {
    int id;
    int qualification;
    float salary;
    int employment;

    public Workers(int id, int qualification, float salary, int employment){
        this.id = id;
        this.qualification = qualification;
        this.salary = salary;
        this.employment = employment;
    }

    public int getIdWorkers(){
        return id;
    }

    public int getQualificationWorkers() {
        return qualification;
    }

    public float getSalaryWorkers() {
        return salary;
    }

    public int getEmploymentWorkers() {
        return employment;
    }

    @Override
    public String toString() {
        return String.format("Workers: { id: %d, qualification: %d, salary: %f, employment: %d };", this.id, this.qualification, this.salary, this.employment);
    }

}
