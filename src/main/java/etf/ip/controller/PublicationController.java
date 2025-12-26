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
@RequestMapping("/publications")
public class PublicationController {
	
	@Autowired
	private PublicationService publicationService;
	
	@GetMapping
	public List<Publication> getAllPublications()
	{
		return publicationService.getAllPublications();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Publication> getPublicationById(@PathVariable Long id)
	{
		Optional<Publication> publ = publicationService.getPublicationById(id);
		return publ.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

}
