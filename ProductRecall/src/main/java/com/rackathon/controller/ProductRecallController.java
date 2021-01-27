package com.rackathon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rackathon.dao.ProductRecallDao;

@CrossOrigin(origins= {"http://localhost:3000","https://productrecall.azurewebsites.net","http://productrecall.azurewebsites.net"} )
@RestController
public class ProductRecallController {

	@RequestMapping(value="/productRecall")
	public ResponseEntity<String> productRecall(@RequestParam(name = "storeid") int storeID, @RequestParam(name = "productid") int productID, @RequestParam(name = "listbatch") List<String> batchList) {
		
		ProductRecallDao productRecallDao = new ProductRecallDao();
		if(productRecallDao.productRecall(storeID, productID, batchList)) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value="/viewproduct")
	public List viewProduct(@RequestParam(name = "storeid") int storeID,@RequestParam(name = "productid") int productID) {
	
		ProductRecallDao productRecallDao = new ProductRecallDao();
		return productRecallDao.viewProduct(storeID, productID);
		
	}
}
