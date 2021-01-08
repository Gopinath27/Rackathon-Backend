package com.rackathon.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rackathon.dao.ProductDetailDao;

@RestController
public class ProductDetailController {
	
	
	
	public ProductDetailController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(value="/fetchproductbystore")
	public List fetchProductbyStore(@RequestParam(name = "storeid") int storeid) {
		// Fetch all products based on Store ID
		
		ProductDetailDao productDetailDao = new ProductDetailDao();
		return productDetailDao.fetchProductbyStore(storeid);
		
	}	
	
	@GetMapping(value="/fetchproductbyproduct")
	public List fetchProductbyProduct(@RequestParam(name = "productid") int productid) {
		// Fetch all products based on Store ID
		
		ProductDetailDao productDetailDao = new ProductDetailDao();
		return productDetailDao.fetchProductbyProduct(productid);
		
	}	
	
	@GetMapping(value="/fetchproduct")
	public List fetchProduct(@RequestParam(name = "storeid") int storeid, @RequestParam(name = "productid") int productid) {
		// Fetch all products based on Store ID
		
		ProductDetailDao productDetailDao = new ProductDetailDao();
		return productDetailDao.fetchProduct(storeid, productid);
		
	}	
}
