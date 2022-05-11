package homework_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class HomeWork {

    public static void main(String[] args) {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter numer of Kran:");
        
        Integer numKran = 0;
        try {
            numKran = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExecutorService service = Executors.newFixedThreadPool(numKran);
        
        Store store = new Store();
        Producer producer = new Producer(store);
        Docker docker = new Docker(store);
        
        for (int i = 0; i < numKran; i++)
            service.submit(new Kran(store));
        
        new Thread(producer).start();
        new Thread(docker).start();
        
        
    }    
}