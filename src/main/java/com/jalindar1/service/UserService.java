package com.jalindar1.service;

import com.jalindar1.model.UserDtls;

public interface UserService {
public UserDtls createUser(UserDtls user);
public boolean ckeckEmail(String email);
}
