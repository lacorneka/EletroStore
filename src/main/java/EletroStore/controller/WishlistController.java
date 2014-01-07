package EletroStore.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import EletroStore.service.UserService;

@Controller
@Transactional
public class WishlistController {

	HttpSession session;
	private static Logger logger = LoggerFactory
			.getLogger(WishlistController.class);

	@Autowired
	private WishlistDao wishListDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	UserService userDetailsService;

	@RequestMapping(value = { "/wishlist.do" }, method = RequestMethod.GET)
	public String doWishList(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		User user = userDetailsService.getCurrentUser();
		if (user == null) {
			logger.info("User not loged in then go to login page");
			return "redirect:login.do";
		}
		@SuppressWarnings("unchecked")
		List<Wishlist> wishlists = (List<Wishlist>)session.getAttribute("wishlists");

		boolean flagWishlist = false;
		if (request.getParameter("productid") != null) {
			String productid;
			productid = request.getParameter("productid");
			for (Wishlist wishlist : wishlists) {
				if (Integer.parseInt(productid) == wishlist.getProduct()
						.getProductid()) {
					flagWishlist = true;
					break;
				}

			}
			
			if (flagWishlist == false) {
				Product product = productDao.findById(Integer
						.parseInt(productid));
				Date date = new Date();
				Wishlist wishlist = new Wishlist(user, product, date);
				wishlists.add(wishlist);
				wishListDao.attachDirty(wishlist);
			}
		}
		session.setAttribute("wishlists", wishlists);

		return "wishlist";
	}

	@RequestMapping(value = { "/deleteproductwishlist" }, method = RequestMethod.GET)
	public String doDeleteProductWishlist(Model model,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("Begin delete Product Wishlist");

		List<Wishlist> wishlists;
		session = request.getSession();
		if (userDetailsService.getCurrentUser() == null) {
			logger.info("User not loged in then go to login page");
			return "login";
		}

		User user = userDetailsService.getCurrentUser();
		String productid;
		productid = request.getParameter("productid");
		wishListDao.removeWishListByProductid(productid);
		logger.info("Product Wishlist deleted");
		wishlists = wishListDao.getWishlListByUser(user);
		session.setAttribute("wishlists", wishlists);

		return "wishlist";
	}

}
