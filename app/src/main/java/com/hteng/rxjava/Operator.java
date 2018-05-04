package com.hteng.rxjava;

/**
 * Created by jimmyzhang on 2018/5/4.
 */

public interface Operator<T, R> extends Fun1<Subscrible<? super T>, Subscrible<? super R>> {
}
