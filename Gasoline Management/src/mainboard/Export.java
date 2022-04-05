/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainboard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author HUY
 */
public class Export {
    private String name;        // ////// Danh cho Vinh(Lam xong Import nho xoa nha): doi name sang seller  
    private LocalDate date;
    private String type;
    private String amount;
    private String pricePerLiter;
    private String totalPrice;

    public Export(String name, LocalDate date, String type, String amount, String pricePerLiter, String totalPrice) {
        this.name = name;
        this.date = date;
        this.type = type;
        this.amount = amount;
        this.pricePerLiter = pricePerLiter;
        this.totalPrice = totalPrice;
    }

    public Export(String name, String date, String type, String amount, String pricePerLiter, String totalPrice) {
        this.name = name;
        this.setDate(date);
        this.type = type;
        this.amount = amount;
        this.pricePerLiter = pricePerLiter;
        this.totalPrice = totalPrice;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void setDate(String date) {
        this.date = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));    
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPricePerLiter() {
        return pricePerLiter;
    }

    public void setPricePerLiter(String pricePerLiter) {
        this.pricePerLiter = pricePerLiter;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}

