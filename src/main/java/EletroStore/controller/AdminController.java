/**
 * 
 */
package EletroStore.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import EletroStore.beanform.AdvertisementBean;
import EletroStore.beanform.BrandBean;
import EletroStore.beanform.CategoryBean;
import EletroStore.beanform.ProductBean;
import EletroStore.dao.AdvertisementDao;
import EletroStore.dao.BrandDao;
import EletroStore.dao.CategoryDao;
import EletroStore.dao.ConditionDao;
import EletroStore.dao.ProductDao;
import EletroStore.dao.UserDao;
import EletroStore.entity.Advertisement;
import EletroStore.entity.Brand;
import EletroStore.entity.Condition;
import EletroStore.entity.Product;
import EletroStore.entity.Productcatalog;
import EletroStore.entity.User;
import EletroStore.entity.Userroles;

/**
 * @author HNP
 * 
 */
@RequestMapping(value = "/admin")
@Controller
public class AdminController {

	@Autowired
	BrandDao brandDao;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	AdvertisementDao advertisementDao;
	@Autowired
	UserDao userDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	ConditionDao conditionDao;

	private static Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	@RequestMapping(value = "welcome")
	public String viewDashboard(Model model, HttpServletRequest request) {
		logger.info("Show dashboard");
		request.getSession().setAttribute("adminCurrentPage", "welcome");
		return "admin-welcome";
	}

	// BRAND ADMIN PAGES
	@RequestMapping(value = "brand")
	public String viewBrandList(Model model, HttpSession session) {
		logger.info("Show table of Brand");
		session.setAttribute("adminCurrentPage", "brand");
		List<?> brands = brandDao.getAllBrand();
		model.addAttribute("brands", brands);
		return "brand-index";
	}

	@RequestMapping(value = "addbrand")
	public String showAddBrandForm(Model model, HttpSession session) {
		logger.info("Landing in addBrand Form");
		model.addAttribute("brand", new BrandBean());
		return "brand-add";
	}

	@RequestMapping(value = "addingbrand")
	public String addNewBrand(Model model,
			@Valid @ModelAttribute("brand") BrandBean brand,
			BindingResult result, HttpServletRequest request) {
		if (brand == null) {
			logger.info("Null para");
			return "brand-index";
		}
		try {
			logger.info("Add new brand");
			if (brand.getImageFile().isEmpty()) {
				result.rejectValue("imageFile", "error.imageFile",
						"Upload failed! Try again!");
				logger.info("Upload file failed");
			}
			if (result.hasErrors()) {
				logger.info("Vadilication not met");
				return "brand-add";
			}
			MultipartFile imageFile = brand.getImageFile();
			String imageFileName = imageFile.getOriginalFilename();
			model.addAttribute("imageName", imageFileName);
			String filePath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "resources\\img\\brand\\" + imageFileName;
			logger.trace("Save Image Path:  " + filePath);
			File saveFile = new File(filePath);
			imageFile.transferTo(saveFile);
			EletroStore.entity.Brand temp = new EletroStore.entity.Brand(
					brand.getName());
			temp.setBrandimage(imageFileName);
			brandDao.attachDirty(temp);
		} catch (Exception e) {
			model.addAttribute("error", "Failed: " + e.getCause());
			logger.info("Exception " + e.getCause());
			return "brand-add";
		}
		return "redirect:brand.do";
	}

	@RequestMapping(value = "deletebrand")
	public String deleteBrand(HttpServletRequest request) {
		logger.info("Delete Brand by ID");
		String idvar = request.getParameter("deleteID");
		if (idvar != null) {
			try {
				int id = Integer.parseInt(idvar);
				brandDao.delete(brandDao.findById(id));
			} catch (Exception e) {
				logger.info("Exception: " + e.getCause());
			}
		}
		return "redirect:brand.do";
	}

	@RequestMapping(value = "editbrand")
	public String editBrandHandler(Model model, HttpServletRequest request) {
		logger.info("Edit Brand");
		BrandBean temp = new BrandBean();
		temp.setId(-1);
		model.addAttribute("brand", temp);
		return "brand-edit";
	}

