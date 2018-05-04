package com.hteng.rxjava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jimmyzhang on 2018/5/4.
 */

public class OnSubscribleOnIO<T> implements OnSubscrible<T> {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    Observable<T> source;

    public OnSubscribleOnIO(Observable<T> source) {
        this.source = source;
    }

    @Override
    public void call(final Subscrible<? super T> subscrible) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                source.subscrible(subscrible);
            }
        };
        executorService.submit(runnable);
    }
}
