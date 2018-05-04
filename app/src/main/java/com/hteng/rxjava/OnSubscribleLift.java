package com.hteng.rxjava;

/**
 * Created by jimmyzhang on 2018/5/4.
 */

public class OnSubscribleLift<T,R> implements OnSubscrible<R> {

    OnSubscrible<T> parent;

    Operator<? extends R, ? super T> operator;

    public OnSubscribleLift(OnSubscrible<T> parent, Operator<? extends R, ? super T> operator) {
        this.parent = parent;
        this.operator = operator;
    }

    @Override
    public void call(Subscrible<? super R> subscrible) {

        Subscrible<? super T> st = operator.call(subscrible);
        parent.call(st);
    }
}
