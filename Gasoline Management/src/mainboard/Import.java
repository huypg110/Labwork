
package mainboard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author HUY
 */
public class Import {
    private String seller2;          
    private LocalDate date2;
    private String type2;
    private String amount2;
    private String pricePerLiter2;
    private String totalPrice2;

    public Import(String seller2, LocalDate date2, String type2, String amount2, String pricePerLiter2, String totalPrice2) {
        this.seller2 = seller2;
        this.date2 = date2;
        this.type2 = type2;
        this.amount2 = amount2;
        this.pricePerLiter2 = pricePerLiter2;
        this.totalPrice2 = totalPrice2;
    }

    public Import(String seller2, String date2, String type2, String amount2, String pricePerLiter2, String totalPrice2) {
        this.seller2 = seller2;
        this.setDate2(date2);
        this.type2 = type2;
        this.amount2 = amount2;
        this.pricePerLiter2 = pricePerLiter2;
        this.totalPrice2 = totalPrice2;
    }
    
    public String getSeller2() {
        return seller2;
    }

    public void setSeller2(String seller2) {
        this.seller2 = seller2;
    }

    public LocalDate getDate2() {
        return date2;
    }

    public void setDate2(LocalDate date2) {
        this.date2 = date2;
    }
    
    public void setDate2(String date2) {
        this.date2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));    
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getAmount2() {
        return amount2;
    }

    public void setAmount2(String amount2) {
        this.amount2 = amount2;
    }

    public String getPricePerLiter2() {
        return pricePerLiter2;
    }

    public void setPricePerLiter2(String pricePerLiter2) {
        this.pricePerLiter2 = pricePerLiter2;
    }

    public String getTotalPrice2() {
        return totalPrice2;
    }

    public void setTotalPrice2(String totalPrice2) {
        this.totalPrice2 = totalPrice2;
    }
}

