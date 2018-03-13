package com.example.comldroidtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.comldroidtest.test.HttpsUseCase;
import com.example.comldroidtest.test.PostUseCase;
import com.example.comldroidtest.test.TestContract;
import com.example.comldroidtest.test.TestPresenter;
import com.example.comldroidtest.test.GetUseCase;
import com.example.comldroidtest.test.UploadUseCase;
import com.ldroid.kwei.retrofit.OkHttpClientProvider;
import com.ldroid.kwei.retrofit.BaseUrlProvider;

public class MainActivity extends AppCompatActivity implements TestContract.View {


    private TestPresenter mPresenter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = findViewById(R.id.progressbar);
        mPresenter = new TestPresenter(this);

        BaseUrlProvider.setUrlFactory(new TestUrlFactory());
        OkHttpClientProvider.setOkHttpClientFactory(new DefaultOkHttpClientFactory());

    }

    public void onClickTestGet(View view) {
        mPresenter.reqTestGet("小王子", 0, 3);
    }

    public void onClickTestPost(View view) {
        mPresenter.reqTestPost("小王子", 0, 3);
    }

    public void onClickHttps(View view) {
        mPresenter.testHttps();
    }

    public void onClickUpload(View view) {
        mPresenter.reqUpload();
    }

    public void onClickDownload(View view) {
    }

    public void onClickCancel(View view) {
        hideLoading();
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
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRespGetTest(GetUseCase.ResponseValue response) {
        Toast.makeText(this, String.valueOf(response.count), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRespUpload(UploadUseCase.ResponseValue response) {
        Toast.makeText(this, response.username, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRespTestPost(PostUseCase.ResponseValue response) {
        Toast.makeText(this, String.valueOf(response.count), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRespHttps(HttpsUseCase.ResponseValue response) {
        Toast.makeText(this, "====", Toast.LENGTH_LONG).show();
    }

}
