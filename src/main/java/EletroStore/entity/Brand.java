package EletroStore.entity;

// Generated Dec 31, 2013 1:56:48 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Brand generated by hbm2java
 */
@Entity
@Table(name = "brand", catalog = "bestbuy")
public class Brand implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 915307297729474913L;
	private Integer brandid;
	private String brandname;
	private String brandimage;
	private Set<Product> products = new HashSet<Product>(0);

	public Brand() {
	}

	public Brand(String brandname) {
		this.brandname = brandname;
	}

	public Brand(String brandname, String brandimage, Set<Product> products) {
		this.brandname = brandname;
		this.brandimage = brandimage;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "brandid", unique = true, nullable = false)
	public Integer getBrandid() {
		return this.brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	@Column(name = "brandname", nullable = false, length = 45)
	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	@Column(name = "brandimage", length = 45)
	public String getBrandimage() {
		return this.brandimage;
	}

	public void setBrandimage(String brandimage) {
		this.brandimage = brandimage;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
