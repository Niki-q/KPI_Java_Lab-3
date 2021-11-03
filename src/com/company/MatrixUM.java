package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public final class MatrixUM extends Matrix implements MatrixInt{

    private final int rows;
    private final int columns;
    private int[][] matrix;
    private ArrayList<Integer> matrix2;
    private final int CONST_RANDOM = 99;


    public String toString() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                str += matrix[i][j] + " ";
                if (j == columns - 1) {
                    str += "\n";
                }
            }
        }
        return str;
    }

    public MatrixUM() {
        this.rows    = 0;
        this.columns = 0;
        this.matrix  = new int[rows][columns];
    }
    public MatrixUM(int rows, int columns, String def) {
        this.rows    = rows;
        this.columns = columns;
        this.matrix  = new int[rows][columns];
        if (Objects.equals(def, "rand")){
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < columns; j++) {
                    matrix[i][j] = (int) (Math.random()*CONST_RANDOM);
                }
            }
        }
    }

    public MatrixUM(MatrixUM name){
        columns = name.columns;
        rows = name.rows;
        this.matrix = new int[rows][columns];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrix[i][j] = name.matrix[i][j];
            }
        }
    }

    @Override
    public void fillElement(int position_y, int position_x, int value){
        System.out.println("Ummutable matrixs dont`t alliows setter methods");
    }
    @Override
    public void randomFill(){
        System.out.println("Ummutable matrixs dont`t alliows setter methods");
    }

    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Matrix m)) {
            return false;
        }
        return Arrays.deepEquals(matrix, m.matrix) && m.rows == rows && m.columns == columns;
    }
    @Override
    public int hashCode(){
        return Objects.hash(rows, columns, Arrays.deepHashCode(matrix));
    }
    @Override
    public int getRows() {
        return this.rows;
    }
    @Override
    public int getColumns() {
        return this.columns;
    }
    @Override
    public int[] getColumn(int n){
        int [] column = new int[rows];
        for(int i = 0; i < rows; i++) {
            column[i] = matrix[i][n];
        }
        return column;
    }
}