	@RequestMapping(value = "editingbrand")
	public String editBrand(Model model,
			@ModelAttribute("brand") BrandBean brand, BindingResult result,
			HttpServletRequest request) {
		if (brand.getId() == -1) {
			logger.debug("Miss brand id");
			return "brand-edit";
		}
		EletroStore.entity.Brand temp = brandDao.findById(brand.getId());

		try {
			logger.info("Edit brand");
			if (!brand.getImageFile().isEmpty()) {
				MultipartFile imageFile = brand.getImageFile();
				String imageFileName = imageFile.getOriginalFilename();
				model.addAttribute("imageName", imageFileName);
				String filePath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "resources\\img\\brand\\" + imageFileName;
				File saveFile = new File(filePath);
				imageFile.transferTo(saveFile);

				temp.setBrandimage(brand.getImageFile().getOriginalFilename());
				logger.info("Change image");
			}
			if (!brand.getName().isEmpty()) {
				temp.setBrandname(brand.getName());
				logger.info("Change name");
			}
			brandDao.update(temp);
		} catch (Exception e) {
			model.addAttribute("error", "Failed: " + e.getCause());
			logger.info("Exception " + e.getCause());
			return "brand-edit";
		}
		return "redirect:brand.do";
	}

	// CATEGORY ADMIN PAGEs
	@RequestMapping(value = "category")
	public String viewCategoryList(Model model, HttpSession session) {
		logger.info("Show table of Category");
		session.setAttribute("adminCurrentPage", "category");
		List<?> categories = categoryDao.getAllCategory();
		model.addAttribute("categories", categories);
		return "category-index";
	}

	@RequestMapping(value = "addcategory")
	public String showAddCategoryForm(Model model, HttpSession session) {
		logger.info("Landing in addCategory Form");
		model.addAttribute("category", new CategoryBean());
		return "category-add";
	}

	@RequestMapping(value = "addingcategory")
	public String addNewCategory(Model model,
			@Valid @ModelAttribute("category") CategoryBean category,
			BindingResult result, HttpServletRequest request) {
		if (category == null) {
			logger.info("Null para");
			return "category-index";
		}
		try {
			logger.info("Add new category");
			if (category.getImageFile().isEmpty()) {
				result.rejectValue("imageFile", "error.imageFile",
						"Upload failed! Try again!");
				logger.info("Upload file failed");
			}
			if (result.hasErrors()) {
				logger.info("Vadilication not met");
				return "category-add";
			}
			MultipartFile imageFile = category.getImageFile();
			String imageFileName = imageFile.getOriginalFilename();
			model.addAttribute("imageName", imageFileName);
			String folderPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "resources\\img\\category\\";
			String filePath = folderPath + imageFileName;
			logger.trace("Save Image Path:  " + filePath);
			File saveFile = new File(filePath);
			File saveFolder = new File(folderPath);
			if (!saveFolder.isDirectory()) {
				saveFolder.mkdirs();
			}

			imageFile.transferTo(saveFile);
			Productcatalog temp = new Productcatalog(category.getName());
			temp.setCatalogimage(imageFileName);
			categoryDao.attachDirty(temp);
		} catch (Exception e) {
			model.addAttribute("error", "Failed: " + e.getCause());
			logger.info("Exception " + e.getCause());
			return "category-add";
		}
		return "redirect:category.do";
	}

	@RequestMapping(value = "deletecategory")
	public String deleteCategory(HttpServletRequest request) {
		logger.info("Delete Category by ID");
		String idvar = request.getParameter("deleteID");
		if (idvar != null) {
			try {
				int id = Integer.parseInt(idvar);
				categoryDao.delete(categoryDao.findById(id));
			} catch (Exception e) {
				logger.info("Exception: " + e.getCause());
			}
		}
		return "redirect:category.do";
	}

