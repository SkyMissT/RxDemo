package com.miss.rxdemo.util;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Vola on 2020/10/25.
 */
class RxUtil {

    private static final String TAG = RxUtil.class.getSimpleName();

    public static <UD>ObservableTransformer<UD,UD> rxIo(){
        return new ObservableTransformer<UD, UD>() {
            @Override
            public ObservableSource<UD> apply(Observable<UD> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <UD>ObservableTransformer<UD,UD> rxHook(final String content){
        return new ObservableTransformer<UD, UD>() {
            @Override
            public ObservableSource<UD> apply(Observable<UD> upstream) {

                Log.e(TAG, TAG + content);

                return upstream;
            }
        };
    }

}
