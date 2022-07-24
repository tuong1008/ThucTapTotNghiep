package poly.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ptithcm.exceptions.UnauthorizedException;
import ptithcm.service.AuthoritiesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Tuong
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    AuthoritiesService authoritiesService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        if (username != null) {
            String role = authoritiesService.getRole(username.toString());
            if (!role.isEmpty()) {
                return role.equals("ROLE_ADMIN");
            }
        }
        throw new UnauthorizedException("This page is for admins only!");
    }
}
