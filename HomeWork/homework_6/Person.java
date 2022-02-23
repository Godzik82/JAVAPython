package homework_6;

import java.io.Serializable;

public class Person implements Serializable{
    static final long serialVersionUID = 1L;
    
    protected transient long cacheID;
    String name;
    String surname;
    String phone;
    String age;
    
    public Person(String name, String surname, String age, String phone, long cacheID){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phone = phone;
        this.cacheID = cacheID;
    }

    @Override
    public String toString(){
        return "Person{" + "name=" + name +
                ", surname=" + surname +
                ", age=" + age +
                ", phone=" + phone +
                ", cacheID=" + cacheID + "}";
    }

}
