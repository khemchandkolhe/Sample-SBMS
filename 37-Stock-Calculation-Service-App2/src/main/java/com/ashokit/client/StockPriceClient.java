package com.ashokit.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="STOCK-PRICE-SERVICE")
public interface StockPriceClient {
	@GetMapping(value = "/price/getPrice/{name}")
	public ResponseEntity<Double> invokedStockPriceService(@PathVariable("name")String companyName);
	

}
