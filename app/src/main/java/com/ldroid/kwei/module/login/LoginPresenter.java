/**
 *
 */
package com.ldroid.kwei.module.login;

import android.support.annotation.NonNull;

import com.ldroid.kwei.common.net.DefaultObserver;
import com.ldroid.kwei.entities.in.LoginInEntity;
import com.ldroid.kwei.entities.out.LoginOutEntity;
import com.ldroid.kwei.interactor.LoginInteractor;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private LoginInteractor mInteractor;


    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
        mInteractor = new LoginInteractor();
    }


    @Override
    public void reqLogin(@NonNull String name, @NonNull String password) {
        LoginInEntity in = new LoginInEntity(name, password);
        if (!in.checkInput()) {
            mView.onError(in.getErrors().get(0));
            return;
        }
        mView.showLoading("账号登录...");
        mInteractor.execute(new DefaultObserver<LoginOutEntity>() {
            @Override
            public void onNext(LoginOutEntity result) {
                mView.dismissLoading();
                // ...
                mView.onRespLogin();
            }

            @Override
            public void onComplete() {
                mView.dismissLoading();
            }

            @Override
            public void onError(Throwable exception) {
                mView.dismissLoading();
                mView.onError(exception.toString());
            }
        }, in);
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
