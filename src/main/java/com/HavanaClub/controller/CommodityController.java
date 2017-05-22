package com.HavanaClub.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.HavanaClub.entity.Commodity;
import com.HavanaClub.service.CommodityService;

@Controller
public class CommodityController {

	@Autowired
	private CommodityService commodityService;

	@GetMapping("/commodity")
	public String commodity(Model model) {

		model.addAttribute("commodities", commodityService.findAll());

		return "commodity";

	}

	@PostMapping("/commodity")
	public String commodity(@RequestParam String someDate) {

		Commodity commodity = new Commodity(LocalDate.now());

		commodity.setEndDate(commodity.getStartDate().plusMonths(3));

		commodityService.save(commodity);

		return "redirect:/commodity";
	}

}
