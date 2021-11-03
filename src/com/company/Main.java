package com.company;

import java.util.Arrays;

import static com.company.Checker.print;
import static com.company.Utility.*;

public class Main {

    public static void main(String[] args) throws MatrixException {
        // 2
        printNumberOfTusk(2);
        Matrix m1 = new Matrix(3, 4);

        Matrix m2 = new Matrix(m1);
        // copying empty matrix 3 * 4

        // 3
        printNumberOfTusk(3);
        m1.randomFill();

        m1.fillElement(0, 0, 0);

        print(m1.toString());

        // 4
        printNumberOfTusk(4);
        print("3nd element of 2 line");
        print(m1.getElement(1,2)+"");
        print("2th line");
        print(Arrays.toString(m1.getRow(1)));
        print("1th column");
        print(Arrays.toString(m1.getColumn(0)));

        // 5
        printNumberOfTusk(5);
        print("Dimention is ");
        print(Arrays.toString(m1.getDimension()));

        // 6
        printNumberOfTusk(6);

        m2 = new Matrix(m1);
        print(m2.hashCode()+"");
        print(m1.hashCode()+"");
        print(m1.equals(m2)+"");
        printDelimiter(1);


        // change 1st element of 1st row in m1
        m1.fillElement(0,0,1);
        print(m1.toString());
        print(m2.toString());

        print(m2.hashCode()+"");
        print(m1.hashCode()+"");
        printDelimiter(1);
        print(m1.equals(m2)+"");

        // 7
        printNumberOfTusk(7);
        MatrixUM m3 = new MatrixUM(3,2,"rand");

        print(m1.toString());
        print(m3.toString());


        m3.fillElement(0,0,6);
        m3.randomFill();
        print(m3.toString());

        // 1 var4
        printNumberOfTusk("1 var 4");
        print("OneColumn random");
        Matrix m6 = Matrix.createOneColumnRandom(10);
        print(m6.toString());


        // 2 var4
        printNumberOfTusk("2 var 4");
        print("Matrix m1");
        print(m1.toString());
        print("Transposed matrix by m1");
        print(m1.transposed().toString());

        printNumberOfTusk("2 var 4");
        print("Matrix m1");
        print(m3.toString());
        print("Transposed matrix by m1");
        print(m3.transposed().toString());

    }

}
