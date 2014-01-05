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

import EletroStore.dao.CategoryDao;
import EletroStore.dao.CommentDao;
import EletroStore.dao.ProductDao;
import EletroStore.entity.*;
import EletroStore.service.UserService;

@Controller
@Transactional
public class CommentController {

	private static Logger logger = LoggerFactory
			.getLogger(CommentController.class);
	@Autowired
	private ProductDao productDao;

	@Autowired
	private CommentDao commentDao;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	UserService userDetailsService;

	@RequestMapping(value = { "/comment.do" }, method = RequestMethod.POST)
	public String doCommentProduct(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("Add comment for product");

		String productid = request.getParameter("productid");
		String rating = "0";
		if (request.getParameter("rating") != null)
			rating = request.getParameter("rating");
		
		String content = request.getParameter("content");
		Product product = productDao.findById(Integer.parseInt(productid));

		User user = userDetailsService.getCurrentUser();
		if (user == null) {
			logger.info("User not loged in then go to login page");
			return "redirect:login.do";
		}

		Comment comment = new Comment();
		comment.setUser(user);
		comment.setProduct(product);
		comment.setDatetime(new Date());
		comment.setRating(Float.parseFloat(rating));
		comment.setContent(content);
		
		commentDao.attachDirty(comment);
		List<Comment> listcomment = (List<Comment>) commentDao.getListCommentByProductid(productid);
		
		float averagerating = 0;
		int count = 0, sum = 0;
		for (int i = 0; i < listcomment.size(); i++) {
			count++;
			if (listcomment.get(i).getRating() > 0) {
				sum += listcomment.get(i).getRating();
			}
		}

		averagerating = sum / count;
		product.setRating(averagerating);
		productDao.update(product);

		return "redirect:product.do?productid=" + productid;
	}

}
