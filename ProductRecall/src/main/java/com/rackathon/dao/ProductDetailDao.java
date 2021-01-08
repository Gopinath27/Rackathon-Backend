package com.rackathon.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProductDetailDao {

	public Properties properties = new Properties();
	private static final Logger log = Logger.getLogger(ProductDetailDao.class.getName());

	public ProductDetailDao() {
		// TODO Auto-generated constructor stub
		try {
			properties.load(LoginDao.class.getClassLoader().getResourceAsStream("application.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List fetchProductbyStore(int storeID) {

		Connection connection;

		List responseList = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties);
			log.info("Database connection test: " + connection.getCatalog());

			PreparedStatement readStatement = connection
					.prepareStatement("SELECT * FROM productcatalogue WHERE StoreID = \"" + storeID + "\";");
			ResultSet resultSet = readStatement.executeQuery();

			while (resultSet.next()) {
				log.info("Inside result set While");
				int columnCount = resultSet.getMetaData().getColumnCount();
				Map<String, Object> productMap = new LinkedHashMap<>();
				for (int i = 0; i < columnCount; i++) {
					log.info("Result set Object : "+i+" :: "+resultSet.getObject(i+1));
					productMap.put(resultSet.getMetaData().getColumnLabel(i+1).toLowerCase(),
							resultSet.getObject(i+1));

				}
				log.info("Map :" + productMap);
				responseList.add(productMap);
				// response = convertToJSON(resultSet);
			}
			log.info("Inside Try :: " + responseList.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// log.info("Outside Try :: "+response.toString());
		// return response;

		return responseList;
	}

	public List fetchProductbyProduct(int productID) {

		Connection connection;

		List responseList = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties);
			log.info("Database connection test: " + connection.getCatalog());

			PreparedStatement readStatement = connection
					.prepareStatement("SELECT * FROM productcatalogue WHERE ProductID = \"" + productID + "\";");
			ResultSet resultSet = readStatement.executeQuery();

			while (resultSet.next()) {
				log.info("Inside result set While");
				int columnCount = resultSet.getMetaData().getColumnCount();
				Map<String, Object> productMap = new LinkedHashMap<>();
				for (int i = 0; i < columnCount; i++) {
					productMap.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(),
							resultSet.getObject(i + 1));

				}
				log.info("Map :" + productMap);
				responseList.add(productMap);
				// response = convertToJSON(resultSet);
			}
			log.info("Inside Try :: " + responseList.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// log.info("Outside Try :: "+response.toString());
		// return response;

		return responseList;
	}

	public List fetchProduct(int storeID, int productID) {

		Connection connection;

		List responseList = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), properties);
			log.info("Database connection test: " + connection.getCatalog());

			PreparedStatement readStatement = connection
					.prepareStatement("SELECT * FROM productcatalogue WHERE StoreID = \"" + storeID + "\""+ "AND ProductID = \""+productID+"\";");
			ResultSet resultSet = readStatement.executeQuery();

			while (resultSet.next()) {
				log.info("Inside result set While");
				int columnCount = resultSet.getMetaData().getColumnCount();
				Map<String, Object> productMap = new LinkedHashMap<>();
				for (int i = 0; i < columnCount; i++) {
					productMap.put(resultSet.getMetaData().getColumnLabel(i + 1).toLowerCase(),
							resultSet.getObject(i + 1));

				}
				log.info("Map :" + productMap);
				responseList.add(productMap);
				// response = convertToJSON(resultSet);
			}
			log.info("Inside Try :: " + responseList.toString());

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// log.info("Outside Try :: "+response.toString());
		// return response;

		return responseList;
	}

	
}
