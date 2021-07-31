package com.techready.java.day01.example01;

@FunctionalInterface
public interface MathOperator<T> {
    T compute(T a, T b);
}
