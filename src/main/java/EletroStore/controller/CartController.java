package EletroStore.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
				if (product.getProductid() == Integer.parseInt(productid)) {
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

}