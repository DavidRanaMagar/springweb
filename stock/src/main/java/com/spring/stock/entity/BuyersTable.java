
package com.spring.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="buyers_table")
public class BuyersTable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String userEmail;
    private String stockCode;
    private double boughtPrice;
    private int stockVolume;
    @Column(columnDefinition="TIMESTAMP")
    private String date;
    private boolean status;
    public BuyersTable() {
    }
    
    
    public BuyersTable(int id, String userEmail, String stockCode, double boughtPrice, int stockVolume, String date,boolean status) {
        this.id = id;
        this.userEmail = userEmail;
        this.stockCode = stockCode;
        this.boughtPrice = boughtPrice;
        this.stockVolume = stockVolume;
        this.date = date;
        this.status = status;
    }

    public BuyersTable(String userEmail, String stockCode, double boughtPrice, int stockVolume, String date,boolean status) {
        this.userEmail = userEmail;
        this.stockCode = stockCode;
        this.boughtPrice = boughtPrice;
        this.stockVolume = stockVolume;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public double getBoughtPrice() {
        return boughtPrice;
    }

    public void setBoughtPrice(double boughtPrice) {
        this.boughtPrice = boughtPrice;
    }

    public int getStockVolume() {
        return stockVolume;
    }

    public void setStockVolume(int stockVolume) {
        this.stockVolume = stockVolume;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
