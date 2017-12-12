/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ldroid.kwei;


import com.ldroid.kwei.executor.PostExecutionThread;
import com.ldroid.kwei.executor.ObserveThread;
import com.ldroid.kwei.executor.UIThread;
import com.ldroid.kwei.executor.WorkerThread;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;


public class UseCaseHandler {

    private static UseCaseHandler INSTANCE;

    private final ObserveThread mThreadExecutor;
    private final PostExecutionThread mPostExecutionThread;
    private final CompositeDisposable mDisposables;

    public UseCaseHandler(ObserveThread threadExecutor, PostExecutionThread useCaseScheduler) {
        mThreadExecutor = threadExecutor;
        mPostExecutionThread = useCaseScheduler;
        mDisposables = new CompositeDisposable();

    }

    public <T extends UseCase.RequestValues, R extends UseCase.ResponseValue> void execute(
            final UseCase<T, R> useCase, T values, UseCase.UseCaseCallback<R> callback) {
        useCase.setRequestValues(values);
        final Observable<R> observable = useCase.buildObservable()
                .subscribeOn(mThreadExecutor.getScheduler())
                .observeOn(mPostExecutionThread.getScheduler());
        addDisposable(observable.subscribeWith(new DefaultObserver<>(callback)));

    }

    private static final class DefaultObserver<R extends UseCase.ResponseValue> extends
            DisposableObserver<R> {

        private final UseCase.UseCaseCallback<R> mCallback;

        public DefaultObserver(UseCase.UseCaseCallback<R> mCallback) {
            this.mCallback = mCallback;
        }

        @Override
        public void onNext(R r) {
            mCallback.onSuccess(r);
        }

        @Override
        public void onComplete() {

        }

        @Override
        public void onError(Throwable exception) {
            mCallback.onError(exception);
        }
    }


    public void dispose() {
        if (!mDisposables.isDisposed()) {
            mDisposables.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        mDisposables.add(disposable);
    }

    public static UseCaseHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UseCaseHandler(new WorkerThread(), new UIThread());
        }
        return INSTANCE;
    }
}
