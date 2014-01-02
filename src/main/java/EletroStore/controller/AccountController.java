package EletroStore.controller;

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

import EletroStore.dao.OrdersDao;
import EletroStore.dao.ProductDao;
import EletroStore.dao.UserDao;
import EletroStore.entity.Orders;
import EletroStore.entity.User;
import EletroStore.service.UserService;

@Controller
@Transactional
public class AccountController {

	private static Logger logger = LoggerFactory
			.getLogger(AccountController.class);

	@Autowired
	private UserDao userDao;

	@Autowired
	private OrdersDao ordersDao;

	@Autowired
	UserService userDetailsService;

	@RequestMapping(value = { "/account.do" }, method = RequestMethod.GET)
	public String doAccount(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		User user = userDetailsService.getCurrentUser();
		if (user == null) {
			logger.info("User not loged in then go to login page");
			return "redirect:login.do";
		}

		request.setAttribute("user", user);

		int filterorder = -1;
		if (request.getParameter("filterorder") != null) {
			filterorder = Integer.parseInt(request.getParameter("filterorder"));
		}

		List<Orders> listorders = ordersDao.getListOrderByUser(user,
				filterorder);

		request.setAttribute("listorders", listorders);
		request.setAttribute("listfilter", filterorder);
		
		return "account";
	}

}
