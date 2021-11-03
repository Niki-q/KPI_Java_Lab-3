package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Matrix implements MatrixInt {

    protected final int rows;
    protected final int columns;
    protected int[][] matrix;
    private ArrayList<Integer> matrix2;
    private final int CONST_RANDOM = 99;

    /****************** 1 ******************/

    public String toString() {
        String str = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                str += getElement(i, j) + " ";
                if (j == columns - 1) {
                    str += "\n";
                }
            }
        }
        return str;
    }
    // выводим матрицу (1)


    /****************** 2 ******************/
    public Matrix() {
        this.rows    = 0;
        this.columns = 0;
        this.matrix  = new int[rows][columns];
    }
    // пустая матрица (2)

    public Matrix(int rows, int columns) throws MatrixException {

        if(rows <= 0 || columns <= 0) {
            throw new MatrixException("Заданы неверные размеры матрицы");
        }

        this.rows    = rows;
        this.columns = columns;
        this.matrix  = new int[rows][columns];
    }
    // матрица по столбцам и колонкам (2)

    public Matrix(Matrix name){
        columns = name.columns;
        rows = name.rows;
        this.matrix = new int[rows][columns];
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrix[i][j] = name.matrix[i][j];
            }
        }
    }

    // копирование матрицы (2)

    /****************** 3 ******************/

    public void randomFill() {

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                matrix[i][j] = (int) (Math.random()*CONST_RANDOM);
            }
        }
    }
    // рандомное заполнение матрицы

    public void fillElement(int position_y,int position_x, int value) {
        this.matrix[position_y][position_x] = value;
    }
    // заполнение элемента матрицы

    /****************** 4 ******************/
@Override
    public int getElement(int i, int j) {
        return matrix[i][j];
    }

    // получаем елемент (4)

    public int[] getRow(int n){
        return matrix[n];
    }
    // получаем строку (4)

    public int[] getColumn(int n){
        int [] column = new int[rows];
        for(int i = 0; i < rows; i++) {
            column[i] = matrix[i][n];
        }
        return column;
    }
    // получаем колонку (4)

    /****************** 5 ******************/
    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public int[] getDimension(){
        int[] Dimension = new int[2];
        Dimension[0] = getRows();
        Dimension[1] = getColumns();
        return Dimension;
    }
    // получаем размерность (5)

    /****************** 6 ******************/

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

    public Matrix transposed() throws MatrixException {
        int newRows = getRows();
        int newColumns = getColumns();

        Matrix newMatrix = new Matrix(newColumns,newRows);
        for (int j = 0; j < getColumns(); j++) {
            newMatrix.matrix[j] =  getColumn(j);
        }
        return newMatrix;
    }

    public static Matrix createOneColumnRandom(int elem) throws MatrixException {
        Matrix m = new Matrix(elem,1);
        m.randomFill();
        return m;
    }
}

