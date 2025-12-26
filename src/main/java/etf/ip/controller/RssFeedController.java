package etf.ip.controller;

import org.springframework.http.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import etf.ip.entity.Promotion;
import etf.ip.entity.Publication;
import etf.ip.repository.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rss")
public class RssFeedController {
	
	@Autowired
	private PromotionRepository promotionRepository;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> getRssFeed()
	{
		String rss = generateRssFeed();
        return ResponseEntity.ok(rss);
	}
	
	
	private String generateRssFeed()
	{
		 StringBuilder rss = new StringBuilder();
	        rss.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
	        rss.append("<rss version=\"2.0\">");
	        rss.append("<channel>");
	        rss.append("<title>Publications and promotions</title>");
	        rss.append("<link>http://localhost:8080/rss</link>");
	        rss.append("<description>RSS feed about promotions and publications</description>");
	        rss.append("<language>sr</language>");

	        List<Promotion> promotions = promotionRepository.findAll();
	        List<Publication> publications = publicationRepository.findAll();
	        

	        for (Promotion p : promotions) {
	            rss.append("<item>");
	            rss.append("<title>").append(escapeXml("Promotion: " + p.getTitle())).append("</title>");
	            rss.append("<link>").append("http://localhost:8080/promotions/" + p.getId()).append("</link>");
	            rss.append("<description>").append(escapeXml(p.getDescription())).append("</description>");
	            rss.append("<pubDate>").append(formatRssDate(p.getDateStart())).append("</pubDate>");
	            rss.append("<pubDate>").append(formatRssDate(p.getDateEnd())).append("</pubDate>");
	            rss.append("</item>");
	        }

	        for (Publication pub : publications) {
	            rss.append("<item>");
	            rss.append("<title>").append(escapeXml("Publication: " + pub.getTitle())).append("</title>");
	            //rss.append("<link>").append("https://localhost:8080/publications/" + pub.getId()).append("</link>");
	            rss.append("<description>").append(escapeXml(pub.getText())).append("</description>");
	           
	            rss.append("</item>");
	        }

	        rss.append("</channel>");
	        rss.append("</rss>");
	        return rss.toString();
	}
	
	
	   private String escapeXml(String input) {
	        return input == null ? "" : input
	                .replace("&", "&amp;")
	                .replace("<", "&lt;")
	                .replace(">", "&gt;");
	    }

	    private String formatRssDate(LocalDate date) {
	        return date.atStartOfDay(ZoneId.systemDefault())
	                   .format(DateTimeFormatter.RFC_1123_DATE_TIME);
	    }

}
