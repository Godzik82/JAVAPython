package engine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.sqlite.JDBC;

import items.armour.*;
import items.weapon.*;
import unit.*;


public class DBHandler {

    public static final String CON_STR = "jdbc:sqlite:D:/Education/LearnUp/JAVAPython/Game/engine/gameDB.db";
    private static DBHandler instance = null;
    private Connection connection;
    Random rnd = new Random();

    private DBHandler() throws SQLException{
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);

    }

    public static synchronized DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();
        return instance;
    }

    public synchronized Helmet getHelmetArmour(){        
        try (Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM armour WHERE class = 'helmet'" + 
                                                        "ORDER BY RANDOM() LIMIT 1;");
            // System.out.println(resultSet.absolute(2));
            // resultSet.getRow();
            return new Helmet(resultSet.getString("name"),
                                resultSet.getInt("weigth"),
                                resultSet.getInt("defence"),
                                resultSet.getInt("streigth"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Body getBodyArmour(){        
        try (Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM armour WHERE class = 'body'" + 
                                                        "ORDER BY RANDOM() LIMIT 1;");
            // resultSet.absolute(2);
            return new Body(resultSet.getString("name"),
                                resultSet.getInt("weigth"),
                                resultSet.getInt("defence"),
                                resultSet.getInt("streigth"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Gloves getGlovesArmour(){        
        try (Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM armour WHERE class = 'gloves'" + 
                                                        "ORDER BY RANDOM() LIMIT 1;");
            // resultSet.absolute(2);
            return new Gloves(resultSet.getString("name"),
                                resultSet.getInt("weigth"),
                                resultSet.getInt("defence"),
                                resultSet.getInt("streigth"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Boots getBootsArmour(){        
        try (Statement statement = this.connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("SELECT * FROM armour WHERE class = 'boots'" + 
                                                        "ORDER BY RANDOM() LIMIT 1;");
            // resultSet.absolute(2);
            return new Boots(resultSet.getString("name"),
                                resultSet.getInt("weigth"),
                                resultSet.getInt("defence"),
                                resultSet.getInt("streigth"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Armour getItemArmour(String typeArmor){        
        try (Statement statement = this.connection.createStatement()){
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM armour WHERE class = '");
            query.append(typeArmor);
            query.append("'ORDER BY RANDOM() LIMIT 1;");
            ResultSet resultSet = statement.executeQuery(query.toString());
            String[] result = new String[]{resultSet.getString("name"),
                                            resultSet.getString("weigth"),
                                            resultSet.getString("defence"),
                                            resultSet.getString("streigth")};

            switch(typeArmor){
                case "helmet":
                    return new Helmet(result[0],
                                        Integer.parseInt(result[1]),
                                        Integer.parseInt(result[2]),
                                        Integer.parseInt(result[3]));
                case "body":
                    return new Body(result[0],
                                        Integer.parseInt(result[1]),
                                        Integer.parseInt(result[2]),
                                        Integer.parseInt(result[3]));
                case "boots":
                    return new Boots(result[0],
                                        Integer.parseInt(result[1]),
                                        Integer.parseInt(result[2]),
                                        Integer.parseInt(result[3]));
                case "gloves":
                    return new Gloves(result[0],
                                        Integer.parseInt(result[1]),
                                        Integer.parseInt(result[2]),
                                        Integer.parseInt(result[3]));
                default:
                    return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Weapon getWeapon(String typeWeapon){        
        try (Statement statement = this.connection.createStatement()){
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM weapon WHERE class = '");
            query.append(typeWeapon);
            query.append("'ORDER BY RANDOM() LIMIT 1;");
            ResultSet resultSet = statement.executeQuery(query.toString());
            String[] result = new String[]{resultSet.getString("name"),
                                            resultSet.getString("weigth"),
                                            resultSet.getString("damage"),
                                            resultSet.getString("streigth")};

            switch(typeWeapon){
                case "sword":
                    return new Sword(result[0],
                                        Integer.parseInt(result[1]),
                                        Integer.parseInt(result[2]),
                                        Integer.parseInt(result[3]));
                case "magic torch":
                    return new MagicTorch(result[0],
                                        Integer.parseInt(result[1]),
                                        Integer.parseInt(result[2]),
                                        Integer.parseInt(result[3]));
                default:
                    return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized Unit getUnit(String typeUnit, Weapon weapon, Armour[] armour){        
        try (Statement statement = this.connection.createStatement()){
            StringBuilder query = new StringBuilder();
            query.append("SELECT * FROM units WHERE class = '");
            query.append(typeUnit);
            query.append("'ORDER BY RANDOM() LIMIT 1;");
            ResultSet resultSet = statement.executeQuery(query.toString());
            String[] result = new String[]{resultSet.getString("name"),
                                            resultSet.getString("hp"),
                                            resultSet.getString("selfAttack"),
                                            resultSet.getString("maxWeigth"),
                                            resultSet.getString("mana")};

            switch(typeUnit){
                case "ground":
                    return new GroundUnit(result[0],
                                        Integer.parseInt(result[1]),
                                        Integer.parseInt(result[2]),
                                        Integer.parseInt(result[3]),
                                        armour,
                                        (Sword) weapon,
                                    50);
                case "flying":
                    return new FlyingUnit(result[0],
                                        Integer.parseInt(result[1]),
                                        Integer.parseInt(result[2]));
                case "magic":
                    return new MagicUnit(result[0],
                                    Integer.parseInt(result[1]),
                                    Integer.parseInt(result[2]),
                                    Integer.parseInt(result[3]),
                                    Integer.parseInt(result[4]),
                                    armour,
                                    (MagicTorch) weapon,
                                    50);
                default:
                    return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // public List<Users> getAllUsersInfo(){

    //     LinkedList <Users> users = new LinkedList<>();
    //     try (Statement statement = this.connection.createStatement()){
    //         ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
    //         while (resultSet.next())
    //             users.add(new Users(resultSet.getString("name"),
    //                                 resultSet.getString("surname"),
    //                                 resultSet.getInt("money"),
    //                                 resultSet.getString("birthday")));
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return users;
    // }

    // public List<Cars> getAllCarsInfo(){

    //     LinkedList <Cars> cars = new LinkedList<>();
    //     try (Statement statement = this.connection.createStatement()){
    //         ResultSet resultSet = statement.executeQuery("SELECT * FROM cars;");
    //         while (resultSet.next())
    //             cars.add(new Cars(resultSet.getString("name"),
    //                                 resultSet.getString("color"),
    //                                 resultSet.getString("model")));
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return cars;
    // }

    // public List<Shops> getAllShopsInfo(){

    //     LinkedList <Shops> shops = new LinkedList<>();
    //     try (Statement statement = this.connection.createStatement()){
    //         ResultSet resultSet = statement.executeQuery("SELECT * FROM shops;");
    //         while (resultSet.next())
    //             shops.add(new Shops(resultSet.getString("name"),
    //                                 resultSet.getString("address")));
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return shops;
    // }

    // public void addUser(String name, String surname, Integer money, String birthday){

    //     try (PreparedStatement statement = this.connection.prepareStatement(
    //             "INSERT INTO Users('name', 'surname', 'money', 'birthday') VALUES (?, ?, ?, ?)");
    //     ){
    //         statement.setObject(1, name);
    //         statement.setObject(2, surname);
    //         statement.setObject(3, money);
    //         statement.setObject(4, birthday);
    //         statement.execute();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
        
    // }

    // public void addCar(String name, String color, String model){

    //     try (PreparedStatement statement = this.connection.prepareStatement(
    //             "INSERT INTO Cars('name', 'color', 'model') VALUES (?, ?, ?)");
    //     ){
    //         statement.setObject(1, name);
    //         statement.setObject(2, color);
    //         statement.setObject(3, model);
    //         statement.execute();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
        
    // }

    // public void addShop(String name, String address){

    //     try (PreparedStatement statement = this.connection.prepareStatement(
    //             "INSERT INTO Shops('name', 'address') VALUES (?, ?)");
    //     ){
    //         statement.setObject(1, name);
    //         statement.setObject(2, address);
    //         statement.execute();
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
        
    // }
}
