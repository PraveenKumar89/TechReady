package com.techready.java.day01.casestudy;

public enum GlobalToken {
    MY_TOKEN(1, "my_token", (a, b) -> Math.random()),
    DEFAULT_TOKEN(2, "default_token", (a, b) -> Math.random());

    private GlobalToken(int code, String name, TokenGenerator tokenGenerator) {
        this.code = code;
        this.name = name;
        this.generator = tokenGenerator;
    }

    int code;
    String name;
    TokenGenerator generator;

    public double getRandomNumber(int a, int b) {
        return generator.getValue(a, b);
    }

    public static interface TokenGenerator {
        double getValue(int a, int b);
    }
}