	@RequestMapping(value = "editcategory")
	public String editCategoryHandler(Model model, HttpServletRequest request) {
		logger.info("Edit Category");
		CategoryBean temp = new CategoryBean();
		temp.setId(-1);
		model.addAttribute("category", temp);
		return "category-edit";
	}

	@RequestMapping(value = "editingcategory")
	public String editCategory(Model model,
			@ModelAttribute("category") CategoryBean category,
			BindingResult result, HttpServletRequest request) {
		if (category.getId() == -1) {
			logger.debug("Miss category id");
			return "category-edit";
		}
		Productcatalog temp = categoryDao.findById(category.getId());

		try {
			logger.info("Edit category");
			if (!category.getImageFile().isEmpty()) {
				MultipartFile imageFile = category.getImageFile();
				String imageFileName = imageFile.getOriginalFilename();
				model.addAttribute("imageName", imageFileName);
				String filePath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "resources\\img\\category\\" + imageFileName;
				File saveFile = new File(filePath);
				imageFile.transferTo(saveFile);

				temp.setCatalogimage(category.getImageFile()
						.getOriginalFilename());
				logger.info("Change image");
			}
			if (!category.getName().isEmpty()) {
				temp.setCatalogname(category.getName());
				logger.info("Change name");
			}
			categoryDao.update(temp);
		} catch (Exception e) {
			model.addAttribute("error", "Failed: " + e.getCause());
			logger.info("Exception " + e.getCause());
			return "category-edit";
		}
		return "redirect:category.do";
	}

	// ADVERTISEMENT MANAGEMENT
	@RequestMapping(value = "advertisement")
	public String viewAdvertisementList(Model model, HttpSession session) {
		logger.info("Show table of Advertisement");
		session.setAttribute("adminCurrentPage", "advertisement");
		List<?> advertisements = advertisementDao.getAllAdvertisement();
		model.addAttribute("advertisements", advertisements);
		return "advertisement-index";
	}

	@RequestMapping(value = "addadvertisement")
	public String showAddAdvertisementForm(Model model, HttpSession session) {
		logger.info("Landing in addAdvertisement Form");
		model.addAttribute("advertisement", new AdvertisementBean());
		return "advertisement-add";
	}

	@RequestMapping(value = "addingadvertisement")
	public String addNewAdvertisement(
			Model model,
			@Valid @ModelAttribute("advertisement") AdvertisementBean advertisement,
			BindingResult result, HttpServletRequest request) {
		if (advertisement == null) {
			logger.info("Null para");
			return "advertisement-index";
		}
		try {
			logger.info("Add new advertisement");
			if (advertisement.getImageFile().isEmpty()) {
				result.rejectValue("imageFile", "error.imageFile",
						"Upload failed! Try again!");
				logger.info("Upload file failed");
			}
			if (result.hasErrors()) {
				logger.info("Vadilication not met");
				return "advertisement-add";
			}
			MultipartFile imageFile = advertisement.getImageFile();
			String imageFileName = imageFile.getOriginalFilename();
			model.addAttribute("imageName", imageFileName);
			String filePath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "resources\\img\\advertisement\\" + imageFileName;
			logger.trace("Save Image Path:  " + filePath);
			File saveFile = new File(filePath);
			imageFile.transferTo(saveFile);
			Advertisement temp = new Advertisement(advertisement.getName());
			temp.setAdimage(imageFileName);
			temp.setAddescription(advertisement.getDescription());
			advertisementDao.attachDirty(temp);
		} catch (Exception e) {
			model.addAttribute("error", "Failed: " + e.getCause());
			logger.info("Exception " + e.getCause());
			return "advertisement-add";
		}
		return "redirect:advertisement.do";
	}

	@RequestMapping(value = "deleteadvertisement")
	public String deleteAdvertisement(HttpServletRequest request) {
		logger.info("Delete Advertisement by ID");
		String idvar = request.getParameter("deleteID");
		if (idvar != null) {
			try {
				int id = Integer.parseInt(idvar);
				advertisementDao.delete(advertisementDao.findById(id));
			} catch (Exception e) {
				logger.info("Exception: " + e.getCause());
			}
		}
		return "redirect:advertisement.do";
	}

