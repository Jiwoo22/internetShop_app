package com.solvd.lambda;

@FunctionalInterface
public interface Calculator<T> {

    T calculate(T a, T b);
}
