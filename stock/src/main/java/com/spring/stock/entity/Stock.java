
package com.spring.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="stock")
@DynamicUpdate
public class Stock {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column(nullable=false,unique=true)
    private String name;
    @Column(nullable=false,unique=true)
    private String code;
    @Column(nullable=false)
    private double previousClose;
    @Column(nullable=false)
    private double todayOpen;
    @Column(nullable=false)
    private double currentRate;
    @Column(nullable=false)
    private double bidPrice;
    @Column(nullable=false)
    private int bidVolume;
    @Column(nullable=false)
    private double askPrice;
    @Column(nullable=false)
    private int askVolume;
    @Column(nullable=false)
    private int marketVolume;
    @Column(nullable=false)
    private double marketCap;
    
    public Stock() {
    }

	public Stock(int id, String name, String code, double previousClose, double todayOpen, double currentRate,
			double bidPrice, int bidVolume, double askPrice, int askVolume, int marketVolume, double marketCap) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.previousClose = previousClose;
		this.todayOpen = todayOpen;
		this.currentRate = currentRate;
		this.bidPrice = bidPrice;
		this.bidVolume = bidVolume;
		this.askPrice = askPrice;
		this.askVolume = askVolume;
		this.marketVolume = marketVolume;
                this.marketCap = marketCap;
	}

	public Stock(String name, String code, double previousClose, double todayOpen, double currentRate, double bidPrice,
			int bidVolume, double askPrice, int askVolume, int marketVolume,double marketCap) {
		super();
		this.name = name;
		this.code = code;
		this.previousClose = previousClose;
		this.todayOpen = todayOpen;
		this.currentRate = currentRate;
		this.bidPrice = bidPrice;
		this.bidVolume = bidVolume;
		this.askPrice = askPrice;
		this.askVolume = askVolume;
		this.marketVolume = marketVolume;
                this.marketCap = marketCap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPreviousClose() {
		return previousClose;
	}

	public void setPreviousClose(double previousClose) {
		this.previousClose = previousClose;
	}

	public double getTodayOpen() {
		return todayOpen;
	}

	public void setTodayOpen(double todayOpen) {
		this.todayOpen = todayOpen;
	}

	public double getCurrentRate() {
		return currentRate;
	}

	public void setCurrentRate(double currentRate) {
		this.currentRate = currentRate;
	}

	public double getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(double bidPrice) {
		this.bidPrice = bidPrice;
	}

	public int getBidVolume() {
		return bidVolume;
	}

	public void setBidVolume(int bidVolume) {
		this.bidVolume = bidVolume;
	}

	public double getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(double askPrice) {
		this.askPrice = askPrice;
	}

	public int getAskVolume() {
		return askVolume;
	}

	public void setAskVolume(int askVolume) {
		this.askVolume = askVolume;
	}

	public int getMarketVolume() {
		return marketVolume;
	}

	public void setMarketVolume(int marketVolume) {
		this.marketVolume = marketVolume;
	}

    public double getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(double marketCap) {
        this.marketCap = marketCap;
    }
    

   
    
}
