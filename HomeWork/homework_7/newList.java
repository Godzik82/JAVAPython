package homework_7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class newList {
    static Random rnd = new Random();

    public static List<String> create(String[] list){
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            newList.add(list[rnd.nextInt(list.length)]);
        return newList;
    }
    
}
