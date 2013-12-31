package EletroStore.beanform;

import org.springframework.web.multipart.MultipartFile;


public class ProductBean{
	private Integer categoryID;
	private Integer brandID;
	private Integer conditionID;
	private String productname;
	private Float price;
	private String model;
	private String description;
	private Integer warranty;
	private Float rating;
	private MultipartFile image1;
	private MultipartFile image2;
	private Float tax;
	private Integer quantity;
	private Integer quantityforsell;
	private String specifications;
	private String features;
	/**
	 * @return the catagoryID
	 */
	public Integer getCategoryID() {
		return categoryID;
	}
	/**
	 * @param catagoryID the catagoryID to set
	 */
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	/**
	 * @return the brandID
	 */
	public Integer getBrandID() {
		return brandID;
	}
	/**
	 * @param brandID the brandID to set
	 */
	public void setBrandID(Integer brandID) {
		this.brandID = brandID;
	}
	/**
	 * @return the conditionID
	 */
	public Integer getConditionID() {
		return conditionID;
	}
	/**
	 * @param conditionID the conditionID to set
	 */
	public void setConditionID(Integer conditionID) {
		this.conditionID = conditionID;
	}
	private Float dealprice;
	private Integer productviews;
	private Integer totalbuyer;
	/**
	 * @return the productname
	 */
	public String getProductname() {
		return productname;
	}
	/**
	 * @return the catagoryID
	 */
	/**
	 * @param productname the productname to set
	 */
	public void setProductname(String productname) {
		this.productname = productname;
	}
	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the warranty
	 */
	public Integer getWarranty() {
		return warranty;
	}
	/**
	 * @param warranty the warranty to set
	 */
	public void setWarranty(Integer warranty) {
		this.warranty = warranty;
	}
	/**
	 * @return the rating
	 */
	public Float getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Float rating) {
		this.rating = rating;
	}
	/**
	 * @return the image1
	 */
	public MultipartFile getImage1() {
		return image1;
	}
	/**
	 * @param image1 the image1 to set
	 */
	public void setImage1(MultipartFile image1) {
		this.image1 = image1;
	}
	/**
	 * @return the image2
	 */
	public MultipartFile getImage2() {
		return image2;
	}
	/**
	 * @param image2 the image2 to set
	 */
	public void setImage2(MultipartFile image2) {
		this.image2 = image2;
	}
	/**
	 * @return the tax
	 */
	public Float getTax() {
		return tax;
	}
	/**
	 * @param tax the tax to set
	 */
	public void setTax(Float tax) {
		this.tax = tax;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the quantityforsell
	 */
	public Integer getQuantityforsell() {
		return quantityforsell;
	}
	/**
	 * @param quantityforsell the quantityforsell to set
	 */
	public void setQuantityforsell(Integer quantityforsell) {
		this.quantityforsell = quantityforsell;
	}
	/**
	 * @return the specifications
	 */
	public String getSpecifications() {
		return specifications;
	}
	/**
	 * @param specifications the specifications to set
	 */
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	/**
	 * @return the features
	 */
	public String getFeatures() {
		return features;
	}
	/**
	 * @param features the features to set
	 */
	public void setFeatures(String features) {
		this.features = features;
	}
	/**
	 * @return the dealprice
	 */
	public Float getDealprice() {
		return dealprice;
	}
	/**
	 * @param dealprice the dealprice to set
	 */
	public void setDealprice(Float dealprice) {
		this.dealprice = dealprice;
	}
	/**
	 * @return the productviews
	 */
	public Integer getProductviews() {
		return productviews;
	}
	/**
	 * @param productviews the productviews to set
	 */
	public void setProductviews(Integer productviews) {
		this.productviews = productviews;
	}
	/**
	 * @return the totalbuyer
	 */
	public Integer getTotalbuyer() {
		return totalbuyer;
	}
	/**
	 * @param totalbuyer the totalbuyer to set
	 */
	public void setTotalbuyer(Integer totalbuyer) {
		this.totalbuyer = totalbuyer;
	}

}