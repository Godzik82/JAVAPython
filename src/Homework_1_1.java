import java.util.Scanner;

public class Homework_1_1 {
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номер месяца:");
        byte month_number = in.nextByte();
               
        if (0 < month_number && month_number < 12) {
            if (3 > month_number || month_number == 12) {
                System.out.println("Сейчас зима");
            }
            if (2 < month_number && month_number < 6) {
                System.out.println("Сейчас весна");
            }
            if (5 < month_number && month_number < 9) {
                System.out.println("Сейчас лето");
            }
            if (8 < month_number && month_number < 12) {
                System.out.println("Сейчас осень");
            }
        } else {
            System.out.println("Что-то ты напутал. В календаре всего 12 месяцев");
        };
        
        System.out.println("Введите номер месяца:");
        month_number = in.nextByte();
        in.close();

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
}
