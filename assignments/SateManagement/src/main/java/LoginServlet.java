import entity.User;
import tools.DataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/login.jsp")
                .forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkBox = req.getParameter("checkbox");

        HashMap<String, User> users = DataBase.getDataBaseInstance().getUsers();
        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", users.get(username));
//            session.setAttribute("myCookie",false);
            if (checkBox != null) {
                String sessionid = session.getId();
                Cookie cookie = new Cookie("JSESSIONID", sessionid);
                Cookie cookie1 = new Cookie("username", username);
//                session.setAttribute("myCookie",true);
                cookie.setMaxAge(60 * 60 * 24 * 30);
                cookie1.setMaxAge(60 * 60 * 24 * 30);
                resp.addCookie(cookie);
                resp.addCookie(cookie1);
            } else {
                Cookie cookie1 = new Cookie("username", null);
                cookie1.setMaxAge(0);
                resp.addCookie(cookie1);
            }

            req.getSession().setAttribute("error","");
// 4 Create a persistent cookie named promo and save value $100 inside the cookie that last for a month in user's machine.
            Cookie cookie = new Cookie("promo", "$100");
            cookie.setMaxAge(60 * 60 * 24 * 30);
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/main");

        } else {
            HttpSession session = req.getSession();
            session.invalidate();
            req.getSession().setAttribute("error","Username or password wrong");

            resp.sendRedirect(req.getContextPath() + "/login");
        }

    }
}
