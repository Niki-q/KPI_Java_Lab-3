package com.company;

public interface MatrixInt<T> {
    abstract int hashCode();

    abstract boolean equals(Object o);

    abstract String toString();

    abstract Class<? extends T> getCls();
}


