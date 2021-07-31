package com.techready.java.day01.example01;

public class Computation<T> {
    public T operate(T a, T b, MathOperator<T> operator) {
        return operator.compute(a, b);
    }
}
