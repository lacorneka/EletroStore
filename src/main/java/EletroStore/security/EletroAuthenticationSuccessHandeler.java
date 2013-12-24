package EletroStore.security;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class EletroAuthenticationSuccessHandeler implements
		AuthenticationSuccessHandler {
	private static Logger logger = LoggerFactory
			.getLogger(EletroAuthenticationSuccessHandeler.class);
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		String targetUrl = "welcome.do";
		Set<String> roles = AuthorityUtils.authorityListToSet(authentication
				.getAuthorities());
		
		if (response.isCommitted()) {
			logger.debug("Response has already been committed.");
			return;
		}	
		
		if (roles.contains("ROLE_ADMIN")) {
			targetUrl = "/admin/welcome.do";
		} else if (roles.contains("ROLE_USER")) {
			targetUrl = "/welcome.do";
		}
        redirectStrategy.sendRedirect(request, response, targetUrl);
        clearAuthenticationAttributes(request);
	}

	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}
