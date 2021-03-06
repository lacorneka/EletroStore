package EletroStore.entity;

// Generated Dec 31, 2013 1:56:48 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "user", catalog = "bestbuy", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1155766549371193217L;
	private Integer memberid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phonenumber;
	private String zipcode;
	private Boolean enable;
	private Set<Userroles> userroleses = new HashSet<Userroles>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Wishlist> wishlists = new HashSet<Wishlist>(0);
	private Set<Uservoteproduct> uservoteproducts = new HashSet<Uservoteproduct>(
			0);

	public User() {
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public User(String firstname, String lastname, String email,
			String password, String phonenumber, String zipcode,
			Boolean enable, Set<Userroles> userroleses, Set<Comment> comments,
			Set<Orders> orderses, Set<Wishlist> wishlists,
			Set<Uservoteproduct> uservoteproducts) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phonenumber = phonenumber;
		this.zipcode = zipcode;
		this.enable = enable;
		this.userroleses = userroleses;
		this.comments = comments;
		this.orderses = orderses;
		this.wishlists = wishlists;
		this.uservoteproducts = uservoteproducts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "memberid", unique = true, nullable = false)
	public Integer getMemberid() {
		return this.memberid;
	}

	public void setMemberid(Integer memberid) {
		this.memberid = memberid;
	}

	@Column(name = "firstname", length = 45)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", length = 45)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "email", unique = true, nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false, length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phonenumber", length = 45)
	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Column(name = "zipcode", length = 5)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "enable")
	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	public Set<Userroles> getUserroleses() {
		return this.userroleses;
	}

	public void setUserroleses(Set<Userroles> userroleses) {
		this.userroleses = userroleses;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	public Set<Wishlist> getWishlists() {
		return this.wishlists;
	}

	public void setWishlists(Set<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	public Set<Uservoteproduct> getUservoteproducts() {
		return this.uservoteproducts;
	}

	public void setUservoteproducts(Set<Uservoteproduct> uservoteproducts) {
		this.uservoteproducts = uservoteproducts;
	}

}
