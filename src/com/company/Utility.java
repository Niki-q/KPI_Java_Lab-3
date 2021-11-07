package com.company;

public class Utility {
    static void printDelimiter(int format){
        if (format == 1)
            System.out.println("__________");
        else if (format==0)
            System.out.println("__________\n");
    }
    static void printNumberOfTusk(int task){
        printDelimiter(0);
        print(task+"");
        printDelimiter(0);
    }
    static void printNumberOfTusk(String task){
        printDelimiter(0);
        print(task);
        printDelimiter(0);
    }
    static void print(String s){
        System.out.println(s);
    }
}
