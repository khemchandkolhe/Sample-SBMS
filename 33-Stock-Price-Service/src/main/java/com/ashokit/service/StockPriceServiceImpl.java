package com.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.entity.StockPrice;
import com.ashokit.exception.CompanyNameNotFoundException;
import com.ashokit.repository.StockPriceRepository;

@Service
public class StockPriceServiceImpl implements StockPriceService {
	@Autowired
	private StockPriceRepository stockPriceRepo;

	@Override
	public Double getStockPrice(String companyName) {
		
		StockPrice entity = stockPriceRepo.findByCompanyName(companyName);
		
		if(entity==null) {
			throw new CompanyNameNotFoundException("Company Name Not exist");
		}
		Double companyPrice = entity.getCompanyPrice();
		
		return companyPrice;
	}

}
