package test;

import java.util.Arrays;

public class test1{
    public static void main(String [] args){
        String names = "Anna, Olya, Lena";
        String [] splitNames = names.split(", ");
        System.out.println(Arrays.toString(splitNames));
    }
    
}
