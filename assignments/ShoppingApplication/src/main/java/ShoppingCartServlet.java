import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import entity.Product;
import entity.ShoppingCartBeanHelp;
import entity.ShoppingCart;
import tools.DataBase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

@WebServlet("/shoppingCart")
public class ShoppingCartServlet extends HttpServlet {
    private Gson gson = new Gson();
    private JsonParser parser = new JsonParser();
    ;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String shopping = URLDecoder.decode(Arrays.stream(req.getCookies())
                .filter(x -> x.getName().equals("shopping"))
                .map(x -> x.getValue()).collect(Collectors.joining("")), "UTF-8");

        JsonArray jsonArray = parser.parse(shopping).getAsJsonArray();
        ArrayList<Product> products = DataBase.getDataBaseInstance().getProducts();
        ArrayList<ShoppingCart> res = new ArrayList<>();
        long totalPrice = 0;
        for (JsonElement obj : jsonArray) {
            ShoppingCartBeanHelp shoppingCartBeanHelp = gson.fromJson(obj, ShoppingCartBeanHelp.class);
            Product product = products.stream().filter(x -> x.getId().equals(shoppingCartBeanHelp.getId())).findFirst().get();

            ShoppingCart shoppingCart = new ShoppingCart(product, shoppingCartBeanHelp.getNumber());

            totalPrice += product.getPrice() * shoppingCart.getNumber();
            res.add(shoppingCart);
        }

        req.setAttribute("shoppingCart", res);
        req.setAttribute("totalPrice", totalPrice);

        req.getRequestDispatcher("/WEB-INF/view/shoppingCart.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
