package homework_6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Car implements Serializable{
    private static final long serialVersionUID = 1L;

    protected long cacheID;
    protected String model;
    protected String transmition;
    protected String color;
    protected int speed;
    protected int weight;
    protected int year;
    
    File file = new File ("./HomeWork/homework_6/car.txt"); 

    public Car(String model, String transmition, String color, int speed, int weight, int year){
        this.model = model;
        this.transmition = transmition;
        this.color = color;
        this.speed = speed;
        this.weight = weight;
        this.year = year;
    }

    public static Car createFromDisk(File file) throws ClassNotFoundException{
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            Car newCar = (Car) ois.readObject();
            return new Car(newCar.model, newCar.transmition, newCar.color, newCar.speed, newCar.weight, newCar.year);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        return null;
        
    }

    public static void writeToDisk(File file, String model, String transmition, String color, int speed, int weight, int year){
    
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(new Car (model, transmition, color, speed, weight, year));
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString(){
        return "Car{" + "model=" + model +
                ", transmition=" + transmition +
                ", color=" + color +
                ", speed=" + speed +
                ", weight=" + weight +
                ", year=" + year +
                "}";
    }

}
    

