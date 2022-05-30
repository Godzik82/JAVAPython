package homework_13.unitType;

import java.util.logging.Logger;
import homework_13.Unit;
import homework_13.unitStrategyType.MagicUnitStrategy;

public class MagicUnit extends Unit{
    
    private static final Logger logger = Logger.getLogger(MagicUnit.class.getName());
    Integer mana;

    public MagicUnit(Integer rank){
        super(new MagicUnitStrategy(),rank);
        this.mana = 50 * rank;
    }

    @Override
    public void info(){
        StringBuilder params = new StringBuilder();
        params.append("Type - " + getClass().getName() + "\n");
        params.append("Name - " + name + "\n");
        params.append("Rank - " + rank + "\n");
        params.append("Health - " + hp + "\n");
        params.append("SelfAttack - " + selfAttack + "\n");
        params.append("Armour - " + armour + "\n");
        params.append("Weapon - " + weapon + "\n");
        params.append("Mana - " + mana + "\n");
        logger.info("---- Created Unit ----\n" + params);
    }
}
