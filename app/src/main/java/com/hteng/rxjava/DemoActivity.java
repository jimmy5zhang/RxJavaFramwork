package com.hteng.rxjava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DemoActivity extends AppCompatActivity {

    private static final String TAG = DemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
    }

    public void click(View view) {
        Observable.create(new OnSubscrible<String>() {
            @Override
            public void call(Subscrible<? super String> subscrible) {
                Log.d(TAG, "1");
                subscrible.onNext("http://www.baidu.com");
                Log.d(TAG, "2");
                Log.i(TAG,Thread.currentThread().getName());
            }
        }).map(new Fun1<String, Bitmap>() {
            @Override
            public Bitmap call(String s) {
                Log.i(TAG,"3");
                Log.i(TAG,s);
                Log.i(TAG,Thread.currentThread().getName());
                Bitmap bitmap= BitmapFactory.
                        decodeResource(DemoActivity.this.getResources(),R.mipmap.ic_launcher);
                return bitmap;
            }
        }).subscribleMain().subscrible(new Subscrible<Bitmap>() {
            @Override
            public void onNext(Bitmap bitmap) {
                Log.i(TAG,"4");
            }
        });
    }
}
