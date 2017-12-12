/**
 *
 */
package com.example.comldroidtest.login;

import android.support.annotation.NonNull;

import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.UseCaseHandler;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private LoginUseCase mLoginUseCase;
    private UseCaseHandler mUseCaseHandler;


    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
        mLoginUseCase = new LoginUseCase();
    }


    @Override
    public void reqLogin(@NonNull String name, @NonNull String password) {
        LoginUseCase.RequestValues requestValue = new LoginUseCase.RequestValues(name, password);
        if (!requestValue.checkInput()) {
            mView.onError("....");
            return;
        }
        mView.showLoading("账号登录...");
        mUseCaseHandler.execute(mLoginUseCase, requestValue, new UseCase.UseCaseCallback<LoginUseCase.ResponseValue>() {
            @Override
            public void onSuccess(LoginUseCase.ResponseValue response) {
                mView.dismissLoading();
                // ...
                mView.onRespLogin();
            }

            @Override
            public void onError(Throwable exception) {
                mView.dismissLoading();
                // ...
                mView.onError(exception.toString());
            }
        });
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
