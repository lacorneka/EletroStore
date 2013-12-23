package EletroStore.entity;

// Generated Dec 23, 2013 6:20:06 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Orderdetail generated by hbm2java
 */
@Entity
@Table(name = "orderdetail", catalog = "bestbuy")
public class Orderdetail implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2396727457443796454L;
	private Integer orderdetailid;
	private Products products;
	private Orders orders;
	private Integer quantity;

	public Orderdetail() {
	}

	public Orderdetail(Products products, Orders orders, Integer quantity) {
		this.products = products;
		this.orders = orders;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderdetailid", unique = true, nullable = false)
	public Integer getOrderdetailid() {
		return this.orderdetailid;
	}

	public void setOrderdetailid(Integer orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productid")
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderid")
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Column(name = "quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
