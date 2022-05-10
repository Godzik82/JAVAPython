package homework_10;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class HomeWork {
    private static Random rnd = new Random();
    public static void main (String[] args){
        // System.out.println(Arrays.toString(generateWordMassive()));
        String[] exampleStringMassive = generateWordMassive();
        System.out.println("Исходный массив - " + Arrays.toString(exampleStringMassive));
        String textBlock = """

                            Параметры выборки:
                            - длина слова больше 2 символов;
                            - содержит букву А;
                            - пропускает 1 слово в выборке;
                            - добавляет к слову '_!';
                            - максимальный размер выборки 2 слова;
                            - отсортировывает выборку.
                            
                            """;
        System.out.print(textBlock); 
        Stream<String> streamFromArrays = Arrays.stream(exampleStringMassive);
        String[] finishStrArray = streamFromArrays.filter(name -> name.length() > 2 
                    && name.toLowerCase().contains("a"))
                    .skip(1)
                    .map(name -> name + "_!")
                    .limit(2)
                    .sorted()
                    .toArray(String[]::new);
        System.out.println("Итоговый массив - " + Arrays.toString(finishStrArray) + "\n");
        streamFromArrays.close();
        
        Integer[] exampleIntMassive = generateIntMassive();
        System.out.println("Исходный массив - " + Arrays.toString(exampleIntMassive));
        String textBlock2 = """

                            Параметры выборки:
                            - выбирает числа между 20 и 30;
                            - умножает их на 2;
                            - суммирует оставшиеся числа.
                                                        
                            """;
        System.out.print(textBlock2); 
        Stream <Integer> streamFromArraysInt = Arrays.stream(exampleIntMassive);
        Integer finishIntArray = streamFromArraysInt.filter(num -> num > 20 && num < 30)
                                .map(num -> num * 2)
                                .reduce(0, Integer::sum);
        System.out.println("Сумма элементов выборки равна - " + finishIntArray);

    }

    public static String[] generateWordMassive(){
        
        String[] stringMassive = new String[20];
        char[] charList = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm".toCharArray();
        Integer wordLength;
        for (int i = 0; i < 20; i ++){
            wordLength = rnd.nextInt(1, 10);
            StringBuilder randomWord = new StringBuilder();
            for (int j = 0; j < wordLength; j++){
                randomWord.append(charList[rnd.nextInt(charList.length)]);
            }
            stringMassive[i] = randomWord.toString();
        }
        return stringMassive;

        
    }

    public static Integer[] generateIntMassive(){
        
        Integer[] intMassive = new Integer [20];
        for (int i = 0; i < 20; i ++){
            intMassive[i] = rnd.nextInt(100);
        }
        return intMassive;
    }
    
}
