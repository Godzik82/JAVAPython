package homework3;
import java.util.Scanner;

public class HomeWork{
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){ 
        task1();
        task2();
        in.close();
    }

    public static void task1() { 
        double[] abc = new double[3];
        double d;
        int j;

        System.out.println("Задача №1. Переписать задачу на квадратное уравнение выделив отдельные статические методы для вычисления дискриминанта и расчета корней");
        for (int i = 0; i < 3; i++)
            abc[i] = enterABC(i);
        d = diskriminant(abc);
        if (d < 0) j = 0;
        else j = (d > 0 ? 2 : 1);
        solution(d, abc, j); 
    } 

    public static double enterABC(int i) {  
        System.out.println("Введите " + (i+1) + " коэффициент:");
        return in.nextDouble();
        }

    public static double diskriminant(double[] abc){
        return (abc[1]*abc[1])-(4*abc[0]*abc[2]);
    }

    public static void solution(double d, double[] abc, int j){
        switch(j){
            case 1:
                System.out.printf("Единственный корень уравнения: %.1f%n%n", (-abc[1]+Math.sqrt(d))/(2*abc[0]));
                break;
            case 2:
            int count = 1;
            for (int i = - 1; i < 2; i += 2){
                System.out.printf("%d-й корень уравнения: %.1f%n%n", count, (-abc[1]+(Math.sqrt(d)*i))/(2*abc[0]));
                count++;
            }
                break;
            default:
                System.out.println("Уравнение не имеет решений\n");
        }   
    }

    public static void task2() {
        System.out.println("Задача №2. Написать статические методы:\n- взятия факториала некоторого числа\n- возведения числа x в степень y\n\nВведите целое число, факториал которого необходимо вычислить:");
        int x = in.nextInt();
        System.out.println("Факториал числа " + x + " равен " + factorial(x) + "\n");
        System.out.println("Введите число и его степень через пробел: ");
        in.nextLine();
        String[] xy = in.nextLine().split(" ");
        System.out.println("Число " + xy[0] + " в степени " + xy[1] + " равно: " + degree(Double.parseDouble(xy[0]), Integer.parseInt(xy[1])));        
    }

    public static int factorial(int x){
        if (x > 1)
            return x * factorial(x - 1);
        else
            return 1;
    }

    public static double degree(double x, int y) {
        if (y == 0)
            return 1;
        else if (y == 1)
            return x;
        else if (y == -1)
            return 1 / x;
        else if (y > 1)
            return x * degree(x, y - 1);
        else
            return 1 / x * degree(x, y + 1);
    }
}
