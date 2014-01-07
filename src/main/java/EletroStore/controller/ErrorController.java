package EletroStore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Transactional
public class ErrorController {

	private static Logger logger = LoggerFactory
			.getLogger(ErrorController.class);

	/**
	 * Handles requests to the /403.do page
	 **/
	@RequestMapping(method = RequestMethod.GET, value = { "/error/403" })
	public String show403Page(Model model) {
		logger.debug("Page Request: /error/403.do");
		return "403";
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/error/404" })
	public String show404Page() {
		logger.debug("Page Request: /error/404.do");
		return "404";
	}
}
