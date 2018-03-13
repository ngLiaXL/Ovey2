package com.example.comldroidtest.test;

import com.example.comldroidtest.mvp.BasePresenter;
import com.example.comldroidtest.mvp.BaseView;


public interface TestContract {

	interface View extends BaseView {
		void onRespGetTest(GetUseCase.ResponseValue response);

        void onRespUpload(UploadUseCase.ResponseValue response);

		void onRespTestPost(PostUseCase.ResponseValue response);

        void onRespHttps(HttpsUseCase.ResponseValue response);
    }

	interface Presenter extends BasePresenter {
	}
}
