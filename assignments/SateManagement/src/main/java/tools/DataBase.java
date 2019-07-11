package tools;

import entity.User;

import java.util.HashMap;

public class DataBase {
    private static DataBase dataBase;
    private HashMap<String, User> users;


    private DataBase() {

    }

    public static DataBase getDataBaseInstance() {
        if (dataBase == null) {
            dataBase = new DataBase();
            dataBase.initData();
        }

        return dataBase;
    }


    private void initData() {
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
