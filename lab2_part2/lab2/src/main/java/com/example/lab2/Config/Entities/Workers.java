package com.example.lab2.Config.Entities;

import javax.persistence.*;

@Entity
@Table(name = "workers")
@NamedQueries({
        @NamedQuery(name = "Workers.findAll", query = "select a from Workers a"),
        @NamedQuery(name = "Workers.findById", query = "select a from Workers a where a.id = :id"),
        @NamedQuery(name = "Workers.deleteById", query = "delete from Workers a where a.id = :id"),
        @NamedQuery(name = "Workers.updateEmployment", query = "update Workers a SET a.employment= :em WHERE id= :id")
})
public class Workers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Workers() {

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
