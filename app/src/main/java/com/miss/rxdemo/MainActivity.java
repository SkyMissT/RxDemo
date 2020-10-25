package com.miss.rxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     *          只有源头和终点，便于分析
     */
    void funOne() {

        Observable
                //  1. Observable.create
                //  return new ObservableCreate<T>(source)     source---> ObservableOnSubscribe<String> ,第一步只有把source放入，没啥别的操作
                //  2.1.4   emitter.onNext("start") 的实现   emitter 即 CreateEmitter<String>
                //      CreateEmitter.onNext("start") 内部调用  observer.onNext(t); 即调用终点的onNext
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        emitter.onNext("start");
                        emitter.onNext("end");
                        emitter.onComplete();
                    }
                })
                //  2. ObservableCreate.subscribe
                //  2.1 调用  ObservableCreate.subscribeActual(observer)
                //  2.1.1   CreateEmitter<T> parent = new CreateEmitter<T>(observer);   将observer装箱，放入CreateEmitter
                //  2.1.2   observer.onSubscribe(parent);  调用Observer的订阅方法,此时可以接受一个Disposable，用于终止
                //  2.1.3    source.subscribe(parent);      此处的source是 1 的source，即是ObservableOnSubscribe<String>().parent是source装箱后的一级包CreateEmitter<String> ，实现咱们在
                //          public void subscribe(ObservableEmitter<String> emitter) 中的方法:
                //              emitter.onNext("start");emitter.onNext("end");emitter.onComplete();
                .subscribe(new Observer<String>() {

                    //  2.1.2   实现的地方，实现订阅
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    //  2.1.4   实现调用的地方
                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

}