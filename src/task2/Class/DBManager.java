package task2.Class;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager {
    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_aza_javaee_task2_items",
                    "postgres", "postgres");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void addItem(Item item){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO items (id, name, price, amount) " +
                    "VALUES (NULL, ? , ? , ?)");

            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());
            statement.setInt(3, item.getAmount());

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Item> getItemList(){

        ArrayList<Item> items = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM items");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int amount = resultSet.getInt("amount");
                Item item = new Item(id,name,price,amount);
                items.add(item);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return items;

    }

    public static Item getItem(Long id){
        Item item = null;

        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT id,name,price,amount FROM items WHERE id = ? LIMIT 1");

            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){

                item = new Item(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getInt("amount")
                );

            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return item;
    }
}
