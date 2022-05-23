package com.osmanforhad.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Programmer {

	//define variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pId;
	@Column(name = "programmer_name")
	private String pName;
	private String pLang;
	
	//no argument constructor method
	public Programmer() {
		super();
	}
	
	//argument constructor method
	public Programmer(int pId, String pName, String pLang) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pLang = pLang;
	}
	
	//getter and setter methods
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public String getpLang() {
		return pLang;
	}
	public void setpLang(String pLang) {
		this.pLang = pLang;
	}
	
	//default to string method
	public String toString() {
		return "Programmer [pId=" + pId + ", pName=" + pName + ", pLang=" + pLang + "]";
	}
	
}