	@RequestMapping(value = "editadvertisement")
	public String editAdvertisementHandler(Model model,
			HttpServletRequest request) {
		logger.info("Edit Advertisement");
		AdvertisementBean temp = new AdvertisementBean();
		temp.setId(-1);
		model.addAttribute("advertisement", temp);
		return "advertisement-edit";
	}

	@RequestMapping(value = "editingadvertisement")
	public String editAdvertisement(Model model,
			@ModelAttribute("advertisement") AdvertisementBean advertisement,
			BindingResult result, HttpServletRequest request) {
		if (advertisement.getId() == -1) {
			logger.debug("Miss advertisement id");
			return "advertisement-edit";
		}
		Advertisement temp = advertisementDao.findById(advertisement.getId());

		try {
			logger.info("Edit advertisement");
			if (!advertisement.getImageFile().isEmpty()) {
				MultipartFile imageFile = advertisement.getImageFile();
				String imageFileName = imageFile.getOriginalFilename();
				model.addAttribute("imageName", imageFileName);
				String filePath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "resources\\img\\advertisement\\" + imageFileName;
				File saveFile = new File(filePath);
				imageFile.transferTo(saveFile);

				temp.setAdimage(advertisement.getImageFile()
						.getOriginalFilename());
				logger.info("Change image");
			}
			if (!advertisement.getName().isEmpty()) {
				temp.setAdname(advertisement.getName());
				logger.info("Change name");
			}
			advertisementDao.update(temp);
		} catch (Exception e) {
			model.addAttribute("error", "Failed: " + e.getCause());
			logger.info("Exception " + e.getCause());
			return "advertisement-edit";
		}
		return "redirect:advertisement.do";
	}

	// USER MANAGEMENT
	@RequestMapping(value = "user")
	public String viewUserList(Model model, HttpSession session) {
		logger.info("Show table of User");
		session.setAttribute("adminCurrentPage", "user");
		List<?> users = userDao.getAllUser();
		model.addAttribute("users", users);
		return "user-index";
	}

	@RequestMapping(value = "deleteuser")
	public String deleteUser(HttpServletRequest request) {
		logger.info("Delete User by ID");
		String idvar = request.getParameter("deleteID");
		logger.debug("IDVAR : " + idvar);
		if (idvar != null) {
			try {
				int id = Integer.parseInt(idvar);
				userDao.delete(userDao.findById(id));
			} catch (Exception e) {
				logger.info("Exception: " + e.getCause());
			}
		}
		return "redirect:user.do";
	}

	@RequestMapping(value = "edituser")
	public String editUserHandler(Model model, HttpServletRequest request) {
		logger.info("Edit User");
		String idvar = request.getParameter("editID");
		if (idvar != null) {
			try {
				int id = Integer.parseInt(idvar);
				User temp = userDao.findById(id);
				model.addAttribute("user", temp);
				return "user-edit";
			} catch (Exception e) {
				logger.info("Exception: " + e.getCause());
				model.addAttribute("error", e.getCause());
			}
		}
		return "redirect:user.do";
	}

	@RequestMapping(value = "editinguser")
	public String editUser(Model model,
			@Valid @ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) {
		String role = (String) request.getParameter("role");
		int memberid = Integer.parseInt(request.getParameter("memberid"));
		logger.debug("ROLE: " + role);
		if (role != null) {
			user = userDao.findById(memberid);
			if (!user.getUserroleses().contains(role)) {
				user.getUserroleses().add(new Userroles(user, role));
				userDao.update(user);
			}
		}

		try {
			logger.info("Edit user");
			userDao.update(user);
		} catch (Exception e) {
			model.addAttribute("error", "Failed: " + e.getCause());
			logger.info("Exception " + e.getCause());
			return "user-edit";
		}
		return "redirect:user.do";
	}

