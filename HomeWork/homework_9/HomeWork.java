package homework_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeWork {
    
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите массив типа int через пробел:");
        Integer[] intMassive = convertStringToInt(reader.readLine().split(" "));
        Sumer sumer = (Integer x, Integer y) -> x + y;
        
        System.out.println("Сумма элементов массива равна: " + reduce(intMassive, sumer));      
    }

    public static Integer[] convertStringToInt(String[] massive){
        if (massive[0].equals(""))
            return new Integer[0];
        else{
        Integer[] convertMassive = new Integer[massive.length];
        for (Integer i = 0; i < massive.length; i++)
            convertMassive[i] = Integer.parseInt(massive[i]);
        return convertMassive;
        }
    }

    public static Integer reduce(Integer[] massive, Sumer sumer){
        if (massive.length == 0)
            return 0;
        else if (massive.length == 1)
            return massive[0];
        else if (massive.length == 2)
            return massive[0] + massive[1];
        else {
            Integer sum = sumer.sum(massive[0], massive[1]);
            for (Integer i = 2; i < massive.length; i++)
                sum = sumer.sum(sum, massive[i]);
            return sum;
        }
    }
}