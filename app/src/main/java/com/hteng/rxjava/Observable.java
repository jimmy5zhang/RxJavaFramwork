package com.hteng.rxjava;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by jimmyzhang on 2018/5/4.
 */

public class Observable<T> {

    private OnSubscrible<T> onSubscrible;

    private Observable(OnSubscrible<T> onSubscrible) {
        this.onSubscrible = onSubscrible;
    }

    public static <T> Observable<T> create(OnSubscrible<T> onSubscrible) {
        return new Observable<T>(onSubscrible);
    }

    public void subscrible(Subscrible<? super T> subscrible) {
        onSubscrible.call(subscrible);
    }

    public <R> Observable<R> map(Fun1<? super T, ? extends R> fun1) {
        return lift(new OperatorMap<T, R>(fun1));
    }

    public <R> Observable<R> lift(OperatorMap<T, R> trOperator) {
        return new Observable<>(new OnSubscribleLift<>(onSubscrible, trOperator));
    }

    public Observable<T> subscribleOnIO() {
        return create(new OnSubscribleOnIO<T>(this));
    }

    public Observable<T> subscribleMain(){
        return create(new OnSubscrbleMain<T>(new Handler(Looper.getMainLooper()),this));
    }

}
