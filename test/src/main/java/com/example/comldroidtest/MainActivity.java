package com.example.comldroidtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.comldroidtest.login.LoginContract;
import com.example.comldroidtest.login.LoginPresenter;
import com.example.comldroidtest.login.LoginUseCase;

public class MainActivity extends AppCompatActivity implements LoginContract.View {


    private LoginPresenter mPresenter;

    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.progressbar);
        mPresenter = new LoginPresenter(this);
    }

    public void onClickLogin(View view) {
        mPresenter.reqLogin("xianglong.liang", "Abc12345687");


    }

    public void onClickCancel(View view) {
        mPresenter.destroy();
    }

    @Override
    public Context context() {
        return this;
    }

    @Override
    public void showLoading(String message) {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
    }

    @Override
    public void onRespLogin(LoginUseCase.ResponseValue response) {
        Toast.makeText(this, response.deptInfo.dname, Toast.LENGTH_LONG).show();
    }

}
