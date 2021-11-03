package com.company;

import java.util.Arrays;
import java.util.Objects;

import java.lang.reflect.Array;


public class Matrix<T extends Number> implements MatrixInt {

    protected final int rows;
    protected final int columns;
    protected T[][] matrixgeneric;
    private final int CONST_RANDOM = 99;

    private Class<? extends T> cls;

@Override
    public Class<? extends T> getCls() {
        return cls;
    }

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
    public Matrix(Class<? extends T> cls) {
        this.cls = cls;


        this.rows    = 0;
        this.columns = 0;
        this.matrixgeneric  = (T[][]) Array.newInstance(cls, rows, columns);
    }
    // пустая матрица (2)

    public Matrix(Class<? extends T> cls, int rows, int columns) throws MatrixException {
        this.cls = cls;


        if(rows <= 0 || columns <= 0) {
            throw new MatrixException("Заданы неверные размеры матрицы");
        }

        this.rows    = rows;
        this.columns = columns;
        this.matrixgeneric  = (T[][]) Array.newInstance(cls, rows, columns);
    }
    // матрица по столбцам и колонкам (2)

    public Matrix(Matrix<T> name){
        cls = name.getCls();

        columns = name.columns;
        rows = name.rows;
        matrixgeneric  = (T[][]) Array.newInstance(cls, rows, columns);

        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                matrixgeneric[i][j] = name.matrixgeneric[i][j];
            }
        }
    }

    // копирование матрицы (2)

    /****************** 3 ******************/

    public void randomFill() {

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if (cls.equals(Integer.class)){
                    matrixgeneric[i][j] = cls.cast((int) (Math.random() * CONST_RANDOM));
                }
                else{
                    matrixgeneric[i][j] = cls.cast(Math.random()*CONST_RANDOM);
                }
            }
        }
    }
    // рандомное заполнение матрицы

    public void fillElement(int position_y,int position_x, T value) {
        this.matrixgeneric[position_y][position_x] = cls.cast(value);
    }
    // заполнение элемента матрицы

    /****************** 4 ******************/

    public T getElement(int i, int j) {
        return matrixgeneric[i][j];
    }

    // получаем елемент (4)

    public T[] getRow(int n){
        return matrixgeneric[n];
    }
    // получаем строку (4)

    public T[] getColumn(int n){
        T[] column = (T[]) Array.newInstance(cls,rows);
        for(int i = 0; i < rows; i++) {
            column[i] = matrixgeneric[i][n];
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
        return Arrays.deepEquals(matrixgeneric, m.matrixgeneric) && m.rows == rows && m.columns == columns;
    }
    @Override
    public int hashCode(){
        return Objects.hash(rows, columns, Arrays.deepHashCode(matrixgeneric));
    }

    public Matrix transposed() throws MatrixException {
        int newRows = getColumns();
        int newColumns = getRows();

        Matrix<T> newMatrix = new Matrix<>(cls,newRows,newColumns);
        for (int j = 0; j < getColumns(); j++) {
            newMatrix.matrixgeneric[j] = getColumn(j);
        }
        return newMatrix;
    }

    public static <T extends Number> Matrix<T> createOneColumnRandom(Class<? extends T> cls,int elem) throws MatrixException {
        Matrix<T> m = new Matrix<>(cls,elem,1);
        m.randomFill();
        return m;
    }
}

