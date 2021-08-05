package com.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.client.StockPriceClient;

@RestController
@RequestMapping("/calculatePrice")
public class StockCalculationRestController {
	@Autowired
	private StockPriceClient stockPriceClient;
	@GetMapping(value = "/calculate/{name}/{qty}")
	public ResponseEntity<?> calculate(@PathVariable("name")String companyName,
			@PathVariable("qty")Integer qty){
		ResponseEntity<?> respEntity=null;
		try {
		
		respEntity = stockPriceClient.invokedStockPriceService(companyName);
		
		int statusValue = respEntity.getStatusCode().value();
		if(statusValue==200 && respEntity!=null) {
			
			Double stockPrice = (Double) respEntity.getBody();
			Double totalCost=stockPrice*qty;
			String resMsg="Total Cost:"+totalCost;
			return new ResponseEntity<String>(resMsg, HttpStatus.OK);
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			respEntity=new ResponseEntity<String>("Company Name Not Available", HttpStatus.BAD_REQUEST);

		} 
		
		return respEntity;
}
}
