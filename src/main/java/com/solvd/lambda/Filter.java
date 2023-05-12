package com.solvd.lambda;

@FunctionalInterface
public interface Filter<T, R> {

    R filter(T t);
}
