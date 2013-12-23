package EletroStore.entity;

// Generated Dec 23, 2013 6:20:06 AM by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Advertisement generated by hbm2java
 */
@Entity
@Table(name = "advertisement", catalog = "bestbuy")
public class Advertisement implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2607216498724582351L;
	private Integer adid;
	private String adname;
	private String addescription;
	private String adimage;

	public Advertisement() {
	}

	public Advertisement(String adname) {
		this.adname = adname;
	}

	public Advertisement(String adname, String addescription, String adimage) {
		this.adname = adname;
		this.addescription = addescription;
		this.adimage = adimage;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "adid", unique = true, nullable = false)
	public Integer getAdid() {
		return this.adid;
	}

	public void setAdid(Integer adid) {
		this.adid = adid;
	}

	@Column(name = "adname", nullable = false, length = 45)
	public String getAdname() {
		return this.adname;
	}

	public void setAdname(String adname) {
		this.adname = adname;
	}

	@Column(name = "addescription", length = 45)
	public String getAddescription() {
		return this.addescription;
	}

	public void setAddescription(String addescription) {
		this.addescription = addescription;
	}

	@Column(name = "adimage", length = 45)
	public String getAdimage() {
		return this.adimage;
	}

	public void setAdimage(String adimage) {
		this.adimage = adimage;
	}

}
