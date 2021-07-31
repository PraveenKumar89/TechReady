package com.techready.java.day02.example01;

import java.util.Date;
import java.util.function.Supplier;

public class DateSupplier implements Supplier<Date> {
    @Override
    public Date get() {
        return new Date();
    }
}
