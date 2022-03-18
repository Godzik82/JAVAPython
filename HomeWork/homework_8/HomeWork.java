package homework_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HomeWork {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    protected static Integer check;
    protected static final List<Map<Product, Integer>> store = new LinkedList<>();

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
        System.out.println("____МЕНЮ____\n1. Добавить товар\n2. Удалить товар\n3. Вывести все товары\n4. Выход\nВыберите пункт:");
        return  Integer.parseInt(reader.readLine());
    }

    public static void putStore() throws IOException {
        System.out.println("Введите через пробел название товара, его стоимость, количество:");
        String[] infoProduct = reader.readLine().split(" ");
        Map <Product, Integer> newProduct = createProduct(infoProduct);
        System.out.println(addProduct(newProduct));
    }

    public static void removeFromStore() throws IOException {
        infoStore();
        if (store.isEmpty()){
            System.out.println("Введите через пробел название и цену товара, который будет удален:");
            String[] infoRemoveProduct = reader.readLine().split(" ");
            Product removeProduct = new Product(infoRemoveProduct[0], Float.parseFloat(infoRemoveProduct[1]));
            for (Integer i = 0; i < store.size(); i++){
                System.out.println(store.get(i).keySet().hashCode() + " " + removeProduct.hashCode());
                if (store.get(i).keySet().hashCode() == removeProduct.hashCode()){
                    store.remove(store.get(i));
                    System.out.println("Товар удален");
                    break;
                }
            }
        }                      
    }
    
    public static void infoStore(){
        if (store.isEmpty())
            System.out.println("\nНа складе нет товаров\n");
        else {
            System.out.println("На складе находятся следующие товары\nНазвание\tСтоимость\tКоличество");
            for (Map <Product, Integer> product : store)
                for (Map.Entry<Product, Integer> p : product.entrySet())
                    System.out.printf("%-16s%-16.2f%-16d%n",
                                            p.getKey().name,
                                            p.getKey().cost,
                                            product.get(p.getKey()));
            System.out.println("----------END----------\n");
        }
    }

    public static Map<Product, Integer> createProduct(String[] info){
        Map<Product, Integer> product = new HashMap<>();
        product.put(new Product(info[0], Float.parseFloat(info[1])), Integer.parseInt(info[2]));
        return product;
    }
    
    public static String addProduct(Map <Product, Integer> n){
        for(Integer i = 0; i < store.size(); i++)
            if (store.get(i).keySet().hashCode() == n.keySet().hashCode()){
                Integer newValue = store.get(i).get(store.get(i).keySet().toArray()[0]) +
                                    n.get(n.keySet().toArray()[0]);
                store.get(i).replace((Product) store.get(i).keySet().toArray()[0], newValue);
                return "Количество товара " + ((Product) n.keySet().toArray()[0]).getName() + " увеличено";
            }
        store.add(n);
        return "Добавлен товар - " + ((Product) n.keySet().toArray()[0]).getName();
    }
}

