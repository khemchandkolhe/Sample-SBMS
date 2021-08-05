package com.ashokit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class StockUiService {

	public String getTotalStockPrice(String companyName, Integer qty) {
		String REST_ENDPOINTURL = "http://localhost:4444/api/calc/calculatePrice/calculate/{companyName}/{qty}";
		String response = null;

		WebClient webClient = WebClient.create();
		try {
			response = webClient.get()
					.uri(REST_ENDPOINTURL, companyName, qty)
					.retrieve().
					bodyToMono(String.class)
					.block();
		} catch (Exception e) {
			e.printStackTrace();
			response = "Company Name Not Available in DB";
		}
		return response;

	}

}
