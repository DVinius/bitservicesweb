package com.acucaradus.app.boot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acucaradus.app.models.Order;
import com.acucaradus.app.models.RollCake;

@Controller
public class HomeController {
	private List<RollCake> cakes = new ArrayList<RollCake>();
	private List<RollCake> availableCakes;
	
	public HomeController(){
		cakes.add(new RollCake(1,"Tradicional", "Leite, ovos, açúcar, goiabada.", "40,00", true));
		cakes.add(new RollCake(2,"Limão", "Leite, ovos, limão, açúcar, goiabada.", "48,00", false));
		cakes.add(new RollCake(3,"Prestígio", "Leite, chocolate, ovos, côco, açúcar.", "48,00", true));
		cakes.add(new RollCake(3,"Nutella", "Creme de avelã, ovos, açúcar.", "48,00", false));
		cakes.add(new RollCake(1,"Doce de Leite", "Doce de leite, ovos, açúcar.", "40,00", false));
		cakes.add(new RollCake(1,"Leite Ninho", "Leite Ninho, ovos, açúcar.", "40,00", false));
	}
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model, Device device){
		final boolean isNormal = device.isNormal();
		model.put("deviceType", isNormal ? "normal":"mobile");
		availableCakes = new ArrayList<RollCake>();
		for (RollCake rollCake: this.cakes){
			if (rollCake.isAvailable()){
				availableCakes.add(rollCake);
			}
		}
		model.put("cakesOrder", availableCakes);
		model.put("cakes", cakes);
		model.put("order", new Order());
		return "home";
	}
	
	@RequestMapping("/order")
	public String order(Map<String, Object> model, @ModelAttribute Order order, @RequestParam("cakeCode") int cakeCode){
		
		if (order.getCustomerName() == null || order.getCustomerName().isEmpty()){
			return "redirect:/";
		}
		
		order.setCode(String.valueOf(Math.random() * 2372354));
		for (RollCake rollcake: availableCakes){
			if (cakeCode == rollcake.getCode()){
				order.setCake(rollcake);
			}
		}
		model.put("order", order);
		return "confirmation";
	}
	
}
