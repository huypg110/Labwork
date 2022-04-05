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
public class ScheduleStaff implements Serializable {
    private Date date;
    private String staffId1, staffId2, staffId3, staffId4, staffId5, staffId6, staffId7;

    public ScheduleStaff(Date date, String staffId1, String staffId2, String staffId3, String staffId4, String staffId5, String staffId6, String staffId7) {
        this.date = date;
        this.staffId1 = staffId1;
        this.staffId2 = staffId2;
        this.staffId3 = staffId3;
        this.staffId4 = staffId4;
        this.staffId5 = staffId5;
        this.staffId6 = staffId6;
        this.staffId7 = staffId7;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStaffId1() {
        return staffId1;
    }

    public void setStaffId1(String staffId1) {
        this.staffId1 = staffId1;
    }

    public String getStaffId2() {
        return staffId2;
    }

    public void setStaffId2(String staffId2) {
        this.staffId2 = staffId2;
    }

    public String getStaffId3() {
        return staffId3;
    }

    public void setStaffId3(String staffId3) {
        this.staffId3 = staffId3;
    }

    public String getStaffId4() {
        return staffId4;
    }

    public void setStaffId4(String staffId4) {
        this.staffId4 = staffId4;
    }

    public String getStaffId5() {
        return staffId5;
    }

    public void setStaffId5(String staffId5) {
        this.staffId5 = staffId5;
    }

    public String getStaffId6() {
        return staffId6;
    }

    public void setStaffId6(String staffId6) {
        this.staffId6 = staffId6;
    }

    public String getStaffId7() {
        return staffId7;
    }

    public void setStaffId7(String staffId7) {
        this.staffId7 = staffId7;
    }
    
    
}
