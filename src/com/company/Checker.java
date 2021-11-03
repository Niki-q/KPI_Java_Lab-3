package com.company;

import java.util.Scanner;

public class Checker{
    static String input(String message){
        Scanner in = new Scanner(System.in);
        print(message);
        return in.nextLine();
    }
    static int checkInt(String integer_in_string) throws CheckException{
        int i;
        try{
            i = Integer.parseInt(integer_in_string);
        }catch (Exception e){
            throw new CheckException("Integer");
        }
        return i;
    }
    static int inputInt(String message) throws CheckException {
        int i;
        try{
            i = Integer.parseInt(input(message));
        }catch (Exception e){
            throw new CheckException("Integer");
        }
        return i;
    }
    static double checkDouble(String integer_in_string) throws CheckException{
        double i;
        try{
            i = Double.parseDouble(integer_in_string);
        }catch (Exception e){
            throw new CheckException("Double");
        }
        return i;
    }
    static double inputDouble(String message) throws CheckException {
        double i;
        try{
            i = Double.parseDouble(input(message));
        }catch (Exception e){
            throw new CheckException("Double");
        }
        return i;
    }
    static void print(String s){
        System.out.println(s);
    }

}

// use in java file -

// import static com.company.Checker.*;