	// PRODUCT MANAGEMENT
	@RequestMapping(value = "product")
	public String viewProductList(Model model, HttpSession session) {
		logger.info("Show table of Product");
		session.setAttribute("adminCurrentPage", "product");
		List<?> products = productDao.getAllProduct();
		model.addAttribute("products", products);
		return "product-index";
	}

	@RequestMapping(value = "addproduct")
	public String showAddProductForm(Model model, HttpSession session) {
		logger.info("Landing in addProduct Form");
		List<?> brandList = brandDao.getAllBrand();
		List<?> categoryList = categoryDao.getAllCategory();
		List<?> conditionList = conditionDao.getAllCondition();
		model.addAttribute("product", new ProductBean());
		model.addAttribute("brands", brandList);
		model.addAttribute("categories", categoryList);
		model.addAttribute("conditions", conditionList);
		return "product-add";
	}

	@RequestMapping(value = "addingproduct")
	public String addNewProduct(Model model,
			@Valid @ModelAttribute("product") ProductBean product,
			BindingResult result, HttpServletRequest request) {
		if (product == null) {
			logger.info("Null Paramater");
			return "product-index";
		}
		try {
			logger.info("Add new product");
			if (product.getImage1().isEmpty() || product.getImage2().isEmpty()) {
				result.rejectValue("image1", "error.image1",
						"Upload failed! Try again!");
				result.rejectValue("image2", "error.image2",
						"Upload failed! Try again!");

				logger.info("Upload file failed");
			}

			if (product.getDealprice() != null) {
				if (product.getPrice() <= product.getDealprice()) {
					result.rejectValue("dealprice", "error.dealprice",
							"Deal price must be less than origin price");

				}
			}

			if (result.hasErrors()) {
				logger.info("Vadilication not met");
				return "redirect:addproduct.do";
			}
			String filePath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "resources\\img\\product\\";
			MultipartFile image1 = product.getImage1();
			MultipartFile image2 = product.getImage2();
			String image1Path = filePath + image1.getOriginalFilename();
			String image2Path = filePath + image2.getOriginalFilename();
			logger.trace("Save Image File");
			File saveFile1 = new File(image1Path);
			File saveFile2 = new File(image2Path);
			image1.transferTo(saveFile1);
			image2.transferTo(saveFile2);
			Brand brand = brandDao.findById(product.getBrandID());
			Productcatalog catalog = categoryDao.findById(product
					.getCategoryID());
			Condition condition = conditionDao.findById(product
					.getConditionID());
			Product temp = new Product(catalog, condition, brand);
			temp.setProductname(product.getProductname());
			temp.setModel(product.getModel());
			temp.setPrice(product.getPrice());
			temp.setDealprice(product.getDealprice());
			temp.setDescription(product.getDescription());
			temp.setTax(product.getTax());
			temp.setQuantity(product.getQuantity());
			temp.setQuantityforsell(product.getQuantityforsell());
			temp.setWarranty(product.getWarranty());
			temp.setFeatures(product.getFeatures());
			temp.setSpecifications(product.getSpecifications());
			temp.setImage1(image1.getOriginalFilename());
			temp.setImage2(image2.getOriginalFilename());
			temp.setProductviews(0);
			temp.setTotalbuyer(0);
			productDao.attachDirty(temp);
		} catch (Exception e) {
			model.addAttribute("error", "Failed: " + e.getMessage());
			logger.info("Exception " + e.getCause());
			return "redirect:addproduct.do";
		}
		return "redirect:product.do";
	}

	@RequestMapping(value = "deleteproduct")
	public String deleteProduct(HttpServletRequest request) {
		logger.info("Delete Product by ID");
		String idvar = request.getParameter("deleteID");
		if (idvar != null) {
			try {
				int id = Integer.parseInt(idvar);
				productDao.delete(productDao.findById(id));
			} catch (Exception e) {
				logger.info("Exception: " + e.getCause());
			}
		}
		return "redirect:product.do";
	}

