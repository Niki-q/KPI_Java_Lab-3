package com.company;


public final class MatrixUM<T extends Number> extends Matrix<T> implements MatrixInt {

    public MatrixUM(Class<? extends T> cls) throws MatrixException {
        super(cls);
    }

    public MatrixUM(Class<? extends T> cls, int rows, int columns) throws MatrixException {
        super(cls, rows, columns);
    }

    public MatrixUM(Matrix<T> name) {
        super(name);
    }

    public MatrixUM(MatrixUM<T> name) {
        super(name);
    }
    public MatrixUM<T> fillElement(int position_y, int position_x, int value){
        MatrixUM<T> m = new MatrixUM<>(this);
        m.matrixgeneric[position_y][position_x] = cls.cast(value);
        return m;
    }
@Override
    public MatrixUM<T> randomFill() throws MatrixException {
        MatrixUM<T> m = new MatrixUM<T>(cls,rows,columns);
        for(int i = 0; i < m.getRows(); i++) {
            for(int j = 0; j < m.getColumns(); j++) {
                int CONST_RANDOM = 99;
                if (m.cls.equals(Integer.class)){
                    m.matrixgeneric[i][j] = m.cls.cast((int) (Math.random() * CONST_RANDOM));
                }
                else{
                    m.matrixgeneric[i][j] = m.cls.cast(Math.random()* CONST_RANDOM);
                }
            }
        }
        return m;
    }

@Override
    public MatrixUM<T> transposed() throws MatrixException {
        MatrixUM<T> newMatrix = new MatrixUM<>(this);
        for (int j = 0; j < getColumns(); j++) {
            newMatrix.getMatrix()[j] = getColumn(j);
        }
        return newMatrix;
    }
    public static <T extends Number> MatrixUM<T> createOneColumnRandom(Class<? extends T> cls,int elem) throws MatrixException {
        MatrixUM<T> m = new MatrixUM<T>(cls,elem,1);
        m = m.randomFill();
        return m;
    }
}