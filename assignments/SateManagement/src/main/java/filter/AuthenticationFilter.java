package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter",
        urlPatterns = {"/main"}
)
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest myReq = (HttpServletRequest) req;
        HttpServletResponse myResp = (HttpServletResponse) resp;


        System.out.println(myReq.getSession().getAttribute("user"));
        if (myReq.getSession().getAttribute("user") != null) {
            myReq.getSession().setAttribute("error","");
            chain.doFilter(req, resp);
        } else {
            // add session attribute
            myReq.getSession().setAttribute("error","you should login");
            myResp.sendRedirect(myReq.getContextPath() + "/login");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
