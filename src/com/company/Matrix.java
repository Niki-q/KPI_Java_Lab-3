package com.company;

import java.util.Arrays;
import java.util.Objects;

import java.lang.reflect.Array;


public class Matrix<T extends Number> implements MatrixInt {

    protected final int rows;
    protected final int columns;
    protected T[][] matrixgeneric;
    protected final Class<? extends T> cls;

    public Class<? extends T> getCls() {
        return this.cls;
    }
    public String toString() {
        String str = "";
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                str += getElement(i, j) + " ";
                if (j == this.getColumns() - 1) {
                    str += "\n";
                }
            }
        }
        return str;
    }
    public Matrix(Class<? extends T> cls, int rows, int columns) throws MatrixException {
        this.cls = cls;

        if(rows <= 0 || columns <= 0) {
            throw new MatrixException("Заданы неверные размеры матрицы");
        }

        this.rows    = rows;
        this.columns = columns;
        this.matrixgeneric  = (T[][]) Array.newInstance(this.cls, this.rows, this.columns);
    }
    public Matrix(Class<? extends T> cls) throws MatrixException {
        this(cls,0,0);
    }
    public Matrix(Matrix<T> name){
        this.cls = name.getCls();
        this.columns = name.getColumns();
        this.rows = name.getRows();
        this.matrixgeneric  = (T[][]) Array.newInstance(cls, rows, columns);

        for(int i=0; i<this.getRows(); i++) {
            for(int j=0; j<this.getColumns(); j++) {
                this.matrixgeneric[i][j] = name.getElement(i,j);
            }
        }
    }
    public Matrix(MatrixUM<T> name){
        this.cls = name.getCls();
        this.columns = name.getColumns();
        this.rows = name.getRows();
        this.matrixgeneric  = (T[][]) Array.newInstance(this.cls, this.rows, this.columns);

        for(int i=0; i<this.getRows(); i++) {
            for(int j=0; j<this.getColumns(); j++) {
                this.matrixgeneric[i][j] = name.getElement(i,j);
            }
        }
    }
    public Matrix<T> randomFill() throws MatrixException {
        for(int i = 0; i < this.getRows(); i++) {
            for(int j = 0; j < this.getColumns(); j++) {
                int CONST_RANDOM = 99;
                if (this.cls.equals(Integer.class)){
                    this.matrixgeneric[i][j] = this.cls.cast((int) (Math.random() * CONST_RANDOM));
                }
                else{
                    this.matrixgeneric[i][j] = this.cls.cast(Math.random()* CONST_RANDOM);
                }
            }
        }
        return this;
    }
    public void fillElement(int position_y,int position_x, T value) {
        this.matrixgeneric[position_y][position_x] = cls.cast(value);
    }
    public T getElement(int i, int j) {
        return this.getMatrix()[i][j];
    }
    public T[] getRow(int n){
        return this.getMatrix()[n];
    }
    public T[] getColumn(int n){
        T[] column = (T[]) Array.newInstance(this.cls, this.rows);
        for(int i = 0; i < rows; i++) {
            column[i] = this.getElement(i,n);
        }
        return column;
    }
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
    public T[][] getMatrix(){
        return this.matrixgeneric;
    }
    @Override
    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Matrix m)) {
            return false;
        }
        return Arrays.deepEquals(this.getMatrix(), m.getMatrix()) && m.getRows() == this.getRows() && m.getColumns() == this.getColumns();
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.getRows(), this.getColumns(), Arrays.deepHashCode(this.getMatrix()));
    }

    public Matrix<T> transposed() throws MatrixException {
        Matrix<T> newMatrix = new Matrix<>(this);
        for (int j = 0; j < getColumns(); j++) {
            newMatrix.getMatrix()[j] = getColumn(j);
        }
        return newMatrix;
    }
    public static <T extends Number> Matrix<T> createOneColumnRandom(Class<? extends T> cls,int elem) throws MatrixException {
        Matrix<T> m = new Matrix<>(cls,elem,1);
        m.randomFill();
        return m;
    }
}

