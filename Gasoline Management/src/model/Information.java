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
public class Information implements Serializable {
    private String name, ID, address, gender, position, phoneNumber;
    public int no, exe;
    private Date DoB, workFrom;
    private static int number = 1;
    
    public Information(String name, String ID, String phoneNumber, String gender, Date DoB, String address, Date workFrom, int exe, String position) {
        this.no = number++;
        this.name = name;
        this.ID = ID;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.address = address;
        this.DoB = DoB;
        this.workFrom = workFrom;
        this.exe = exe;
        this.position = position;
    }

    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public Information() {
        this.no = number++;
    }
    public static void setNumber(int number) {
        Information.number = number;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public Date getDoB() {
        return DoB;
    }
    public void setDoB(Date DoB) {
        this.DoB = DoB;
    }
    
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    
    public Date getWorkFrom() {
        return workFrom;
    }
    public void setWorkFrom(Date workFrom) {
        this.workFrom = workFrom;
    }
    
    public int getExe() {
        return exe;
    }
    public void setExe(int exe) {
        this.exe = exe;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
