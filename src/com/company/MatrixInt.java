package com.company;

import java.util.Arrays;
import java.util.Objects;

public interface MatrixInt<T> {
    int rows = 1;
    int columns = 1;
    abstract int hashCode();
    abstract boolean equals(Object o);
    abstract String toString();
    abstract void randomFill();
    abstract  Class<? extends T> getCls();

}
