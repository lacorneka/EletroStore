package EletroStore.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import EletroStore.dao.*;
import EletroStore.entity.*;

public class CheckOutController {

	HttpSession session;
	private static Logger logger = LoggerFactory
			.getLogger(CheckOutController.class);
	
	@Autowired
	private UserDao userDao;

	@RequestMapping(value = { "/checkout.do" }, method = RequestMethod.GET)
	public String doCheckOut(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		logger.info("Begin checkout");
		session = request.getSession();
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String email = auth.getName(); // get logged in username
		ArrayList<Products> listproductscart = (ArrayList<Products>) session
				.getAttribute("listproductscart");
		float sumprice = 0;
		for (int i = 0; i < listproductscart.size(); i++) {
			Products pr = listproductscart.get(i);
			float price = pr.getPrice();// - (sp.getGiaBan() * sp.getGiamGia() /
										// 100);
			sumprice = sumprice + price
					* listproductscart.get(i).getQuantityforsell() + price
					* listproductscart.get(i).getQuantityforsell()
					* listproductscart.get(i).getTax() / 100;
		}
		Orders order = new Orders();
		// String maDonDatHang = donDatHangDAO.sinhMaDonDatHang(tenDangNhap, new
		// Date());
		// ddh.setMaDonDatHang(maDonDatHang);
		order.setOrderdate(new Date());
		order.setTotalmoney(sumprice);
		User user = userDao.getUser(email);
		order.setUser(user);
		//order.setOrderstatus(orderStatusDAO.getOrderstatus(1));
		//ordersDAO.addOrders(order);
		// donDatHangDAO.themDonDatHang(ddh);
		for (int i = 0; i < listproductscart.size(); i++) {
			Products pr = listproductscart.get(i);
			Orderdetail orde = new Orderdetail();
			orde.setOrders(order);
			// orde.setsetSoThuTu(i + 1);
			orde.setProducts(pr);
			// orde.set(sp.getGiaBan() - sp.getGiaBan() * sp.getGiamGia() /
			// 100);
			orde.setQuantity(pr.getQuantityforsell());
			//orderDetailDAO.addOrderDetail(orde);
			// chiTietDonDatHangDAO.themChiTietDonDatHang(ct);
		}
		// Cap nhat so luong ton
		logger.info("Check out completed");
		session.removeAttribute("listproductscart");
		// String url = "LichSuMuaHang.do?action=xem&maDonDatHang=" +
		// maDonDatHang;
		// response.sendRedirect(url);
		// request.setAttribute("maDonDatHang", maDonDatHang);
		return "redirect:/OrderManage.do";
	}
}
