/**
 *
 */
package com.example.comldroidtest.test;

import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.UseCaseHandler;

public class TestPresenter implements TestContract.Presenter {

    private TestContract.View mView;
    private UseCaseHandler mUseCaseHandler;


    public TestPresenter(TestContract.View view) {
        this.mView = view;
        mUseCaseHandler = new UseCaseHandler();
    }


    public void reqTestGet(String q, int start, int count) {
        GetUseCase.RequestValues requestValue = new GetUseCase.RequestValues(q, start, count);
        if (!requestValue.checkInput()) {
            mView.onError("....");
            return;
        }
        mView.showLoading("请求网络...");
        mUseCaseHandler.execute(new GetUseCase(), requestValue, new UseCase.UseCaseCallback<GetUseCase
                .ResponseValue>() {
            @Override
            public void onSuccess(GetUseCase.ResponseValue response) {
                mView.hideLoading();
                // ...
                mView.onRespGetTest(response);
            }

            @Override
            public void onError(Throwable exception) {
                mView.hideLoading();
                // ...
                mView.onError(exception.toString());
            }
        });
    }


    public void reqTestPost(String q, int start, int count) {
        PostUseCase.RequestValues requestValue = new PostUseCase.RequestValues(q, start, count);
        if (!requestValue.checkInput()) {
            mView.onError("....");
            return;
        }
        mView.showLoading("请求网络...");
        mUseCaseHandler.execute(new PostUseCase(), requestValue, new PostUseCase.UseCaseCallback<PostUseCase
                .ResponseValue>() {
            @Override
            public void onSuccess(PostUseCase.ResponseValue response) {
                mView.hideLoading();
                // ...
                mView.onRespTestPost(response);
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
