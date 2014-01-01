package EletroStore.entity;

// Generated Dec 31, 2013 1:56:48 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Uservoteproduct generated by hbm2java
 */
@Entity
@Table(name = "uservoteproduct", catalog = "bestbuy")
public class Uservoteproduct implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6596074260285767254L;
	private Integer voteid;
	private User user;
	private Product product;
	private Integer star;
	private Date datetime;

	public Uservoteproduct() {
	}

	public Uservoteproduct(User user, Product product, Integer star,
			Date datetime) {
		this.user = user;
		this.product = product;
		this.star = star;
		this.datetime = datetime;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "voteid", unique = true, nullable = false)
	public Integer getVoteid() {
		return this.voteid;
	}

	public void setVoteid(Integer voteid) {
		this.voteid = voteid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid")
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "star")
	public Integer getStar() {
		return this.star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetime", length = 19)
	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

}
