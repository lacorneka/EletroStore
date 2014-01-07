package EletroStore.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

import EletroStore.dao.*;
import EletroStore.entity.*;

@Controller
@Transactional
public class SearchController {

	private static Logger logger = LoggerFactory
			.getLogger(SearchController.class);
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

	@RequestMapping(value = { "/search.do" }, method = RequestMethod.GET)
	public String doSearch(HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("Load Search page");

		List<?> listCondition = conditionDao.getAllCondition();
		request.setAttribute("listcondition", listCondition);

		List<?> listBrand = brandDao.getAllBrand();
		request.setAttribute("listbrand", listBrand);

		try {
			String searchname = request.getParameter("searchname");
			String nstar = request.getParameter("nstar");
			String pricefrom = request.getParameter("pricefrom");
			String priceto = request.getParameter("priceto");
			String catalogid = request.getParameter("catalogid");
			String conditionid = request.getParameter("conditionid");
			String brandid = request.getParameter("brandid");
			Boolean indescription = request.getParameter("indescription") != null;

			logger.info("Get search name: " + searchname);
			logger.info("Get number of star rating: " + nstar);
			logger.info("Price from " + pricefrom + " to " + priceto);
			logger.info("Get catalog id: " + catalogid);
			logger.info("Get condition id: " + conditionid);
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
			String pricefilter = "";
			pricefilter += (pricefrom != null && !pricefrom.isEmpty()) ? " and p.price>=" + pricefrom : "";
			pricefilter += (pricefrom != null && !priceto.isEmpty()) ? " and p.price<=" + priceto : "";

			int sortby = -1;
			if (request.getParameter("sortby") != null) {
				logger.info("Get Sort type: " + request.getParameter("sortby"));
				sortby = Integer.parseInt(request.getParameter("sortby"));
			}

			int numberOfProduct = productsDao.numberOfProduct(sortby,
					searchname, catalogid, conditionid, brandid, nstar,
					pricefilter, indescription);
			logger.info("Number of product list by sort and filter: "
					+ numberOfProduct);
			int pagecount = productsDao.numberOfPageCompute(numberOfProduct,
					productonpage);
			logger.info("Number of page: " + pagecount);

			List<Product> listproduct = productsDao.getProductListCatalog(
					productonpage, page, sortby, searchname, catalogid,
					conditionid, brandid, nstar, pricefilter, indescription);
			logger.info("List product was sorted and filtered ");

			request.setAttribute("productonpage", productonpage);
			request.setAttribute("page", page);
			request.setAttribute("sortby", sortby);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("listproduct", listproduct);
			logger.info("Done load search page");
		} catch (Exception e) {
			logger.error("Search fail: " + e.getCause());

		}
		return "search";

	}
}
