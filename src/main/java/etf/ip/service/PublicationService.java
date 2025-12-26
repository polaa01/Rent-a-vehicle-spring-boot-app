package etf.ip.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import etf.ip.entity.Manufacturer;
import etf.ip.entity.Publication;
import etf.ip.repository.*;
@Service
public class PublicationService {
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	
	public List<Publication> getAllPublications()
	{
		return publicationRepository.findAll();
	}
	
	
	public Optional<Publication> getPublicationById (Long id)
	{
		return publicationRepository.findById(id);
	}

}