package hipshop.models;


import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.print.attribute.standard.DateTimeAtCompleted;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Workshop implements ProductType{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	private String productName;
	
	@Lob
	private String image;

	private BigDecimal price;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date date;
	
	private String location;

	public Workshop() {
	}

	public Workshop(final String productName,final BigDecimal price) {
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

	public void setProductName(String name) {
		this.productName = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
}
