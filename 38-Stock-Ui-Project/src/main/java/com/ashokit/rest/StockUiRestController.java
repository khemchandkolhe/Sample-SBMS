package com.ashokit.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ashokit.service.StockUiService;

@Controller
public class StockUiRestController {
	@Autowired
	private StockUiService service;
	@GetMapping(value = "/load")
	public String loadForm() {
		return "stockui";
	}

	
	  @PostMapping("/getTotalCost")
	  public String handleGetTotalCostBtn(HttpServletRequest req,Model model)
	  { 
		  String cname =req.getParameter("cname");
		  int qty =Integer.parseInt(req.getParameter("qty"));
	  
	  String totalStockPrice = service.getTotalStockPrice(cname, qty);
	  
	  model.addAttribute("totalStockPrice", totalStockPrice);
	  return "stockui"; 
	  }
	  
	  
	 }
