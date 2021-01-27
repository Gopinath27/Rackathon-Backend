package com.rackathon.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import com.rackathon.vo.LoginVO;

public class LoginDao {

	public Properties properties = new Properties();
	private static final Logger log = Logger.getLogger(LoginDao.class.getName());

	public LoginDao() {
		try {
			//properties.load(LoginDao.class.getClassLoader().getResourceAsStream("application.properties"));
			properties.setProperty("url", System.getProperty("url"));
			properties.setProperty("user", System.getProperty("user"));
			properties.setProperty("password", System.getProperty("password"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getLoginDetails(String userID,String password) {
		Connection connection;
		String response = "Error Occured";
		try {
			System.out.println("");
			//properties
			connection = DriverManager.getConnection(properties.getProperty("url"),properties);
			log.info("Database connection test: " + connection.getCatalog());
			
			
			PreparedStatement readStatement = connection.prepareStatement("SELECT * FROM login WHERE UserID = \""+userID+"\";");
			ResultSet resultSet = readStatement.executeQuery();

			if (!resultSet.next()) {
				log.info("Result Set is Empty ...");
				return "No User Found";
			}
			else {
				log.info("Result Set password : "+resultSet.getString("Password"));
				log.info("Password from request : "+password);
				if(resultSet.getString("Password").equals(password)){
					return  "Validation Successfull";
				}
				return "Enter Valid Password";
			}
			
			/*
			 * do { log.info(resultSet.getString("UserID"));
			 * log.info(resultSet.getString("Password")); }while (resultSet.next());
			 */
			/*
			 * LoginVO loginvo = new LoginVO(); return loginvo;
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
}
