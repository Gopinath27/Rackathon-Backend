package com.rackathon.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rackathon.dao.ProductRecallDao;

@RestController
public class ProductRecallController {

	@RequestMapping(value="/productRecall")
	public List productRecall() {
		
		ProductRecallDao productRecallDao = new ProductRecallDao();
		return productRecallDao.productRecall();
		
	}
	
	@RequestMapping(value="/viewproduct")
	public List viewProduct(@RequestParam(name = "storeid") int storeID,@RequestParam(name = "productid") int productID) {
	
		ProductRecallDao productRecallDao = new ProductRecallDao();
		return productRecallDao.viewProduct(storeID, productID);
		
	}
}
