/**
 * If you really care for the license, look for the LICENSE.txt at the project root. Frankly, I 
 * really don't care.
 **/
package EletroStore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import EletroStore.service.UserService;

@Controller
public class AuthenticationController {

	/**
	 * The logger instance
	 **/
	private static Logger logger = LoggerFactory
			.getLogger(AuthenticationController.class);
	@Autowired
	UserService userDetailsService;

	/**
	 * Handles requests to the /login.do page
	 **/
	@RequestMapping(method = RequestMethod.GET, value = { "login" })
	public String showLoginPage(Model model) {

		logger.debug("Page Request: /login.do");
		if (userDetailsService.getCurrentUser() == null) {
			logger.info("User not loged in then go to login page");
			return "login";
		} else {
			logger.info("User has loged in, do not show login page");
			return "redirect:welcome.do";
		}
	}
	

	/**
	 * Handles requests to the /403.do page
	 **/
	@RequestMapping(method = RequestMethod.GET, value = { "error/403" })
	public String show403Page(Model model) {
		logger.debug("Page Request: /error/403.do");
		return "403";
	}
}
