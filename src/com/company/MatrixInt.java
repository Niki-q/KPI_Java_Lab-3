package com.company;

import java.util.Arrays;
import java.util.Objects;

public interface MatrixInt {
    int rows = 1;
    int columns = 1;
    int[][] matrix = new int[rows][columns];
    abstract int hashCode();
    abstract boolean equals(Object o);
    abstract String toString();
    abstract void fillElement(int position_y,int position_x, int value);
    abstract void randomFill();


    default int getElement(int i, int j) {
        return matrix[i][j];
    }

    default int hasCode(){
        return Objects.hash(rows, columns, Arrays.deepHashCode(matrix));
    }


}
