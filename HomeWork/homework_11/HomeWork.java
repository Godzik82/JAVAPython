package homework_11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HomeWork{
    
    private static String choose;
    public static void main (String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            do{
                System.out.println("""
                            -----МЕНЮ-----
                            1. Ввод данных
                            2. Показать вычисления
                            3. Выход
                            """);
                try {            
                    choose = reader.readLine();
                } catch (Exception e) {
                    System.out.println("Ошибка" + e.getMessage());
                } 
                if (choose.equals("1")){
                    System.out.println("Введите число и его степень через пробел:");
                    try{
                    String[] param = reader.readLine().split(" ");
                    new Calculate(Integer.parseInt(param[0]), Integer.parseInt(param[0])).start();
                    Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    catch (Exception e){
                        System.out.println("Ошибка" + e.getMessage());
                    }
                }
                else if (choose.equals("2")){
                    System.out.println("Показ вычислений в течение 3 секунд");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                

            } while (!choose.equals("3"));
    }
}
