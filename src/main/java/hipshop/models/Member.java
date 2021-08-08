package hipshop.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Member{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100)
	private String firstName;

	@Column(length = 100)
	private String lastName;

	private Date dateBirth;

	@Column(length = 100)
	private String address;

	@Column(length = 50)
	private String email;

	@Column(length = 250)
	private String password;

	@Column(length = 20)
	private String phoneNumber;

	@Column(length = 30, unique = true)
	private String username;
	
	@Column(length = 30)
	private String branch; 
	
	@Column(nullable = false, columnDefinition = "VARCHAR(15) default 'USER'")
	private String role;

	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Card> cards;

	@OneToMany(mappedBy = "vendor")
	@JsonIgnore
	private List<Following> following;

	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Favorite> favorite;

	@OneToMany(mappedBy="vendor")
	@JsonManagedReference
	private List<Product> products;
	
	public Member() {
	}

	public Member(String firstName) {
		super();
		this.firstName = firstName;
	}

	public Member(String firstName, String lastName, Date dateBirth, String address, String email, String password,
			String phoneNumber, String username, List<Card> cards) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.address = address;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.cards = cards;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public List<Following> getFollowing() {
		return following;
	}

	public void setFollowing(List<Following> following) {
		this.following = following;
	}

	public List<Favorite> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<Favorite> favorite) {
		this.favorite = favorite;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateBirth=" + dateBirth
				+ ", address=" + address + ", email=" + email + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", username=" + username + ", role=" + role + ", cards=" + cards + ", following="
				+ following + ", favorite=" + favorite + ", products=" + products + "]";
	}
	
	

}
