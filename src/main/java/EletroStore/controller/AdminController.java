/**
 * 
 */
package EletroStore.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import EletroStore.beanform.Brand;
import EletroStore.dao.BrandDao;

/**
 * @author HNP
 *
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

		@Autowired
		BrandDao brandDao;
		private static Logger logger = LoggerFactory
				.getLogger(AdminController.class);

		
		@RequestMapping(value = "brand")
		public String addCustomer(Model model) {			
			model.addAttribute("brand", new Brand());
			return "brand-add";
		}

		@RequestMapping(value = "brand/add")
		public String displayCustomerForm(Model model, @Valid @ModelAttribute("brand") Brand brand, BindingResult result) {
			logger.info("Add new brand");
			if (brand == null) {
			model.addAttribute("brand", new Brand());
			return "brand-add";
			}
			MultipartFile imageFile = brand.getImageFile();
			String imageFileName = imageFile.getOriginalFilename();
			model.addAttribute("imageName",imageFileName);
			logger.trace("Image file name "+imageFileName);
			try {
			EletroStore.entity.Brand temp = new EletroStore.entity.Brand(brand.getBrandname());
			temp.setBrandimage(imageFileName);
			brandDao.attachDirty(temp);
			} catch (Exception e){
				model.addAttribute("error", "Failed: "+e.getCause());
				return "brand-add";
			}
			return "admin-welcome";
		}


}
