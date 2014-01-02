package EletroStore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import EletroStore.dao.BrandDao;
import EletroStore.dao.CategoryDao;
import EletroStore.dao.CommentDao;
import EletroStore.dao.ConditionDao;
import EletroStore.dao.ProductDao;
import EletroStore.entity.Brand;
import EletroStore.entity.Condition;
import EletroStore.entity.Product;
import EletroStore.entity.Productcatalog;

@Controller
@Transactional
public class ProductController {

	private static Logger logger = LoggerFactory
			.getLogger(ProductController.class);
	@Autowired
	private ProductDao productsDao;

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private ConditionDao conditionDao;

	@Autowired
	private BrandDao brandDao;

	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String doProduct(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		String productid = request.getParameter("productid");
		Product p = productsDao.findById(Integer.parseInt(productid));
		request.setAttribute("product", p);

		List<Product> listproductaccessories = productsDao.getProductList(p
				.getProductcatalog().getCatalogid().toString());
		for (int i = 0; i < listproductaccessories.size(); i++) {
			if (listproductaccessories.get(i).getProductid() == Integer
					.parseInt(productid)) {
				listproductaccessories.remove(i);
				break;
			}
		}
		request.setAttribute("listproductaccessories", listproductaccessories);

		List<Comment> listcomment = (List<Comment>) commentDao
				.getListCommentByProductid(productid);
		request.setAttribute("listcomment", listcomment);

		logger.info("Done product details");
		return "product";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/listproduct" }, method = RequestMethod.GET)
	public String doListProduct(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("Show product list was filtered and sorted");

		logger.info("Get catalog list show on the left");
		List<Productcatalog> listCatalog = (List<Productcatalog>) categoryDao
				.getAllCategory();
		request.setAttribute("listcategory", listCatalog);
		
		List<Condition> listCondition = (List<Condition>) conditionDao.getAllCondition();
		request.setAttribute("listcondition", listCondition);		
		
		List<Brand> listBrand = (List<Brand>) brandDao.getAllBrand();
		request.setAttribute("listbrand", listBrand);		
		
		String searchname = request.getParameter("searchname");
		logger.info("Get search name: " + searchname);
		
		String nstar = request.getParameter("nstar");
		logger.info("Get number of star rating: " + nstar);

		String pricefilter = request.getParameter("pricefilter");
		logger.info("Price filter: " + pricefilter);
		
		String catalogid = request.getParameter("catalogid");
		logger.info("Get catalog id: " + catalogid);
		
		String conditionid = request.getParameter("conditionid");
		logger.info("Get condition id: " + conditionid);
		
		String brandid = request.getParameter("brandid");
		logger.info("Get brand id: " + brandid);
		
		int productonpage = 2;
		if (request.getParameter("productonpage") != null) {
			logger.info("Get product id: "
					+ request.getParameter("productonpage"));
			productonpage = Integer.parseInt(request
					.getParameter("productonpage"));
		}

		int page = 1;
		if (request.getParameter("page") != null) {
			logger.info("Get curent page: " + request.getParameter("page"));
			page = Integer.parseInt(request.getParameter("page"));
		}

		int sortby = -1;
		if (request.getParameter("sortby") != null) {
			logger.info("Get Sort type: " + request.getParameter("sortby"));
			sortby = Integer.parseInt(request.getParameter("sortby"));
		}

		int numberOfProduct = productsDao.numberOfProduct(sortby, searchname, catalogid, conditionid, brandid, nstar, pricefilter);
		logger.info("Number of product list by sort and filter: "
				+ numberOfProduct);		
		int pagecount = productsDao.numberOfPageCompute(numberOfProduct,
				productonpage);
		logger.info("Number of page: " + pagecount);
		
		List<Product> listproduct = productsDao.getProductListCatalog(
				productonpage, page, sortby, searchname, catalogid, conditionid, brandid, nstar, pricefilter);
		logger.info("List product was sorted and filtered ");		
		
		request.setAttribute("productonpage", productonpage);
		request.setAttribute("page", page);
		request.setAttribute("sortby", sortby);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("listproduct", listproduct);

		logger.info("Done load product");
		return "listproduct";
	}
}
