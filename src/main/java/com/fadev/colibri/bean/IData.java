package com.fadev.colibri.bean;

public interface IData<T> {

    String getId();

    void update(T other);
}
