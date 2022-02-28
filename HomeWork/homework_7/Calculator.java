package homework_7;

public class Calculator <M>{

    M x;
    M y;

    public Calculator(M x, M y) {
        this.x = x;
        this.y = y;
    }

    public M getX(){
        return x;
    }

    public M getY(){
        return y;
    }

    
    public void sumNum(Double x, Double y){
        System.out.println("Сумма x и у равна: " + (x + y));
    }

    public void minusNum(Double x, Double y){
        System.out.println("Разность x и у равна: " + (x - y));
    }

    public void multiNum(Double x, Double y){
        System.out.println("Произведение x и у равна: " + (x * y));
    }

    public void divideNum(Double x, Double y){
        if (y != 0.0)
            System.out.println("Деление x на у равна: " + (x / y));
        else 
            System.out.println("Деление на ноль");
    }

    public void sumStr(String x, String y){
        System.out.println("Сумма x и у равна: " + (Double.parseDouble(x) + Double.parseDouble(y)));
    }
    
    public void minusStr(String x, String y){
        System.out.println("Разность x и у равна: " + (Double.parseDouble(x) - Double.parseDouble(y)));
    }

    public void multiStr(String x, String y){
        System.out.println("Произведение x и у равна: " + (Double.parseDouble(x) * Double.parseDouble(y)));
    }

    public void divideStr(String x, String y){
        if (y != "0.0")
            System.out.println("Деление x на у равна: " + (Double.parseDouble(x) / Double.parseDouble(y)));
        else 
            System.out.println("Деление на ноль");        
    }
}