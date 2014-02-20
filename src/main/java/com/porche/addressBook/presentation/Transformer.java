package com.porche.addressBook.presentation;

public interface Transformer<F, T> {

    T transform(F transformed);

}
