package etf.ip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.ip.entity.Manufacturer;
import etf.ip.entity.Promotion;
import etf.ip.repository.*;
@Service
public class PromotionService {
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	
	public List<Promotion> getAllPromotions()
	{
		return promotionRepository.findAll();
	}
	
	
	public Optional<Promotion> getPromotionById (Long id)
	{
		return promotionRepository.findById(id);
	}

}
