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

import EletroStore.entity.*;
import EletroStore.dao.*;

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

	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String doProduct(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		String productid = request.getParameter("productid");
		Product p = productsDao.findById(Integer.parseInt(productid));
		request.setAttribute("product", p);

		List<Product> listproductaccessories = productsDao.getProductList(p
				.getProductcatalog().getCatalogid().toString());
		request.setAttribute("listproductaccessories", listproductaccessories);

		logger.info("Done product details");
		return "product";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/listproduct" }, method = RequestMethod.GET)
	public String doListProduct(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		List<Productcatalog> listCatalog = (List<Productcatalog>) categoryDao
				.getAllCategory();
		request.setAttribute("listcategory", listCatalog);
		
		List<Product> listProduct = (List<Product>) productsDao.getAllProduct();
		request.setAttribute("listproduct", listProduct);

		if (request.getParameter("catalogid") != null) {
			int catalogid = Integer.parseInt(request.getParameter("catalogid"));
			Productcatalog productcatalog = categoryDao.findById(catalogid);

			int productonpage = 2;
			if (request.getParameter("productonpage") != null) {
				productonpage = Integer.parseInt(request
						.getParameter("productonpage"));
			}

			int page = 1;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			int sortby = -1;
			if (request.getParameter("sortby") != null) {
				sortby = Integer.parseInt(request.getParameter("sortby"));
			}

			int n = categoryDao.findByExample(productcatalog).size();
			int pagecount = n / productonpage;
			if (n % productonpage != 0) {
				pagecount++;
			}

			List<Product> listproduct = productsDao.getProductListCatalog(catalogid,
					productonpage, page, sortby);

			request.setAttribute("productcatalog", productcatalog);
			request.setAttribute("productonpage", productonpage);
			request.setAttribute("page", page);
			request.setAttribute("sortby", sortby);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("listproduct", listproduct);
		} 

		logger.info("Done load product");
		return "listproduct";
	}
}
