package homework_1;

import java.util.Scanner;

public class HomeWork{
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        task1();
        task2();
        in.close();

    }   
        
    public static void task1() {
        System.out.println("Введите номер месяца:");
        byte month_number = in.nextByte();
        if (0 < month_number && month_number < 12) {
            if (3 > month_number || month_number == 12) 
                System.out.println("Сейчас зима");
            if (2 < month_number && month_number < 6)
                System.out.println("Сейчас весна");
            if (5 < month_number && month_number < 9)
                System.out.println("Сейчас лето");
            if (8 < month_number && month_number < 12)
                System.out.println("Сейчас осень");
        } else 
            System.out.println("Что-то ты напутал. В календаре всего 12 месяцев");
        
        System.out.println("Введите номер месяца:");
        month_number = in.nextByte();
        switch(month_number){
            case 1:
            case 2:
            case 12:
                System.out.println("Сейчас зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Сейчас весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Сейчас лето");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Сейчас осень");
                break;
            default:
                System.out.println("Что-то ты напутал. В календаре всего 12 месяцев");
        }           
    }
    
    private static void task2() {
        double x1;
        double x2;

        Scanner in = new Scanner(System.in);
        System.out.println("Введите первый коэффициент:");
        double a = in.nextByte();
        System.out.println("Введите второй  коэффициент:");
        double b = in.nextByte();
        System.out.println("Введите свободный член:");
        double c = in.nextByte();
        in.close();
        double d = (b*b)-(4*a*c);
        if (d >= 0) {
            if (d == 0) {
                x1 = -1*b/(2*a);
                System.out.println("Уравнение имеет единственный корень: " + x1);
            } else {
                System.out.println(Math.sqrt(d));
                x1 = (-1*b+Math.sqrt(d))/(2*a);
                x2 = (-1*b-Math.sqrt(d))/(2*a);
                System.out.println("Уравнение имеет два корня: " + x1 + " и " + x2);
            }
        } else 
            System.out.println("Уравнение не имеет решений");
    }
}
