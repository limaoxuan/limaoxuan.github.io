import entity.Product;
import tools.DataBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> products = DataBase.getDataBaseInstance().getProducts();
//        System.out.println(products);
        req.setAttribute("products",products);
        req.getRequestDispatcher("/WEB-INF/view/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
//        Cookie cookie = new Cookie("shopping", "");
//
////                session.setAttribute("myCookie",true);
//        cookie.setMaxAge(0);
//        resp.addCookie(cookie);
        resp.sendRedirect(req.getContextPath() + "/login");
    }


}
