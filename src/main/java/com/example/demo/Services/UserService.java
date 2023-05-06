package com.example.demo.Services;

import com.example.demo.binding.LoginData;
import com.example.demo.binding.Registration;

public interface UserService {

	public boolean saveUserData(Registration registration);

	public boolean verifyUserData(LoginData loginData);
}
