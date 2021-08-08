package hipshop.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Following {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JsonManagedReference
	private Member vendor;

	@ManyToOne
	@JsonBackReference
	private Member member;
	
	
	public Following() {
		
	}


	public Following(Member vendor, Member member) {
		this.vendor = vendor;
		this.member = member;
	}


	public Member getVendor() {
		return vendor;
	}


	public void setVendor(Member vendor) {
		this.vendor = vendor;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
