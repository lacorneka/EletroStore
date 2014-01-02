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

import EletroStore.dao.*;
import EletroStore.entity.*;

@Controller
@Transactional
public class SearchController {

	private static Logger logger = LoggerFactory
			.getLogger(SearchController.class);
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = { "/search.do" }, method = RequestMethod.GET)
	public String doSearch(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("Load Search page");
		
		String productname = "";
		if (request.getParameter("productname") != null) {
			productname = request.getParameter("productname");
		}
		String productcatalog = "-1";
		if (request.getParameter("productcatalog") != null) {
			productcatalog = request.getParameter("productcatalog");
		}

		String[] brands = request.getParameterValues("brand");

		String[] conditions = request.getParameterValues("condition");
		String rating = "-1";
		if (request.getParameter("rating") != null) {
			rating = request.getParameter("rating");
		}
		String minprice = "";
		if (request.getParameter("minprice") != null) {
			minprice = request.getParameter("minprice");
		}

		String maxprice = "";
		if (request.getParameter("maxprice") != null) {
			maxprice = request.getParameter("maxprice");
		}

		int productonpage = 2;
		if (request.getParameter("productonpage") != null) {
			productonpage = Integer.valueOf(request
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

		int pagecount = categoryDao.pagecount(productname,
				productcatalog, brands, conditions, rating, productonpage,
				minprice, maxprice);
		List<Product> listproduct = new ArrayList<Product>();
		request.setAttribute("productname", productname);
		request.setAttribute("productcatalog", productcatalog);
		request.setAttribute("rating", rating);
		request.setAttribute("page", page);
		request.setAttribute("listbrand", brands);
		request.setAttribute("listcondition", conditions);
		request.setAttribute("minprice", minprice);
		request.setAttribute("maxprice", maxprice);
		request.setAttribute("productonpage", productonpage);
		request.setAttribute("pagecount", pagecount);
		request.setAttribute("listproduct", listproduct);
		request.setAttribute("sortby", sortby);
		//request.setAttribute("listsortby", listsortby);
		logger.info("Done load search page");
		return "search";

	}
}
