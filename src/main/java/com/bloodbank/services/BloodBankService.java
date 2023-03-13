package com.bloodbank.services;

import java.util.List;

import com.bloodbank.entities.BloodBank;
import com.bloodbank.entities.BloodBankStock;
import com.bloodbank.enums.BloodComponent;
import com.bloodbank.enums.BloodGroup;
import com.bloodbank.models.BloodBankStaockSummary;

public interface BloodBankService {
	public BloodBank registerBloodBank(BloodBank bloodBank);
	public BloodBank updateBloodBank(BloodBank bloodBank);
	public BloodBank deleteBloodBank(BloodBank bloodBank);
	
	public List<BloodBankStaockSummary> getBloodBankStaockSummary(List<Long> bloodBankIds);
	public List<BloodBankStaockSummary> getBloodBankStaockSummary(Long bloodBankId,BloodGroup bloodGroup, BloodComponent bloodComponent);
	public List<BloodBankStaockSummary> getBloodBankStaockSummary(List<Long> bloodBankIds,BloodGroup bloodGroup, BloodComponent bloodComponent);
	
	public List<BloodBankStock> getBloodBankStocks(Long bloodBankId);
	public boolean updateBloodBankStocks(Long bloodBankId, BloodBankStock bloodBankStock);
	public boolean deleteBloodBankStocks(Long bloodBankId, Long bloodBankStockId);
}
