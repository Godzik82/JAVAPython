package engine;
import unit.FlyingUnit;
import unit.GroundUnit;
import unit.MagicUnit;
import unit.Unit;
import items.*;

public class Dictionary {
    static GroundUnit groundUnit;
    static FlyingUnit flyingUnit;
    static MagicUnit magicUnit;
    static Unit[] listUnit = {groundUnit, flyingUnit, magicUnit};
    
    static String[][] groundUnits = new String[][] {
        {"Orc", "1000", "40", "50"},
        {"Elf", "850", "35", "40"},
        {"Paladin", "950", "45", "50"},
        {"Gnome", "800", "40", "30"},
        {"Golem", "1500", "50", "60"}
    };   
    
    static String[][] flyingUnits = new String[][] {
        {"Dragon", "1000", "40"},
        {"Manticora", "850", "35"},
        {"Griffon", "950", "45"}
    };

    static String[][] magicUnits = new String[][] {
        {"Маг", "1000", "40", "50", "60"},
        {"Джин", "850", "35", "40", "70"},
        {"Экзорцист", "950", "45", "50", "60"},
        {"Ведьма", "800", "40", "30", "50"},
        {"Ведьмаг", "1500", "50", "60", "100"}
    };   





    // {"Маг", "750", "35"},

    static String[][] weapons = new String[][] {
        {"Деревянный меч", "65", "10"},
        {"Обычный Меч", "75", "15"},
        {"Меч-кладенец", "80", "20"},
        {"Экскалибур", "90", "25"}
    };

    static String[][] armours = new String[][] {
        {"Кожанная накидка", "1", "5"},
        {"Кольчуга", "10", "25"},
        {"Дамаская броня", "20", "50"},
        {"Доспехи бога", "30", "150"}
    };

    
}
