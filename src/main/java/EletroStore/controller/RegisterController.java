package EletroStore.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import EletroStore.beanform.Customer;
import EletroStore.dao.UserDao;
import EletroStore.entity.User;

@Controller
public class RegisterController {
	@Autowired
	UserDao userDao;
	private static Logger logger = LoggerFactory
			.getLogger(AuthenticationController.class);
	/**
	 * @param customer
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/registering", method = RequestMethod.POST)
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		logger.debug("Add new customer");
		if (!customer.getPassword().equals(customer.getRetypepassword())) {
			logger.debug("Check match password");
			result.rejectValue("retypepassword", "error.customer",
					"password not match");
		}
		
		if (!result.hasErrors()) {
			customer.getFirstname();
			customer.getLastname();
			customer.getEmail();
			customer.getAddress();
			customer.getPhonenumber();
			customer.getPassword();
			User user = new User(customer.getFirstname(),
					customer.getLastname(), customer.getEmail(),
					customer.getPassword(), customer.getPhonenumber(),
					customer.getZipcode(),null, null, null,null,null,null);
			try{
				logger.debug("Validition met, add to database");
				userDao.attachDirty(user);
				return "welcome";
			} catch(Exception e) {
				logger.debug("Adding to database failed");
				result.rejectValue("email", "error.customer",
						"An account already exists for this email.");
			}
		}
		return "register";

	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String displayCustomerForm(ModelMap model) {

		model.addAttribute("customer", new Customer());
		return "register";

	}

}
