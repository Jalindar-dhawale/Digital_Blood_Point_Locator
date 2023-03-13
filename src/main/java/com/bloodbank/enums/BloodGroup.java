package com.bloodbank.enums;

public enum BloodGroup {
	A_POS("A+"),
	A_NEG("A-"),
	B_POS("B+"),
	B_NEG("B-"),
	AB_POS("AB+"),
	AB_NEG("AB-"),
	O_POS("O+"),
	O_NEG("O-");
	private String name;
	private BloodGroup(String name) {
		this.name=name;
	}
	
	public String toString() {
		return this.name;
	}
	
	public BloodGroup getEnum(String name) {
		for(BloodGroup bloodGroup:BloodGroup.values()) {
			if(bloodGroup.name.equals(name)) {
				return bloodGroup;
			}
		}
		return null;
	}
}
