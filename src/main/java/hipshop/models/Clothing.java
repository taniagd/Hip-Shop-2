package hipshop.models;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Clothing implements ProductType{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", initialValue = 1, allocationSize = 1)
	private Long id;

	private String productName;
	@Column(precision = 8, scale = 2)
	private BigDecimal price;

	private String sku;

	private String color;

	private String size;

	private Integer quantity;
	
	private String gender;
	
	private ClothingType typeClothing;
	
	@Lob
	private String image;

	public Clothing() {
	}

	public Clothing(String productName, BigDecimal price, ClothingType typeClothing) {
		this.productName = productName;
		this.price = price;
		this.typeClothing = typeClothing;
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

	public String getClothingImages() {
		return image;
	}

	public void setClothingImages(String clothingImages) {
		this.image = clothingImages;
	}
	
	
	
	public void setTypeClothing(ClothingType type) {
		this.typeClothing = type;
	}
	

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ClothingType getTypeClothing() {
		return typeClothing;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
	
}
