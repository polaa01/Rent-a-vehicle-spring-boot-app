package etf.ip.entity;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.time.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Promotion {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String title;
	    private String description;
	    private LocalDate dateStart;
	    private LocalDate dateEnd;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDate getDateStart() {
			return dateStart;
		}
		public void setdateStart(LocalDate dateStart) {
			this.dateStart = dateStart;
		}
		public LocalDate getDateEnd() {
			return dateEnd;
		}
		public void setDateEnd(LocalDate dateEnd) {
			this.dateEnd = dateEnd;
		}
	    
	    

}
