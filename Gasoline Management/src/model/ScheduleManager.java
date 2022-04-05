/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author judy
 */
public class ScheduleManager implements Serializable {
    private String managerID1, managerID2;
    private Date date;
    
    public ScheduleManager(Date date, String managerID1, String managerID2) {
        this.date = date;
        this.managerID1 = managerID1;
        this.managerID2 = managerID2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getManagerID1() {
        return managerID1;
    }

    public void setManagerID1(String managerID1) {
        this.managerID1 = managerID1;
    }

    public String getManagerID2() {
        return managerID2;
    }

    public void setManagerID2(String managerID2) {
        this.managerID2 = managerID2;
    }
    
}
