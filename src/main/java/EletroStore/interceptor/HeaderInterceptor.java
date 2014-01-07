/**
 * 
 */
package EletroStore.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import EletroStore.dao.CategoryDao;
import EletroStore.dao.ProductDao;
import EletroStore.dao.UserDao;
import EletroStore.dao.WishlistDao;
import EletroStore.entity.Product;
import EletroStore.entity.User;
import EletroStore.entity.Wishlist;
import EletroStore.service.UserService;

/**
 * @author HNP_2
 * 
 */
@Component
public class HeaderInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory
			.getLogger(HeaderInterceptor.class);
	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private WishlistDao wishListDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;

	@Autowired
	UserService userDetailsService;

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("REQUEST Header Data Intercepted for URI: "
				+ request.getRequestURI());
		HttpSession session = request.getSession();
		List<?> listCatalog = categoryDao.getAllCategory();
		request.setAttribute("listcategory", listCatalog);

		User user = userDetailsService.getCurrentUser();
		List<Wishlist> wishlists;
		
		if (session.getAttribute("listproductscart") == null) {
			session.setAttribute("listproductscart", new ArrayList<Product>());
		}

		if (user != null) {
			wishlists = wishListDao.getWishlListByUser(user);
			session.setAttribute("wishlists", wishlists);
		} else{
			if (session.getAttribute("wishlists") == null) {
				wishlists = new ArrayList<Wishlist>();
				session.setAttribute("wishlists", wishlists);
			}
		}
		return true;
	}
}
