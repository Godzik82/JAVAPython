import java.util.Scanner;

public class Homework21{
        
    public static void main(String[] args){
        int i;
        int elm;
        int errors;

        System.out.println("Задача №1: Вывести квадраты чисел от 1 до 25");
        for (i = 1; i < 26; i++)
            System.out.println("Квадрат числа " + i + " равен " + i*i);
            

        System.out.println();
        System.out.println("Задача №2: Вывести целые числа от 100 до 1000, которые делятся на 3 и не делятся на 9 на цело");
        for (i = 100; i < 1001; i++)
            if (i % 3 == 0 && i % 9 != 0)
                System.out.print(i + " ");    
        
        
        System.out.println('\n');
        System.out.println("Задача №3: Даны две матрицы. Найти сумму матриц");
        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество столбцов матриц:");
        int colmatrix = in.nextInt();
        System.out.println("Введите количество строк матриц:");
        int strmatrix = in.nextInt();
        int[][] matrix  = new int[strmatrix][colmatrix];
        
        for (int str = 1; str <= strmatrix; str++){
            for (int col = 1; col <= colmatrix; col++){
                elm = 0;
                for (i = 1; i < 3; i++){
                    System.out.println("Введите " + col + " элемент " + str + " строки " + i +" матрицы:");
                    elm = elm + in.nextInt();
                }
                matrix[str-1][col-1] = elm;
            }
        }
        System.out.println("Сумма введенных матриц:");
        for (int str = 0; str < strmatrix; str++)
            for (int col = 0; col < colmatrix; col++){
                if (col + 1 != colmatrix)
                    System.out.print(matrix[str][col] + " ");
                else System.out.println(matrix[str][col] + " "); 
            }
        

        System.out.println();
        System.out.println("Задача №4: Реализовать алгоритм сортировки пузырьком для массива типа int");
        System.out.println("Введите длину массива");
        int range = in.nextInt();
        int[] arr = new int[range];
        for (i=1; i <= range; i++){
            System.out.println("Введите " + i + " элемент массива:");
            arr[i-1] = in.nextInt();
        }
        int count = 1;

        do{
            for (int elm_arr : arr )
                System.out.print(elm_arr + " ");
            
            errors = 0;
            for (i = 1; i < arr.length; i++) {
                if (arr[i] < arr[i-1]){
                    arr[i-1] = arr[i-1] + arr[i] - (arr[i] = arr[i-1]);
                    errors++;
                }
            }
            
            System.out.println("Итерация № " + count);
            count++;
        } while (errors > 0);
        in.close();
        
    }
}
