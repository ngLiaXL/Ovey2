package com.ldroid.kwei.transformer;

import com.ldroid.kwei.UseCase;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;


public class ErrorTransformer<T extends UseCase.ResponseValue> implements
        ObservableTransformer<T, T> {


    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream.map(new Function<T, T>() {
            @Override
            public T apply(T t) throws Exception {
                return t;
            }
        });
    }
}
