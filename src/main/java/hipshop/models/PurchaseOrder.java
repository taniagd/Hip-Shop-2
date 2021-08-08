package hipshop.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class PurchaseOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Float total;
	
	@ManyToOne
	private Member user;
	
	@OneToMany(mappedBy="orderId")
	@JsonManagedReference
	private List<PurchaseOrderItem> purchaseOrderItem;
	
	@Column(length = 150)
	private String address;
	
	@Column(length = 100)
	private String guideNumber; 
	
	private String packageStatus;
	

	public PurchaseOrder() {
	}
	
	

	public PurchaseOrder(Float total, Member user) {
		super();
		this.total = total;
		this.user = user;
	}



	public PurchaseOrder(Float total, Member user, List<PurchaseOrderItem> purchaseOrderItem, String address) {
		super();
		this.total = total;
		this.user = user;
		this.purchaseOrderItem = purchaseOrderItem;
		this.address = address;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Member getUser() {
		return user;
	}

	public void setUser(Member user) {
		this.user = user;
	}



	public List<PurchaseOrderItem> getPurchaseOrderItem() {
		return purchaseOrderItem;
	}



	public void setPurchaseOrderItem(List<PurchaseOrderItem> purchaseOrderItem) {
		this.purchaseOrderItem = purchaseOrderItem;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getGuideNumber() {
		return guideNumber;
	}



	public void setGuideNumber(String guideNumber) {
		this.guideNumber = guideNumber;
	}



	public String getPackageStatus() {
		return packageStatus;
	}



	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}


	
}
