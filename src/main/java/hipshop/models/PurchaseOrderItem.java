package hipshop.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PurchaseOrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonBackReference
	private PurchaseOrder orderId;
	
	@OneToOne
	private Product productId;
	
	private BigDecimal price;
	
	private Integer quantity;
	
	
	public PurchaseOrderItem() {
	}

	
	
	public PurchaseOrderItem(PurchaseOrder orderId, Product productId, BigDecimal price) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.price = price;
	}



	public PurchaseOrderItem(PurchaseOrder orderId, Product productId, BigDecimal price,Integer quantity) {
		this.orderId = orderId;
		this.productId = productId;
		this.price = price;
		this.quantity = quantity;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PurchaseOrder getOrderId() {
		return orderId;
	}

	public void setOrderId(PurchaseOrder orderId) {
		this.orderId = orderId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
