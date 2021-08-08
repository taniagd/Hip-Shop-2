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

	private String productName;
	@Column(precision = 8, scale = 2)
	private BigDecimal price;

	private String sku;

	private String color;

	private String size;

	private Integer quantity;
	
	private String gender;
	
	private ClothingType type;
	
	@OneToMany(mappedBy="cloth")
	@JsonManagedReference
	private List<ClothingImage> clothingImages;

	public Clothing() {
	}

	public Clothing(String productName, BigDecimal price) {
		super();
		this.productName = productName;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setPruductName(String name) {
		this.productName = name;
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

	public List<ClothingImage> getClothingImages() {
		return clothingImages;
	}

	public void setClothingImages(List<ClothingImage> clothingImages) {
		this.clothingImages = clothingImages;
	}
	
	
	
	public void setType(ClothingType type) {
		this.type = type;
	}

	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
	
}
