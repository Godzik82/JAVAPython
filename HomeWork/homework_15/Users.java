package homework_15;

public class Users {
    

    String name;
    String surname;
    Integer money;
    String birthday;

    public Users(String name, String surname, Integer money, String birthday){
        this.name = name;
        this.surname = surname;
        this.money = money;
        this.birthday = birthday;
    }

    public String info(){
        return "Name: " + name + " Surname: " + surname + " Money: " + money + " BirthDay: " + birthday;
    }
}
