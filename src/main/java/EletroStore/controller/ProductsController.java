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
public class ProductsController {

	private static Logger logger = LoggerFactory
			.getLogger(ProductsController.class);
	@Autowired
	private ProductsDao productsDao;

	@Autowired
	private CommentDao commentDao;

	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String doProducts(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		String productid = request.getParameter("productid");
		Products p = productsDao.findById(Integer.parseInt(productid));
		request.setAttribute("product", p);

		List<Products> listproductaccessories = productsDao.getProductList(p
				.getProductcatalog().getCatalogid().toString());
		request.setAttribute("listproductaccessories", listproductaccessories.subList(0, 4));

		List<Comment> listcomment = commentDao
				.getListCommentByProductid(productid);

		logger.info("Done product details");
		return "product";
	}

	@RequestMapping(value = { "/listproduct" }, method = RequestMethod.GET)
	public String doListProducts(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		List<Products> lst = (List<Products>) productsDao.getAllProducts();
		request.setAttribute("listproduct", lst);

		logger.info("Done get all product");
		return "listproduct";
	}
}
