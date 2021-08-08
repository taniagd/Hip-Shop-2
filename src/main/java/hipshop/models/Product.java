package hipshop.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.MetaValue;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence")
	@SequenceGenerator(name = "product_sequence", sequenceName = "product_sequence", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Any(metaColumn = @Column(name = "productType"))
	@AnyMetaDef(idType = "long", metaType = "string", metaValues = {
			@MetaValue(targetEntity = Album.class, value = "album"),
			@MetaValue(targetEntity = Clothing.class, value = "clothing"),
			@MetaValue(targetEntity = Workshop.class, value = "workshop") })
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@JoinColumn(name = "productId")
	private ProductType product;
	@ManyToOne
	@JsonBackReference
	private Member vendor;


	public Product() {

	}

	public Product(ProductType product, Member vendor) {
		this.product = product;
		this.vendor = vendor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProductType getProduct() {
		return product;
	}

	public void setProduct(ProductType product) {
		this.product = product;
	}

	public Member getVendor() {
		return vendor;
	}

	public void setVendor(Member vendor) {
		this.vendor = vendor;
	}



	
	
}
