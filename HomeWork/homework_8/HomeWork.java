package homework_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HomeWork {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static Integer check;
    public static Map<Product, Integer> store = new HashMap<>();

    public static void main (String[] args) throws IOException {
        
        do{
            check = mainMenu();
            if (check == 1)
                putStore();
            else if (check == 2)
                removeFromStore();
            else if (check == 3)
                infoStore();
            else if (check < 1 && check > 4)
                System.out.println("Такой пункт меню отсутствует. Выберите команду заново.");
            }
        while (check != 4);
        System.out.println("Bye!");
        reader.close();
    }

    public static Integer mainMenu() throws IOException {
        System.out.println("____МЕНЮ____\n1. Добавить товар\n2. Удалить товар\n3. Вывести все товары\n4. Выход");
        return  Integer.parseInt(reader.readLine());
    }

    public static void putStore() throws IOException {
        System.out.println("Введите через пробел название товара, его стоимость, количество:");
        String[] infoProduct = reader.readLine().split(" ");
        store.put(new Product(infoProduct[0],
                                Double.parseDouble(infoProduct[1])),
                                Integer.parseInt(infoProduct[2]));
    }

    public static void removeFromStore() throws IOException {
        infoStore();
        if (store.size() != 0)
            System.out.println("Введите через пробел название и цену товара, который будет удален:");
            String[] infoRemoveProduct = reader.readLine().split(" ");
            

        
    }
    
    public static void infoStore(){
        if (store.isEmpty())
            System.out.println("\nНа складе нет товаров\n");
        else {
            System.out.println("На складе находятся следующие товары\nНазвание\tСтоимость\tКоличество");
            for (Map.Entry<Product, Integer> product: store.entrySet())
                System.out.printf("%s\t%9d%n%n", product.getKey().info(), product.getValue());
            }
        }
}

