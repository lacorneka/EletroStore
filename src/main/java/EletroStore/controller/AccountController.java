package EletroStore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import EletroStore.dao.OrderdetailDao;
import EletroStore.dao.OrdersDao;
import EletroStore.dao.UserDao;
import EletroStore.entity.Orderdetail;
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
	private OrderdetailDao orderdetailDao;

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

	@RequestMapping(value = { "/changeaccount.do" }, method = RequestMethod.POST)
	public String changeAccount(Model model, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes redirect) {

		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		String renewpassword = request.getParameter("renewpassword");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phonenumber = request.getParameter("phonenumber");
		String id = request.getParameter("memberid");

		try {
			int memberid = Integer.parseInt(id);
			logger.debug("Change Account info: memberid= " + memberid);
			User user = userDao.findById(memberid);
			Md5PasswordEncoder md5 = new Md5PasswordEncoder();
			String encodedPass = md5.encodePassword(password, null);
			String encodedNewPass = md5.encodePassword(newpassword, null);
			if (!user.getPassword().equals(encodedPass)) {
				redirect.addAttribute("accounterror", "Wrong Password!");

			} else if (newpassword==null || newpassword.isEmpty() || !newpassword.equals(renewpassword)) {
				redirect.addAttribute("accounterror",
						"Retype-Password Not Match!");
			} else {
				user.setPassword(encodedNewPass);
				user.setFirstname(firstname);
				user.setLastname(lastname);
				user.setPhonenumber(phonenumber);
				userDao.update(user);
				redirect.addAttribute("accounterror", "Success!");
			}
		} catch (Exception e) {
			redirect.addAttribute("accounterror", e.getCause());
			logger.trace("Exception " + e.getCause());
		}

		return "redirect:account.do";
	}

	@RequestMapping(value = { "/deleteorder.do" }, method = RequestMethod.GET)
	public String deleteOrder(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String orderid = request.getParameter("orderid");
		logger.debug("Delete order " + orderid);
		try {
			Orders o = ordersDao.findById(Integer.parseInt(orderid));
			ordersDao.delete(o);
		} catch (Exception e) {
			logger.debug("ORDER: " + e.getMessage());
		}
		return "redirect:account.do";
	}

	@RequestMapping(value = { "/orderdetail.do" }, method = RequestMethod.GET)
	public String orderDetail(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String orderid = request.getParameter("orderid");;
		List<Orderdetail> listorderdetails = orderdetailDao
				.findByOrderId(Integer.parseInt(orderid));

		request.setAttribute("listorderdetails", listorderdetails);

		return "orderdetail";
	}

}
