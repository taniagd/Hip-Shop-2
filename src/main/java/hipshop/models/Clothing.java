package hipshop.models;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Clothing implements ProductType{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	@Column(precision = 8, scale = 2)
	private BigDecimal price;

	private String sku;

	private String color;

	private String size;

	private Integer quantity;
	private String gender;
	private float weigth;
	
	@OneToMany(mappedBy="cloth")
	@JsonManagedReference
	private List<ClothingImage> clothingImages;

	public Clothing() {
	}

	public Clothing(String name, BigDecimal price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getWeigth() {
		return weigth;
	}

	public void setWeigth(float weigth) {
		this.weigth = weigth;
	}

	public List<ClothingImage> getClothingImages() {
		return clothingImages;
	}

	public void setClothingImages(List<ClothingImage> clothingImages) {
		this.clothingImages = clothingImages;
	}
	
	
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
	
}
