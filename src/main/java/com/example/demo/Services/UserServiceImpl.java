package com.example.demo.Services;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repositories.UserRepo;
import com.example.demo.binding.LoginData;
import com.example.demo.binding.Registration;
import com.example.demo.entities.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private HttpSession httpSession;


	@Override
	public boolean saveUserData(Registration registration) {
		User user=new User();
		BeanUtils.copyProperties(registration, user);
		userRepo.save(user);
		return true;
	}

	@Override
	public boolean verifyUserData(LoginData loginData) {
		boolean flag=false;
		User user=userRepo.findByUserEmail(loginData.getUserEmail());
		if(user.getPassword().equals(loginData.getPassword())) {
			httpSession.setAttribute("userId", user.getUserId());
			flag=true;
		}
		return flag;
	}
	
	

}
