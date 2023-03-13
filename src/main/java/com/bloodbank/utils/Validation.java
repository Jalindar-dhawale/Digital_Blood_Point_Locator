package com.bloodbank.utils;

import com.bloodbank.entities.User;
import com.bloodbank.exceptions.CustomException;

public class Validation {
	public static Boolean userValidation(User user) throws Exception {
		switch (user.getUserType()) {
		case ADMIN: {

			break;
		}
		case BANK_ADMIN: {

			break;
		}
		case DATA_ENTRY_CLERK: {

			break;
		}
		case DONOR_OR_RECIPIENT: {

			break;
		}
		default: 
			throw CustomException.build("Unexpected value: user.getUserType" + user.getUserType());
		}
		return true;
	}
}
