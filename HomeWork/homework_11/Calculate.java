package homework_11;

public class Calculate extends Thread{
    Integer num;
    Integer degree;

    public Calculate(int x, int y){
        this.num = x;
        this.degree = y;
    }

    @Override
    public void run(){
        System.out.println("Начало вычисления " + num + " в степени " + degree);
        Integer result = 1;
        for (int i = 0; i < degree; i++)
            result *= num;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Число %d в степени %d равно %d%n", num, degree, result);
    }
}
