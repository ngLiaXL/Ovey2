package com.example.comldroidtest.login;

import android.support.annotation.NonNull;

import com.example.comldroidtest.mvp.BasePresenter;
import com.example.comldroidtest.mvp.BaseView;


public interface LoginContract {

	interface View extends BaseView {
		void onRespLogin(LoginUseCase.ResponseValue response);
	}

	interface Presenter extends BasePresenter {
		void reqLogin(@NonNull String phone, @NonNull String pwd);
	}
}
