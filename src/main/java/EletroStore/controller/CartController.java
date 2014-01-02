package EletroStore.controller;

import java.util.ArrayList;

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
public class CartController {
	
	private static Logger logger = LoggerFactory
			.getLogger(CartController.class);

	@Autowired
	private ProductDao productDao;

	HttpSession session;

	@RequestMapping(value = { "/cart.do" }, method = RequestMethod.GET)
	public String doCart(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		session = request.getSession();
		ArrayList<Product> listproductscart;
		if (session.getAttribute("listproductscart") == null) {
			listproductscart = new ArrayList<Product>();
			session.setAttribute("listproductscart", listproductscart);
		} else {
			listproductscart = (ArrayList<Product>) session
					.getAttribute("listproductscart");
		}

		String productid = request.getParameter("productid");
		if (productid != null) {
			boolean kq = false;
			for (int i = 0; i < listproductscart.size(); i++) {
				Product product = listproductscart.get(i);
				if (product.getProductid() == Integer.parseInt(productid) && product.getQuantity()>0) {
					product.setQuantityforsell(product.getQuantityforsell() + 1);
					product.setQuantity(product.getQuantity() - 1);
					kq = true;
					break;
				}
			}
			if (kq == false) {
				Product pr = productDao.findById(Integer.valueOf(productid));
				pr.setQuantityforsell(1);
				listproductscart.add(pr);
			}
		}

		// String update = request.getParameter("update.x");
		// if (update != null) {
		// String[] q = request.getParameterValues("quantityforsell");
		// for (int i = 0; i < listproductscart.size(); i++) {
		// int quantityforsell = Integer.parseInt(q[i]);
		// listproductscart.get(i).setQuantityforsell(quantityforsell);
		// }
		// }
		
		return "cart";
	}
	
	@RequestMapping(value = { "/deleteproductcart.do" }, method = RequestMethod.GET)
	public String doDeleteProductCart(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("Begin delete product cart");
	
		ArrayList<Product> listproductscart;
		session = request.getSession();
		if (session.getAttribute("listproductscart") == null) {
			listproductscart = new ArrayList<Product>();
			session.setAttribute("listproductscart", listproductscart);
		} else {
			listproductscart = (ArrayList<Product>) session
					.getAttribute("listproductscart");
		}
		
		String productid = request.getParameter("productid");
		for (int i = 0; i < listproductscart.size(); i++) {
			if (listproductscart.get(i).getProductid() == Integer
					.parseInt(productid)) {
				listproductscart.remove(i);
				logger.info("Product cart deleted");
				break;
			}
		}
		return "cart";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = { "/updateproductcart.do" }, method = RequestMethod.GET)
	public String doUpdateProductCart(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("Begin update product cart");
		
		String[] q = request.getParameterValues("quantityforsell");
	
		ArrayList<Product> listproductscart;
		session = request.getSession();
		if (session.getAttribute("listproductscart") == null) {
			listproductscart = new ArrayList<Product>();
			session.setAttribute("listproductscart", listproductscart);
		} else {
			listproductscart = (ArrayList<Product>) session
					.getAttribute("listproductscart");
		}
		
		for (int i = 0; i < listproductscart.size(); i++) {
			int quantityforsell = Integer.parseInt(q[i]);
			listproductscart.get(i).setQuantityforsell(quantityforsell);
		}
		
		return "cart";
	}
	

}
