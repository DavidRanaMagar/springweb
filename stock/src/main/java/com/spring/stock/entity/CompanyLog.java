
package com.spring.stock.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="company_log")
public class CompanyLog{
	@Id
        @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String code;
        @Column(columnDefinition="TIMESTAMP")
	private String time;
	private double rate;
	private double lastClose;
	private double marketCap;
	private int volumeBought;
	private int marketVolume;
	public CompanyLog() {
	}
	
	public CompanyLog(int id, String code, String time, double rate, double lastClose, double marketCap,
			int volumeBought, int marketVolume) {
		super();
		this.id = id;
		this.code = code;
		this.time = time;
		this.rate = rate;
		this.lastClose = lastClose;
		this.marketCap = marketCap;
		this.volumeBought = volumeBought;
		this.marketVolume = marketVolume;
		
	}
	
	public CompanyLog(String code, String time, double rate, double lastClose, double marketCap,
			int volumeBought, int marketVolume) {
		super();
		this.code = code;
		this.time = time;
		this.rate = rate;
		this.lastClose = lastClose;
		this.marketCap = marketCap;
		this.volumeBought = volumeBought;
		this.marketVolume = marketVolume;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getLastClose() {
		return lastClose;
	}
	public void setLastClose(double lastClose) {
		this.lastClose = lastClose;
	}
	public double getMarketCap() {
		return marketCap;
	}
	public void setMarketCap(double marketCap) {
		this.marketCap = marketCap;
	}
	public int getVolumeBought() {
		return volumeBought;
	}
	public void setVolumeBought(int volumeBought) {
		this.volumeBought = volumeBought;
	}
	
	public int getMarketVolume() {
		return marketVolume;
	}

	public void setMarketVolume(int marketVolume) {
		this.marketVolume = marketVolume;
	}

	
}