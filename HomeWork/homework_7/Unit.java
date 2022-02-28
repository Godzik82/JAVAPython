package homework_7;

public class Unit <M, N>{

    M id;
    N cardNumber;

    public Unit (M id, N cardNumber){
        this.id = id;
        this.cardNumber = cardNumber;
    }

    public void info(){
        System.out.println("Unit id = " + id);
        System.out.println("Unit cardNumber = " + cardNumber);
    }


    
}
