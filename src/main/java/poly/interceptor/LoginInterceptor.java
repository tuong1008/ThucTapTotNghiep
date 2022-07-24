package poly.interceptor;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ptithcm.exceptions.PageNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Transactional
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    SessionFactory sessionFactory;

    /**
     * Nếu register.htm thì cho qua
     * Không vào được những trang cần login
     * Login rồi mà login nữa
     * Đã đăng nhập và tiếp tục ấn đăng ký
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String updateParam = request.getParameter("update");
        if (session.getAttribute("username") == null) {
            if ((request.getRequestURI().equals("/NikeShop/register.htm") && updateParam == null)
                    || request.getRequestURI().equals("/NikeShop/login.htm")) {
                return true;
            } else {
                response.sendRedirect(request.getContextPath() + "/login.htm");
                return false;
            }
        } else if (request.getRequestURI().equals("/NikeShop/login.htm")
                || (request.getRequestURI().equals("/NikeShop/register.htm") && updateParam == null)) {
            throw new PageNotFoundException("Logout Required!");
        } else {
            return true;
        }
    }
}
