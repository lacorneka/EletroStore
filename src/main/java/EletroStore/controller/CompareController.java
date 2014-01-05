package EletroStore.controller;

import java.util.ArrayList;
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

import EletroStore.dao.ProductDao;
import EletroStore.entity.Product;

@Controller
@Transactional
public class CompareController {

	private static Logger logger = LoggerFactory
			.getLogger(CompareController.class);
	@Autowired
	private ProductDao productsDao;

	HttpSession session;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/removecompare" }, method = RequestMethod.GET)
	public String removeCompare(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("Remove a product compare");
		String productid = request.getParameter("productid");
		session = request.getSession();
		ArrayList<Product> listproductscompare;
		listproductscompare = (ArrayList<Product>) session
				.getAttribute("listproductscompare");

		for (int i = 0; i< listproductscompare.size(); i++) {
			if(listproductscompare.get(i).getProductid() == Integer.parseInt(productid)){
				listproductscompare.remove(i);
				break;
			}
		}
		session.setAttribute("listproductscompare", listproductscompare);
		return "redirect:compare.do";
	}

	@RequestMapping(value = { "/compare.do" }, method = RequestMethod.GET)
	public String docompare(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("Begin compare");

		try {
			String productid = request.getParameter("productid");
			logger.info("Find product " + productid);

			session = request.getSession();
			ArrayList<Product> listproductscompare;
			if (session.getAttribute("listproductscompare") == null) {
				listproductscompare = new ArrayList<Product>();
				session.setAttribute("listproductscompare", listproductscompare);
			} else {
				listproductscompare = (ArrayList<Product>) session
						.getAttribute("listproductscompare");
			}

			if (productid != null) {
				boolean kq = false;
				for (int i = 0; i < listproductscompare.size(); i++) {
					Product p = listproductscompare.get(i);
					if (p.getProductid() == Integer.parseInt(productid)) {
						kq = true;
						break;
					}
				}
				if (kq == false) {
					if (listproductscompare.size() < 4) {
						Product pr = productsDao.findById(Integer
								.valueOf(productid));
						listproductscompare.add(pr);
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("Ex:" + e.getMessage());

		}

		logger.info("Done compare");
		return "compare";
	}

}
