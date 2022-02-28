package homework_7;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    
    public static void main(String[] args){
        System.out.println("#1 Создать класс для математических вычислений: Содержит 4 статических метода на сложение, вычитание, умножение, деление. Обработать ошибку деления на ноль. Методы должны быть Generic и принимать данные в разных форматах (строка, число)");
        task1();
        System.out.println("#2 Создать дженерик класс User, у которого поля id, card_number могут иметь типы String или int");
        task2();
        System.out.println("Реализовать метод, который принимает на вход список элементов любого типа данных, создает список из 100 элементов заполненный элементами из переданного списка в случайном порядке (Загуглить генерация случайных чисел Java)");
        task3();
    }
    
    public static void task1() {
        Calculator<Double> calcNum = new Calculator(3.0, 0.0);
        calcNum.sumNum(calcNum.getX(), calcNum.getY());
        calcNum.minusNum(calcNum.getX(), calcNum.getY());
        calcNum.multiNum(calcNum.getX(), calcNum.getY());
        calcNum.divideNum(calcNum.getX(), calcNum.getY());

        Calculator <String> calcStr = new Calculator("3.0", "0.0");
        calcStr.sumStr(calcStr.getX(), calcStr.getY());
        calcStr.minusStr(calcStr.getX(), calcStr.getY());
        calcStr.multiStr(calcStr.getX(), calcStr.getY());
        calcStr.divideStr(calcStr.getX(), calcStr.getY());

    }

    public static void task2() {
        Unit<String, Integer> unit1 = new Unit("12", 1234);
        unit1.info();
        Unit<Integer, String> unit2 = new Unit(12, "1234");
        unit2.info();
    }

    public static void task3() {
        String[] inputList;
        
        
        try (Scanner in = new Scanner(System.in)){
            System.out.println("Введите значения списка через пробел:");
            inputList = in.nextLine().split(" ");
            
            System.out.println("Новый список" + newList.create(inputList));

            
            

        
            // listEnter.addAll(in.nextLine().split(" "));

        }

        
    }
}
