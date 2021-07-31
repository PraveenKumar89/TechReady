package com.techready.java.day02.example01;

import java.util.function.Supplier;

public class RandomNumberSupplier implements Supplier<Integer> {
    @Override
    public Integer get() {
        return (int) (Math.random() * 10);
    }
}
