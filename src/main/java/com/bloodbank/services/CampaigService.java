package com.bloodbank.services;

import com.bloodbank.entities.Campaign;

public interface CampaigService {
	public Campaign createNewCampaign(Campaign campaign);
	public boolean updateCampaign(Campaign campaign);
	public boolean deleteCampaign(Long campId);
}
