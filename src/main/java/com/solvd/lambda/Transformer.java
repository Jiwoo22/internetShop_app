package com.solvd.lambda;

@FunctionalInterface
public interface Transformer<T, R>{

    R transform(T t);
}
