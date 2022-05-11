package homework_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Menu {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // private String choose = null;
    
    public void start(){
        String choose = null;   
        
        do{
            System.out.println("""
                -----МЕНЮ-----
                1. Ввод данных
                2. Вывод данных
                3. Выход
                """);
            
            try {            
                choose = reader.readLine();
                if (choose.equals("1"))
                    inputData();
                else if (choose.equals("2"))
                    outputData();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            
        }
        while(!choose.equals("3"));
        }

    public void inputData() {
        String[] inputData;
        String choose = null;

        try {
            DBHandler dbHandler = DBHandler.getInstance();
            System.out.println("""
                -----Выберите таблицу для ввода данных-----
                1. Cars
                2. Shops
                3. Users
                """);        
            
            choose = reader.readLine();
            
            if (choose.equals("1")){
                System.out.println("Введите name, color, model через пробел:");
                inputData = reader.readLine().split(" ");
                dbHandler.addCar(inputData[0], inputData[1], inputData[2]);
                System.out.println("Данные введены в таблицу Cars успешно ...\n");
            }
            else if (choose.equals("2")){
                System.out.println("Введите name, address через пробел:");
                inputData = reader.readLine().split(" ", 2);
                dbHandler.addShop(inputData[0], inputData[1]);
                System.out.println("Данные введены в таблицу Shops успешно ...\n");
            }
            else if (choose.equals("3")){
                System.out.println("Введите name, surname, money, birthday(dd.mm.yyyy) через пробел:");
                inputData = reader.readLine().split(" ");
                dbHandler.addUser(inputData[0], inputData[1], Integer.parseInt(inputData[2]), inputData[3]);
                System.out.println("Данные введены в таблицу Users успешно ...\n");
            }
            
        }catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void outputData(){

        String choose = null;

        try {    
            DBHandler dbHandler = DBHandler.getInstance();
            System.out.println("""
                -----Выберите таблицу для вывода данных-----
                1. Cars
                2. Shops
                3. Users
                """);
            choose = reader.readLine();
            
            if (choose.equals("1")){
                System.out.println("-------- Cars --------");
                List<Cars> cars = dbHandler.getAllCarsInfo();
                for (Cars car : cars)
                    System.out.println(car.info());
                System.out.println("");
            }
            else if (choose.equals("2")){
                System.out.println("-------- Shops --------");
                List<Shops> shops = dbHandler.getAllShopsInfo();
                for (Shops shop : shops)
                    System.out.println(shop.info());
                System.out.println("");
            }
            else if (choose.equals("3")){
                System.out.println("-------- Users --------");
                List<Users> users = dbHandler.getAllUsersInfo();
                for (Users user : users)
                    System.out.println(user.info());
                System.out.println("");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

