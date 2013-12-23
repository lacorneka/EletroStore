package EletroStore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import EletroStore.beanform.Customer;
import EletroStore.dao.UserDao;
import EletroStore.entity.User;

@Controller
@Transactional
public class RegisterController {
	@Autowired
	UserDao userDao;

	/**
	 * @param customer
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/registering", method = RequestMethod.POST)
	public String addCustomer(@Valid Customer customer, BindingResult result) {

		if (!customer.getPassword().equals(customer.getRetypepassword())) {
			result.rejectValue("retypepassword", "error.customer",
					"password not match");
		}
		if (result.hasErrors()) {
		} else {
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
			if (userDao.addUser(user)) {
				return "welcome";
			} else {
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
