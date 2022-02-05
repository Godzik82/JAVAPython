import java.util.Scanner;

public class Homework_1_2 {
    public static void main(String[] args){
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
        } else {
            System.out.println("Уравнение не имеет решений");
        }
        }
}
