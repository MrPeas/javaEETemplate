package pl.admin.Filters;

import pl.admin.Beans.AdminBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        AdminBean adminBean = (AdminBean)((HttpServletRequest)servletRequest).getSession().getAttribute("adminBean");

        if(adminBean == null || !adminBean.isLoggedIn()){
            String contextPath = ((HttpServletRequest) servletRequest).getContextPath();
            ((HttpServletResponse) servletResponse).sendRedirect(contextPath + "/pages/login.xhtml");
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    public void destroy() {

    }
}