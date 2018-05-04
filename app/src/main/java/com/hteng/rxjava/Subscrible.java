package com.hteng.rxjava;

/**
 * Created by jimmyzhang on 2018/5/4.
 */

public abstract class Subscrible<T> {

    public abstract void onNext(T t);
}
