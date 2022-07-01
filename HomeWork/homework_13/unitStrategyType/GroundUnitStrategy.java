package homework_13.unitStrategyType;

import java.util.Random;

import homework_13.Interfaces.UnitStrategy;

public class GroundUnitStrategy implements UnitStrategy{

    Random rnd = new Random();
    
    @Override
    public String setName() {
        return "GroundUnit rank - ";
    }

    @Override
    public String setWeapon() {
        return "Sword: class ";
        
    }
    @Override
    public Integer setArmour() {
        return rnd.nextInt(10,20);
        
    }
    @Override
    public Integer setHealth() {
        return rnd.nextInt(50, 100);
        
    }
    @Override
    public Integer setSelfAttack() {
        return rnd.nextInt(1,10);        
    }

    // @Override
    // public Map<String, String> create(Integer rank) {
    //     System.out.println(setParams(rank));
    //     return setParams(rank);
    // }
    
    // public HashMap<String, String> setParams(Integer rank){
    //     HashMap<String, String> info =  new HashMap<>();
    //     Integer hp = 0;
    //     Integer selfAttack = 0;
    //     String weapon = "No weapon";
    //     Integer armour = 0;

    //     switch(rank){
    //         case 1:
    //             selfAttack = rnd.nextInt(1, 10);
    //             hp = rnd.nextInt(100, 200);
    //             weapon = ("Wooden sword");
    //             armour = rnd.nextInt(1, 5);
    //             break;
    //         case 2: 
    //             selfAttack = rnd.nextInt(11, 20);
    //             hp = rnd.nextInt(201, 300);
    //             weapon = ("Steel sword");
    //             armour = rnd.nextInt(6, 10);
    //             break;
    //         case 3:
    //             selfAttack = rnd.nextInt(21, 30);
    //             hp = rnd.nextInt(301, 400);
    //             weapon = ("Damask's steel sword");
    //             armour = rnd.nextInt(11, 15);
    //             break;
    //         case 4:
    //             selfAttack = rnd.nextInt(31, 40);
    //             hp = rnd.nextInt(401, 500);
    //             weapon = ("Two handend sword");
    //             armour = rnd.nextInt(16, 20);
    //             break;
    //         case 5:
    //             selfAttack = rnd.nextInt(41, 50);
    //             hp = rnd.nextInt(501, 600);
    //             weapon = ("Paladin's sword");
    //             armour = rnd.nextInt(21, 25);
    //             break;
    //         case 6: 
    //             selfAttack = rnd.nextInt(51, 60);
    //             hp = rnd.nextInt(601, 700);
    //             weapon = ("Excalibur");
    //             armour = rnd.nextInt(26, 30);
    //             break;
    //         default:
    //             logger.info("Invalid rank. The rank must be in range from 1 to 6.");
    //     };
        
    //     info.put("name", "GroundUnit (rank - " + rank + ")");        
    //     info.put("selfAttack", Integer.toString(selfAttack));
    //     info.put("hp", Integer.toString(hp));
    //     info.put("armour", Integer.toString(armour));
    //     info.put("weapon", weapon);

    //     return info;
    // }
    
    // @Override
    // public void info(){
    //     StringBuilder params = new StringBuilder();
    //     params.append("Name - " + name + "\n");
    //     params.append("Health - " + hp + "\n");
    //     params.append("SelfAttack - " + selfAttack + "\n");
    //     params.append("Armour - " + armour + "\n");
    //     params.append("Weapon - " + weapon + "\n");
    //     logger.info("---- Created Unit ----\n" + params);
    // }
    
}
