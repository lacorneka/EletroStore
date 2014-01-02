package EletroStore.controller;

import java.util.ArrayList;
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

import EletroStore.dao.ProductDao;


@Controller
@Transactional
public class CompareController {
	
	private static Logger logger = LoggerFactory
			.getLogger(CompareController.class);
	@Autowired
	private ProductDao productsDao;
	
	@RequestMapping(value={"/compare.do"}, method = RequestMethod.GET) 
    public String docompare(Model model, HttpServletRequest request, HttpServletResponse response){ 
		logger.info("Begin compare");
		
		
		
		String[] listproducts = request.getParameterValues("compareproducts");
		
		logger.info("Done compare");
		return "compare";
	}

}
