package com.rackathon.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.http.HttpException;
import org.json.JSONArray;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rackathon.dao.ProductDetailDao;

@RestController
public class ProductDetailController {
	
	
	
	public ProductDetailController() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * @GetMapping(value="/fetchproductbystore") public List
	 * fetchProductbyStore(@RequestParam(name = "storeid") int storeid) { // Fetch
	 * all products based on Store ID
	 * 
	 * ProductDetailDao productDetailDao = new ProductDetailDao(); return
	 * productDetailDao.fetchProductbyStore(storeid);
	 * 
	 * }
	 * 
	 * @GetMapping(value="/fetchproductbyproduct") public List
	 * fetchProductbyProduct(@RequestParam(name = "productid") int productid) { //
	 * Fetch all products based on Store ID
	 * 
	 * ProductDetailDao productDetailDao = new ProductDetailDao(); return
	 * productDetailDao.fetchProductbyProduct(productid);
	 * 
	 * }
	 */
	@GetMapping(value="/fetchproduct")
	public List fetchProduct(@RequestParam(name = "storeid",required = false) Integer storeid, @RequestParam(name = "productid",required = false) Integer productid) throws HttpException {
		// Fetch all products based on Store ID
		ProductDetailDao productDetailDao = new ProductDetailDao();
		
		if(storeid!=null && productid != null) {
			return productDetailDao.fetchProduct(storeid, productid);
		}
		else if(storeid!=null) {
			return productDetailDao.fetchProductbyStore(storeid);
		}
		else if (productid!=null) {
			return productDetailDao.fetchProductbyProduct(productid);
		}
		else {
			//Response.status(404);
			//throw new HttpException("Enter either storeid or productid");
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "Enter either storeid or productid");
		}

		
	}	
}
