package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public final class MatrixUM<T extends Number> implements MatrixInt {

    final int rows;
    final int columns;
    T[][] matrixgeneric;
    private final int CONST_RANDOM = 99;
    private Class<? extends T> cls;

    @Override
    public Class<? extends T> getCls() {
        return cls;
    }

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

    public MatrixUM(Class<? extends T> cls) {
        this.cls = cls;

        this.rows = 0;
        this.columns = 0;
        this.matrixgeneric = (T[][]) Array.newInstance(cls, rows, columns);
    }

    public MatrixUM(Class<? extends T> cls, int rows, int columns) throws MatrixException {
        this.cls = cls;


        if (rows <= 0 || columns <= 0) {
            throw new MatrixException("Заданы неверные размеры матрицы");
        }

        this.rows = rows;
        this.columns = columns;
        this.matrixgeneric = (T[][]) Array.newInstance(cls, rows, columns);
    }

    public MatrixUM(MatrixUM<T> name) {
        cls = name.getCls();

        columns = name.columns;
        rows = name.rows;
        matrixgeneric = (T[][]) Array.newInstance(cls, rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixgeneric[i][j] = name.matrixgeneric[i][j];
            }
        }
    }
    public MatrixUM(Matrix<T> name) {
        cls = name.getCls();

        columns = name.columns;
        rows = name.rows;
        matrixgeneric = (T[][]) Array.newInstance(cls, rows, columns);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixgeneric[i][j] = name.matrixgeneric[i][j];
            }
        }
    }

    public void fillElement(int position_y, int position_x, int value) {
        System.out.println("Ummutable matrixs dont`t alliows setter methods");
    }

    @Override
    public void randomFill() {
        System.out.println("Ummutable matrixs dont`t alliows setter methods");
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Matrix m)) {
            return false;
        }
        return Arrays.deepEquals(matrixgeneric, m.matrixgeneric) && m.rows == rows && m.columns == columns;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns, Arrays.deepHashCode(matrixgeneric));
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public T getElement(int i, int j) {
        return matrixgeneric[i][j];
    }

    public T[] getColumn(int n){
        T[] column = (T[]) Array.newInstance(cls,rows);
        for(int i = 0; i < rows; i++) {
            column[i] = matrixgeneric[i][n];
        }
        return column;
    }

    public MatrixUM transposed() throws MatrixException {
        int newRows = getColumns();
        int newColumns = getRows();

        MatrixUM<T> newMatrix = new MatrixUM<>(cls, newRows, newColumns);
        for (int j = 0; j < getColumns(); j++) {
            newMatrix.matrixgeneric[j] = getColumn(j);
        }
        return newMatrix;
    }
    public static <T extends Number> MatrixUM<T> createOneColumnRandom(Class<? extends T> cls,int elem) throws MatrixException {
        MatrixUM<T> m = new MatrixUM<>(cls,elem,1);
        m.randomFill();
        return m;
    }
}