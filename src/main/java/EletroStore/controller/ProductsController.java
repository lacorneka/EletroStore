package EletroStore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import EletroStore.entity.*;
import EletroStore.dao.*;


@Controller
@Transactional
public class ProductsController {

	private static Logger logger = LoggerFactory
			.getLogger(ProductsController.class);
	

	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String doProducts(Model model, HttpServletRequest request, HttpServletResponse response) {		
		
		String productid = request.getParameter("productid");
		
		logger.info("Done load product");
		return "product";
	}
}
