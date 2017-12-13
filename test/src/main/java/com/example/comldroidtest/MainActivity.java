package com.example.comldroidtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.comldroidtest.login.LoginContract;
import com.example.comldroidtest.login.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginContract.View {


    LoginPresenter mPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new LoginPresenter(this);
    }

    public void onClickLogin(View view) {
        mPresenter.reqLogin("xianglong.liang","Abc12345687");


    }

    @Override
    public Context context() {
        return null;
    }

    @Override
    public void showLoading(String message) {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public void onRespLogin() {

    }
}
