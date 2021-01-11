package com.rackathon.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rackathon.dao.LoginDao;

//import com.rackathon.vo.LoginEntity;
//import com.rackathon.vo.LoginRepository;

@CrossOrigin(origins= {"http://localhost:3000"} )
@RestController
public class LoginController {
	
	//private final LoginRepository loginRepository;
	
/*	public LoginController(LoginRepository loginRepository) {
		this.loginRepository = loginRepository; 
	}*/

	@RequestMapping("/login")
	public String login(@RequestParam(name ="userid") String userID, @RequestParam(name = "password") String password){
		LoginDao logindao = new LoginDao(); 
		if (userID == null) {
			return "Enter value for userid param ";
		}
		//System.out.println("Login Succes");
		return logindao.getLoginDetails(userID,password);
	}
}
