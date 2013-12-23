package EletroStore.entity;

// Generated Dec 23, 2013 6:20:06 AM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name = "products", catalog = "bestbuy", uniqueConstraints = @UniqueConstraint(columnNames = "productname"))
public class Products implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8770111006625053499L;
	private Integer productid;
	private Productcatalog productcatalog;
	private Deals deals;
	private Brand brand;
	private Condition condition;
	private String productname;
	private Float price;
	private String model;
	private String description;
	private Integer warranty;
	private Float rating;
	private String image1;
	private String image2;
	private Float tax;
	private Integer quantity;
	private Integer quantityforsell;
	private String specifications;
	private String features;
	private Integer onestar;
	private Integer twostar;
	private Integer threestar;
	private Integer fourstar;
	private Integer fivestar;
	private Set<Orderdetail> orderdetails = new HashSet<Orderdetail>(0);
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Uservoteproduct> uservoteproducts = new HashSet<Uservoteproduct>(
			0);
	private Set<Wishlist> wishlists = new HashSet<Wishlist>(0);

	public Products() {
	}

	public Products(Productcatalog productcatalog, Brand brand,
			Condition condition) {
		this.productcatalog = productcatalog;
		this.brand = brand;
		this.condition = condition;
	}

	public Products(Productcatalog productcatalog, Deals deals, Brand brand,
			Condition condition, String productname, Float price, String model,
			String description, Integer warranty, Float rating, String image1,
			String image2, Float tax, Integer quantity,
			Integer quantityforsell, String specifications, String features,
			Integer onestar, Integer twostar, Integer threestar,
			Integer fourstar, Integer fivestar, Set<Orderdetail> orderdetails,
			Set<Comment> comments, Set<Uservoteproduct> uservoteproducts,
			Set<Wishlist> wishlists) {
		this.productcatalog = productcatalog;
		this.deals = deals;
		this.brand = brand;
		this.condition = condition;
		this.productname = productname;
		this.price = price;
		this.model = model;
		this.description = description;
		this.warranty = warranty;
		this.rating = rating;
		this.image1 = image1;
		this.image2 = image2;
		this.tax = tax;
		this.quantity = quantity;
		this.quantityforsell = quantityforsell;
		this.specifications = specifications;
		this.features = features;
		this.onestar = onestar;
		this.twostar = twostar;
		this.threestar = threestar;
		this.fourstar = fourstar;
		this.fivestar = fivestar;
		this.orderdetails = orderdetails;
		this.comments = comments;
		this.uservoteproducts = uservoteproducts;
		this.wishlists = wishlists;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "productid", unique = true, nullable = false)
	public Integer getProductid() {
		return this.productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productcatalog", nullable = false)
	public Productcatalog getProductcatalog() {
		return this.productcatalog;
	}

	public void setProductcatalog(Productcatalog productcatalog) {
		this.productcatalog = productcatalog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deals")
	public Deals getDeals() {
		return this.deals;
	}

	public void setDeals(Deals deals) {
		this.deals = deals;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "brand", nullable = false)
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "condition", nullable = false)
	public Condition getCondition() {
		return this.condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	@Column(name = "productname", unique = true, length = 100)
	public String getProductname() {
		return this.productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Column(name = "model", length = 50)
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Column(name = "description", length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "warranty")
	public Integer getWarranty() {
		return this.warranty;
	}

	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}

	@Column(name = "rating", precision = 12, scale = 0)
	public Float getRating() {
		return this.rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	@Column(name = "image1", length = 100)
	public String getImage1() {
		return this.image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	@Column(name = "image2", length = 100)
	public String getImage2() {
		return this.image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	@Column(name = "tax", precision = 12, scale = 0)
	public Float getTax() {
		return this.tax;
	}

	public void setTax(Float tax) {
		this.tax = tax;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Column(name = "quantityforsell")
	public Integer getQuantityforsell() {
		return this.quantityforsell;
	}

	public void setQuantityforsell(Integer quantityforsell) {
		this.quantityforsell = quantityforsell;
	}

	@Column(name = "specifications", length = 1000)
	public String getSpecifications() {
		return this.specifications;
	}

	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}

	@Column(name = "features", length = 1000)
	public String getFeatures() {
		return this.features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	@Column(name = "onestar")
	public Integer getOnestar() {
		return this.onestar;
	}

	public void setOnestar(Integer onestar) {
		this.onestar = onestar;
	}

	@Column(name = "twostar")
	public Integer getTwostar() {
		return this.twostar;
	}

	public void setTwostar(Integer twostar) {
		this.twostar = twostar;
	}

	@Column(name = "threestar")
	public Integer getThreestar() {
		return this.threestar;
	}

	public void setThreestar(Integer threestar) {
		this.threestar = threestar;
	}

	@Column(name = "fourstar")
	public Integer getFourstar() {
		return this.fourstar;
	}

	public void setFourstar(Integer fourstar) {
		this.fourstar = fourstar;
	}

	@Column(name = "fivestar")
	public Integer getFivestar() {
		return this.fivestar;
	}

	public void setFivestar(Integer fivestar) {
		this.fivestar = fivestar;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Orderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Uservoteproduct> getUservoteproducts() {
		return this.uservoteproducts;
	}

	public void setUservoteproducts(Set<Uservoteproduct> uservoteproducts) {
		this.uservoteproducts = uservoteproducts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Wishlist> getWishlists() {
		return this.wishlists;
	}

	public void setWishlists(Set<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

}