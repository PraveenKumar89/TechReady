package com.techready.java.day01.example01;

public class Add implements MathOperator<Integer> {
    @Override
    public Integer compute(Integer a, Integer b) {
        return a + b;
    }
}
