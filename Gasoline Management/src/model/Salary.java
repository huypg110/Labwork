/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author judy
 */
public class Salary implements Serializable {
    private int month;
    private String year, managerSalary1, managerSalary2, staffSalary1, staffSalary2, staffSalary3, staffSalary4, staffSalary5;

    public Salary(String year, int month, String managerSalary1, String managerSalary2, String staffSalary1, String staffSalary2, String staffSalary3, String staffSalary4, String staffSalary5) {
        this.year = year;
        this.month = month;
        this.managerSalary1 = managerSalary1;
        this.managerSalary2 = managerSalary2;
        this.staffSalary1 = staffSalary1;
        this.staffSalary2 = staffSalary2;
        this.staffSalary3 = staffSalary3;
        this.staffSalary4 = staffSalary4;
        this.staffSalary5 = staffSalary5;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    
    public int getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public String getManagerSalary1() {
        return managerSalary1;
    }

    public void setManagerSalary1(String managerSalary1) {
        this.managerSalary1 = managerSalary1;
    }

    public String getManagerSalary2() {
        return managerSalary2;
    }

    public void setManagerSalary2(String managerSalary2) {
        this.managerSalary2 = managerSalary2;
    }

    public String getStaffSalary1() {
        return staffSalary1;
    }

    public void setStaffSalary1(String staffSalary1) {
        this.staffSalary1 = staffSalary1;
    }

    public String getStaffSalary2() {
        return staffSalary2;
    }

    public void setStaffSalary2(String staffSalary2) {
        this.staffSalary2 = staffSalary2;
    }

    public String getStaffSalary3() {
        return staffSalary3;
    }

    public void setStaffSalary3(String staffSalary3) {
        this.staffSalary3 = staffSalary3;
    }

    public String getStaffSalary4() {
        return staffSalary4;
    }

    public void setStaffSalary4(String staffSalary4) {
        this.staffSalary4 = staffSalary4;
    }

    public String getStaffSalary5() {
        return staffSalary5;
    }

    public void setStaffSalary5(String staffSalary5) {
        this.staffSalary5 = staffSalary5;
    }
    
    
}
