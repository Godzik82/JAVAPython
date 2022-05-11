package homework_15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.sqlite.JDBC;

public class DBHandler {

    public static final String CON_STR = "jdbc:sqlite:D:/Education/LearnUp/JAVAPython/HomeWork/homework_14/sqlite3.db";
    private static DBHandler instance = null;
    private Connection connection;

    private DBHandler() throws SQLException{
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);

    }

    public static synchronized DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();
        return instance;
    }

    public List<Users> getAllUsersInfo(){

        LinkedList <Users> users = new LinkedList<>();
        try (Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
            while (resultSet.next())
                users.add(new Users(resultSet.getString("name"),
                                    resultSet.getString("surname"),
                                    resultSet.getInt("money"),
                                    resultSet.getString("birthday")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<Cars> getAllCarsInfo(){

        LinkedList <Cars> cars = new LinkedList<>();
        try (Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cars;");
            while (resultSet.next())
                cars.add(new Cars(resultSet.getString("name"),
                                    resultSet.getString("color"),
                                    resultSet.getString("model")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }

    public List<Shops> getAllShopsInfo(){

        LinkedList <Shops> shops = new LinkedList<>();
        try (Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM shops;");
            while (resultSet.next())
                shops.add(new Shops(resultSet.getString("name"),
                                    resultSet.getString("address")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shops;
    }

    public void addUser(String name, String surname, Integer money, String birthday){

        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Users('name', 'surname', 'money', 'birthday') VALUES (?, ?, ?, ?)");
        ){
            statement.setObject(1, name);
            statement.setObject(2, surname);
            statement.setObject(3, money);
            statement.setObject(4, birthday);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void addCar(String name, String color, String model){

        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Cars('name', 'color', 'model') VALUES (?, ?, ?)");
        ){
            statement.setObject(1, name);
            statement.setObject(2, color);
            statement.setObject(3, model);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    public void addShop(String name, String address){

        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Shops('name', 'address') VALUES (?, ?)");
        ){
            statement.setObject(1, name);
            statement.setObject(2, address);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