	@RequestMapping(value = "editproduct")
	public String editProductHandler(Model model, HttpServletRequest request) {
		logger.info("Edit Product");
		List<?> brandList = brandDao.getAllBrand();
		List<?> categoryList = categoryDao.getAllCategory();
		List<?> conditionList = conditionDao.getAllCondition();
		model.addAttribute("brands", brandList);
		model.addAttribute("categories", categoryList);
		model.addAttribute("conditions", conditionList);
		int id = Integer.parseInt(request.getParameter("editID"));
		ProductBean temp = new ProductBean();
		Product cp = productDao.findById(id);
		model.addAttribute("product", temp);
		model.addAttribute("p", cp);

		return "product-edit";
	}

	@RequestMapping(value = "editingproduct")
	public String editProduct(Model model,
			@ModelAttribute("product") ProductBean product,
			BindingResult result, HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("editID"));

		try {
			logger.info("Edit product");
			Product temp = productDao.findById(id);

			String filePath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "resources\\img\\product\\";
			MultipartFile image1 = product.getImage1();
			MultipartFile image2 = product.getImage2();
			if (!image1.isEmpty()) {
				logger.trace("Save Image 1 File");
				String image1Path = filePath + image1.getOriginalFilename();
				File saveFile1 = new File(image1Path);
				image1.transferTo(saveFile1);
				temp.setImage1(image1.getOriginalFilename());
			}
			if (!image2.isEmpty()) {
				logger.trace("Save Image 2 File");
				String image2Path = filePath + image2.getOriginalFilename();
				File saveFile2 = new File(image2Path);
				image2.transferTo(saveFile2);
				temp.setImage2(image2.getOriginalFilename());
			}
			Brand brand = brandDao.findById(product.getBrandID());
			Productcatalog catalog = categoryDao.findById(product
					.getCategoryID());
			Condition condition = conditionDao.findById(product
					.getConditionID());
			temp.setBrand(brand);
			temp.setProductcatalog(catalog);
			temp.setConditions(condition);
			if (product.getProductname() != null) {
				temp.setProductname(product.getProductname());
			}
			if (product.getModel() != null) {
				temp.setModel(product.getModel());
			}
			if (product.getPrice() != null) {
				temp.setPrice(product.getPrice());
			}
			if (product.getDealprice() != null) {
				temp.setDealprice(product.getDealprice());
			}
			if (product.getDescription() != null) {
				temp.setDescription(product.getDescription());
			}
			if (product.getTax() != null) {
				temp.setTax(product.getTax());
			}
			if (product.getQuantity() != null) {
				temp.setQuantity(product.getQuantity());
			}

			if (product.getQuantityforsell() != null) {
				temp.setQuantityforsell(product.getQuantityforsell());
			}
			if (product.getWarranty() != null) {
				temp.setWarranty(product.getWarranty());
			}
			if (product.getFeatures() != null) {
				temp.setFeatures(product.getFeatures());
			}
			if (product.getSpecifications() != null) {
				temp.setSpecifications(product.getSpecifications());
			}
			if (product.getProductviews() != null) {
				temp.setProductviews(0);
			}
			if (product.getTotalbuyer() != null) {
				temp.setTotalbuyer(0);
			}
			productDao.update(temp);
		} catch (Exception e) {
			model.addAttribute("error", "Failed: " + e.getMessage());
			logger.info("Exception " + e.getCause());
			List<?> brandList = brandDao.getAllBrand();
			List<?> categoryList = categoryDao.getAllCategory();
			List<?> conditionList = conditionDao.getAllCondition();
			model.addAttribute("brands", brandList);
			model.addAttribute("categories", categoryList);
			model.addAttribute("conditions", conditionList);
			ProductBean temp = new ProductBean();
			Product cp = productDao.findById(id);
			model.addAttribute("product", temp);
			model.addAttribute("p", cp);
			return "product-edit";
		}
		return "redirect:product.do";
	}

	@RequestMapping(value = "productdetail")
	public String showProductDetail(Model model, HttpServletRequest request) {
		logger.info("Product Detail");
		int id = Integer.parseInt(request.getParameter("detailID"));
		Product p = productDao.findById(id);
		model.addAttribute("p", p);
		return "product-detail";
	}

}
