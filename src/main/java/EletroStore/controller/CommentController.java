package EletroStore.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import EletroStore.dao.*;
import EletroStore.entity.*;
import EletroStore.service.UserService;

@Controller
@Transactional
public class CommentController {

	private static Logger logger = LoggerFactory
			.getLogger(SearchController.class);
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	UserService userDetailsService;

	@RequestMapping(value = { "/CommentProduct.do" }, method = RequestMethod.POST)
	public String doCommentProduct(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		String productid = request.getParameter("productid");
		String rating = "5";
		if (request.getParameter("rating") != null)
			rating = request.getParameter("rating");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Product product = productDao.findById(Integer.parseInt(productid));

		if (userDetailsService.getCurrentUser() == null) {
			logger.info("User not loged in then go to login page");
			return "login";
		}

		User user = userDetailsService.getCurrentUser();

		Comment comment = new Comment();
		// user, product, title, content,
		// Integer.parseInt(rating));
		comment.setUser(user);
		comment.setProduct(product);
		comment.setDatetime(new Date());
		comment.setContent(content);

		commentDao.attachDirty(comment);

		List<Comment> listcomment = commentDao
				.getListCommentByProductid(productid);
		
//		int averagerating = 0;
//		int count = 0, sum = 0;
//		for (int i = 0; i < listcomment.size(); i++) {
//			if (listcomment.get(i).get > 0) {
//				sum += listcomment.get(i).getRating();
//				count++;
//			}
//		}
//		averagerating = sum / count;
//		product.setRating(averagerating);
//		productDAO.updateRating(averagerating, productid);
//		List<Products> listproductaccessories = productDAO
//				.getProductList(product.getProductcatalog().getCatalogid()
//						.toString());
//		request.setAttribute("listproductaccessories", listproductaccessories);
//		request.setAttribute("listcomment", listcomment);
//		request.setAttribute("product", product);

		
		return "product";
	}

}
