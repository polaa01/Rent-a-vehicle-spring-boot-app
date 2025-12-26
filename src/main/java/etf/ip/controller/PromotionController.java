package etf.ip.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import etf.ip.entity.*;
import etf.ip.entity.*;
import etf.ip.service.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/promotions")
public class PromotionController {
	
	@Autowired
	private PromotionService promotionService;
	
	@GetMapping
	public List<Promotion> getAllPromotions()
	{
		return promotionService.getAllPromotions();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Promotion> getPromotionById(@PathVariable Long id)
	{
		Optional<Promotion> promo = promotionService.getPromotionById(id);
		return promo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

}
