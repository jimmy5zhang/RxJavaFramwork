package com.hteng.rxjava;

/**
 * Created by jimmyzhang on 2018/5/4.
 */

public class OperatorMap<T, R> implements Operator<R, T> {

    Fun1<? super T, ? extends R> transform;

    public OperatorMap(Fun1<? super T, ? extends R> transform) {
        this.transform = transform;
    }

    @Override
    public Subscrible<? super T> call(Subscrible<? super R> subscrible) {
        return new MapSubscrble<>(subscrible,transform);
    }

    private class MapSubscrble<T, R> extends Subscrible<T> {
        private Subscrible<? super R> actual;

        private Fun1<? super T, ? extends R> transform;

        public MapSubscrble(Subscrible<? super R> actual, Fun1<? super T, ? extends R> transform) {
            this.actual = actual;
            this.transform = transform;
        }

        @Override
        public void onNext(T t) {
            R r = transform.call(t);
            actual.onNext(r);
        }
    }
}
