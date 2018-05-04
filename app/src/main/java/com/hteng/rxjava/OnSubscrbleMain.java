package com.hteng.rxjava;

import android.os.Handler;

/**
 * Created by jimmyzhang on 2018/5/4.
 */

public class OnSubscrbleMain<T> implements OnSubscrible<T> {

    private Handler handler;
    private Observable<T> source;

    public OnSubscrbleMain(Handler handler, Observable<T> source) {
        this.handler = handler;
        this.source = source;
    }

    @Override
    public void call(final Subscrible<? super T> subscrible) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                source.subscrible(subscrible);
            }
        });
    }
}
