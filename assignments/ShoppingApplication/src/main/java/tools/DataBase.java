package tools;

import entity.Product;
import entity.ShoppingCart;
import entity.User;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBase {
    private static DataBase dataBase;
    private HashMap<String, User> users;
    private ArrayList<Product> products;


    public ArrayList<Product> getProducts() {
        return products;
    }

    private DataBase() {

    }

    public static DataBase getDataBaseInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
            dataBase.initUserData();
            dataBase.initProductsData();
        }

        return dataBase;
    }



    public void addRecordCheckout(ArrayList<ShoppingCart> shoppingCarts, User user) {
        HashMap<User, ArrayList<ArrayList<ShoppingCart>>> hashMap = new HashMap<>();

        if (!hashMap.containsKey(user)) {
            ArrayList<ArrayList<ShoppingCart>> objects = new ArrayList<>();
            objects.add(shoppingCarts);
            hashMap.put(user, objects);
        } else {
            hashMap.get(user).add(shoppingCarts);
        }

    }

    private void initProductsData() {
        products = new ArrayList<>();
        Product product = new Product("1", "Angel Soft Toilet Paper",
                " 60 Double Rolls, 60 = 120 Regular Rolls, Bath Tissue, 12 Count, Pack of 5", 27.49, "https://images-na.ssl-images-amazon.com/images/I/91jcm21-VGL._SX522AA522_PIbundle-5,TopRight,0,0_AA522_SH20_.jpg");
        Product product1 = new Product("2", "One A Day Men’s Multivitamin",
                "Supplement with Vitamins A, C, E, B1, B2, B6, B12, Calcium and Vitamin D, 200 count", 14.97,
                "https://images-na.ssl-images-amazon.com/images/I/81g2BnI%2B4iL._SX522_.jpg");
        Product product2 = new Product("3", "FIJI Natural Artesian Water",
                "16.9 Fl Oz (Pack of 24)", 22.98, "https://images-na.ssl-images-amazon.com/images/I/61L5aT3T7XL._SX522AA522_PIbundle-24,TopRight,0,0_AA522_SH20_.jpg");
        products.add(product);
        products.add(product1);
        products.add(product2);
//        product.ad

    }


    private void initUserData() {
        users = new HashMap<>();
        User user = new User("max", "123");
        User user1 = new User("lex", "123");
        users.put(user.getUsername(), user);
        users.put(user1.getUsername(), user1);
    }

    public HashMap<String, User> getUsers() {
        return users;
    }
}
