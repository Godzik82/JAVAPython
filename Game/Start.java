import engine.Engine;

public class Start {

    public static void main(String[] args) throws InterruptedException {
        Engine.createUnit();
        Engine.saveTeam(Engine.battle());
        
    }
    
}
