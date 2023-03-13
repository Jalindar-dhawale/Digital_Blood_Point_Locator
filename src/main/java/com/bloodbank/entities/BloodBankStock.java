package com.bloodbank.entities;

import java.util.Date;

import org.json.JSONObject;

import com.bloodbank.enums.BloodComponent;
import com.bloodbank.enums.BloodGroup;
import com.bloodbank.enums.BloodStockStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "blood_bank_stock")
public class BloodBankStock {
	@Id
	@GeneratedValue()
	private Long stockID;
	@ManyToOne
	private User donor;
	@ManyToOne
	private User recipient;
	@ManyToOne
	private BloodBank bloodBank;
	private BloodGroup bloodGroup;
	private BloodComponent bloodComponent;
	private Date entryDate;
	private Date expiryDate;
	private BloodStockStatus status;

	public Long getStockID() {
		return stockID;
	}

	public void setStockID(Long stockID) {
		this.stockID = stockID;
	}

	public User getDonor() {
		return donor;
	}

	public void setDonor(User donor) {
		this.donor = donor;
	}

	public User getRecipient() {
		return recipient;
	}

	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}

	public BloodBank getBloodBank() {
		return bloodBank;
	}

	public void setBloodBank(BloodBank bloodBank) {
		this.bloodBank = bloodBank;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public BloodComponent getBloodComponent() {
		return bloodComponent;
	}

	public void setBloodComponent(BloodComponent bloodComponent) {
		this.bloodComponent = bloodComponent;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public BloodStockStatus getStatus() {
		return status;
	}

	public void setStatus(BloodStockStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return new JSONObject(this).toString();
	}

}
