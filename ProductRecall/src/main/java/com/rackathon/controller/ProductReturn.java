package com.rackathon.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rackathon.dao.ProductDetailDao;
import com.rackathon.dao.ProductReturnDao;

@CrossOrigin(origins= {"http://localhost:3000","https://productrecall.azurewebsites.net","http://productrecall.azurewebsites.net"} )
@RestController
public class ProductReturn {
	
	@GetMapping(value="/fetchissueproduct")
	public List fetchIssueProduct(@RequestParam(name = "productid") int productID) {
		// Fetch all products based on Store ID
		
		ProductReturnDao productReturn = new ProductReturnDao();
		return productReturn.fetchIssueProduct(productID);
	}	

}
