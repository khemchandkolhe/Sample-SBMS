package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.service.StockPriceService;

@RestController
@RequestMapping("/price")
public class StockPriceServiceRestController {
	@Autowired
	private StockPriceService service;

	@GetMapping("/getPrice/{name}")
	public ResponseEntity<Double> getPrice(@PathVariable("name")String companyName)
	{
		Double stockPrice = service.getStockPrice(companyName);
		
		return new ResponseEntity<>(stockPrice, HttpStatus.OK);
	}
}
