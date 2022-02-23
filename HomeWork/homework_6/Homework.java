package homework_6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Homework {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        task1();
        task2();
        task3();
    }


    public static void task1() {
        String strInput; 
        Scanner in = new Scanner(System.in);
        File file = new File ("./HomeWork/homework_6/text.txt");
        
        
        System.out.println("#1 Необходимо реализовать класс, который запрашивает данные у пользователя через терминал и записывает их в файл, пока не будет введена команда !q\n");
        
        do{
            System.out.println("Введите данные:");
            strInput = in.nextLine();
            if (!"!q".equals(strInput)){
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
                    writer.write(strInput);
                    writer.newLine(); 
                    System.out.printf("Записано в файл %s%n", file.getName());
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            else break;
        } while (true);
        System.out.println("Введена команда - !q");
        in.close();
    }

    public static void task2() throws IOException {
        File file = new File ("./HomeWork/homework_6/text.csv");
        String[] rowOut;
        String[] rowIn;
        String[] checkNum;
        Person[] arrayPerson;
            
        System.out.println("#2 Необходимо создать класс Person с полями: Имя, Фамилия, возраст, телефон. Записать в формате CSV (Загуглите как он выглядит)  в файл таблицу с указанными выше данными (человек 5 и заголовки). Написать парсер CSV файлов, который должен создать массив объектов класса Person, прочитав данные их csv файла.\n");
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            arrayPerson = new Person[getNumLines(file)];
            checkNum = setNumCol(reader.readLine().split(","));
            
            for (int i = 0; i < arrayPerson.length; i++){
                rowOut = reader.readLine().split(",");
                rowIn = setRowInput(rowOut, checkNum);
                arrayPerson[i] = new Person(rowIn[0], rowIn[1], rowIn[2], rowIn[3], i); 
            }

            for (Person elm : arrayPerson)
                System.out.println(elm.toString());

        }       
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getNumLines(File file) throws IOException {
        String row;
        int count = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            row = reader.readLine();
            while (row != null){
                row = reader.readLine();
                count++;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return count-1;
    }
        
    public static String [] setNumCol(String[] row){

        String numColName = "-1";
        String numColSurname = "-1";
        String numColAge = "-1";
        String numColPhone = "-1";
        for (int i = 0; i < row.length; i++){
            if ("name".equals(row[i]))
                numColName = Integer.toString(i);
            else if ("surname".equals(row[i]))
                numColSurname = Integer.toString(i);
            else if ("age".equals(row[i]))
                numColAge =  Integer.toString(i);
            else if ("phone".equals(row[i]))
                numColPhone = Integer.toString(i);
        }
        return new String []{numColName, numColSurname, numColAge, numColPhone};
    }

    public static String[] setRowInput(String[] rowOut, String[] checkNum) {
        String[] row = new String[4];

        for (String elm : checkNum)
            row[Integer.parseInt(elm)] = rowOut[Arrays.asList(checkNum).indexOf(elm)];
        return row;
    }

    private static void task3() throws ClassNotFoundException {
        System.out.println("\n#3 Реализовать класс Car, с полями присущими автомобилю (скорость, цвет и тд). Создать метод, который бы сохранял указанный объект на диск и статический метод класса, который бы читал файл и создавал объект\n");
        
        Car car = new Car("Ford", "4x4", "white", 200, 1500, 2021);
        Car.writeToDisk(car.file, car.model, car.transmition, car.color, car.speed, car.weight, car.year);
        System.out.println("Write object - " + car.toString());
        Car newCar = Car.createFromDisk(car.file);
        System.out.println("Create object - " + newCar.toString());
    }
}




