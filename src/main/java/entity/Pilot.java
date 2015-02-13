/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Xpan
 */
@Entity
public class Pilot extends Role implements Serializable {

    private static final long serialVersionUID = 1L;
    private Double salary;
    private String position;
//    @OneToMany(mappedBy = "pilot", fetch = FetchType.EAGER)
//    private List<Pschedule> schedules;

    public Pilot() {

    }

//
//    public List<Pschedule> getSchedules() {
//        return schedules;
//    }
//
//    public void setSchedules(List<Pschedule> schedules) {
//        this.schedules = schedules;
//    }
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
}
