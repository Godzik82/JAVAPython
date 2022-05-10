package homework_15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class HomeWork {

    public static void main(String[] args) {
        
        new Menu().start();
    
        // try {
        //     DBHandler dbHandler = DBHandler.getInstance();
        //     List<Users> users = dbHandler.getAllUsersInfo();
        //     for (Users user : users)
        //         System.out.println(user.info());
            
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }
        // con();
        
    }

    public static void con(){
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:D:/Education/LearnUp/JAVAPython/HomeWork/homework_14/sqlite3.db")) {
            System.out.println(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
