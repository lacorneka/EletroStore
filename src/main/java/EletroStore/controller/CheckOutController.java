package EletroStore.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class CheckOutController {

	HttpSession session;
	private static Logger logger = LoggerFactory
			.getLogger(CheckOutController.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	UserService userDetailsService;
	
	@Autowired
	private OrderstatusDao orderStatusDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private OrderdetailDao orderDetailDao;

	@RequestMapping(value = { "/checkout.do" }, method = RequestMethod.GET)
	public String doCheckOut(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("Begin checkout");
		session = request.getSession();
		if (userDetailsService.getCurrentUser() == null) {
			logger.info("User not loged in then go to login page");
			return "login";
		}
		
		User user = userDetailsService.getCurrentUser();
		
		ArrayList<Product> listproductscart = (ArrayList<Product>) session
				.getAttribute("listproductscart");
		float sumprice = 0;
		for (int i = 0; i < listproductscart.size(); i++) {
			Product pr = listproductscart.get(i);
			float price = pr.getPrice();
			sumprice = sumprice + price
					* listproductscart.get(i).getQuantityforsell() + price
					* listproductscart.get(i).getQuantityforsell()
					* listproductscart.get(i).getTax() / 100;
		}

		request.setAttribute("user", user);
		request.setAttribute("sumprice", sumprice);
		
		return "checkout";
	}
	
	@RequestMapping(value = { "/checkout.do" }, method = RequestMethod.POST)
	public String doPostCheckOut(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		session = request.getSession();
		if (userDetailsService.getCurrentUser() == null) {
			logger.info("User not loged in then go to login page");
			return "login";
		}
		
		User user = userDetailsService.getCurrentUser();
		
		ArrayList<Product> listproductscart = (ArrayList<Product>) session
				.getAttribute("listproductscart");
		float sumprice = 0;
		for (int i = 0; i < listproductscart.size(); i++) {
			Product pr = listproductscart.get(i);
			float price = pr.getPrice();
			sumprice = sumprice + price
					* listproductscart.get(i).getQuantityforsell() + price
					* listproductscart.get(i).getQuantityforsell()
					* listproductscart.get(i).getTax() / 100;
		}
		
		Orders order = new Orders();
		order.setOrderdate(new Date());
		order.setTotalmoney(sumprice);
		order.setUser(user);
		order.setOrderstatus(orderStatusDao.findById(1));
		
		ordersDao.attachDirty(order);
		
		
		for (int i = 0; i < listproductscart.size(); i++) {
			Product pr = listproductscart.get(i);
			Orderdetail orde = new Orderdetail();
			orde.setOrders(order);
			orde.setProduct(pr);
			orde.setQuantity(pr.getQuantityforsell());
			orderDetailDao.attachDirty(orde);
		}

		logger.info("Check out completed");
		session.removeAttribute("listproductscart");
		return "redirect:welcome.do";
	}
}
