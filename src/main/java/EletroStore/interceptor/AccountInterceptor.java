/**
 * 
 */
package EletroStore.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import EletroStore.dao.CategoryDao;

/**
 * @author HNP_2
 * 
 */
@Component
public class AccountInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory
			.getLogger(AccountInterceptor.class);
	@Autowired
	private CategoryDao categoryDao;

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("REQUEST Header Data Intercepted for URI: "
				+ request.getRequestURI());
		List<?> listCatalog = categoryDao.getAllCategory();
		request.setAttribute("listcategory", listCatalog);
		return true;
	}
}
