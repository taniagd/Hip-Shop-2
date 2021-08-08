package hipshop.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ClothingImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String imagePath;
	
	@ManyToOne
	@JsonBackReference
	private Clothing cloth;
	
	
	public ClothingImage() {
	}


	public ClothingImage(String imagePath, Clothing cloth) {
		super();
		this.imagePath = imagePath;
		this.cloth = cloth;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public Clothing getCloth() {
		return cloth;
	}


	public void setCloth(Clothing cloth) {
		this.cloth = cloth;
	}


	
	
	
	
}
