/**
 * 
 */
package EletroStore.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import EletroStore.beanform.Brand;
import EletroStore.beanform.Customer;
import EletroStore.dao.UserDao;
import EletroStore.entity.User;

/**
 * @author HNP
 *
 */
@RequestMapping(value = "/admin")
public class AdminController {

		@Autowired
		UserDao userDao;
		private static Logger logger = LoggerFactory
				.getLogger(AdminController.class);
		
		@RequestMapping(value = "/brand/add.do", method = RequestMethod.POST)
		public String addCustomer(Model model, @Valid @ModelAttribute("brand") Brand brand, BindingResult result) {			
			MultipartFile imageFile = brand.getImageFile();
			String imageFileName = imageFile.getOriginalFilename();
			model.addAttribute("imageName",imageFileName);
			return "brand-list";
		}

		@RequestMapping(value = "/brand", method = RequestMethod.GET)
		public String displayCustomerForm(ModelMap model) {
			model.addAttribute("brand", new Brand());
			return "brand-add";
		}


}
