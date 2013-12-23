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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Condition generated by hbm2java
 */
@Entity
@Table(name = "condition", catalog = "bestbuy")
public class Condition implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2735514987752540333L;
	private Integer conditionid;
	private String conditionname;
	private Set<Products> productses = new HashSet<Products>(0);

	public Condition() {
	}

	public Condition(String conditionname, Set<Products> productses) {
		this.conditionname = conditionname;
		this.productses = productses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "conditionid", unique = true, nullable = false)
	public Integer getConditionid() {
		return this.conditionid;
	}

	public void setConditionid(Integer conditionid) {
		this.conditionid = conditionid;
	}

	@Column(name = "conditionname", length = 45)
	public String getConditionname() {
		return this.conditionname;
	}

	public void setConditionname(String conditionname) {
		this.conditionname = conditionname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "condition")
	public Set<Products> getProductses() {
		return this.productses;
	}

	public void setProductses(Set<Products> productses) {
		this.productses = productses;
	}

}