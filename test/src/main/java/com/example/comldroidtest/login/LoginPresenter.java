/**
 *
 */
package com.example.comldroidtest.login;

import android.support.annotation.NonNull;

import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.UseCaseHandler;

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View mView;
    private UseCaseHandler mUseCaseHandler;


    public LoginPresenter(LoginContract.View view) {
        this.mView = view;
        mUseCaseHandler = new UseCaseHandler();
    }


    @Override
    public void reqLogin(@NonNull String name, @NonNull String password) {
        LoginUseCase.RequestValues requestValue = new LoginUseCase.RequestValues(name, password);
        if (!requestValue.checkInput()) {
            mView.onError("....");
            return;
        }
        mView.showLoading("账号登录...");
        mUseCaseHandler.execute(new LoginUseCase(), requestValue, new UseCase.UseCaseCallback<LoginUseCase
                .ResponseValue>() {
            @Override
            public void onSuccess(LoginUseCase.ResponseValue response) {
                mView.hideLoading();
                // ...
                mView.onRespLogin(response);
            }

            @Override
            public void onError(Throwable exception) {
                mView.hideLoading();
                // ...
                mView.onError(exception.toString());
            }
        });
    }

    public void reqUpload() {
        UploadUseCase.RequestValues requestValue = new UploadUseCase.RequestValues();
        if (!requestValue.checkInput()) {
            mView.onError("....");
            return;
        }
        mView.showLoading("账号登录...");
        mUseCaseHandler.execute(new UploadUseCase(), requestValue, new UseCase
                .UseCaseCallback<UploadUseCase
                .ResponseValue>() {
            @Override
            public void onSuccess(UploadUseCase.ResponseValue response) {
                mView.hideLoading();
                // ...
                mView.onRespUpload(response);
            }

            @Override
            public void onError(Throwable exception) {
                mView.hideLoading();
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
        mUseCaseHandler.dispose();
    }
}
