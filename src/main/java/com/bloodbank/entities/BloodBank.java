package com.bloodbank.entities;

import java.util.Date;

import org.json.JSONObject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "blood_bank")
public class BloodBank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bankId;
	private String banckNane;
	@OneToOne
	private Address bankAddress;
	private String description;
	private Date entryDate;

	public long getBankId() {
		return bankId;
	}

	public void setBankId(long bankId) {
		this.bankId = bankId;
	}

	public String getBanckNane() {
		return banckNane;
	}

	public void setBanckNane(String banckNane) {
		this.banckNane = banckNane;
	}

	public Address getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(Address bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}
}
