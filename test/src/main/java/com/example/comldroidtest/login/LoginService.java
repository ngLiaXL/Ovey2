package com.example.comldroidtest.login;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.example.comldroidtest.TestUrlFactory.MAIN_DOMAIN;
import static com.example.comldroidtest.TestUrlFactory.UrlKeys.SD;


public interface LoginService {


    @Headers({MAIN_DOMAIN + ":" + SD})
    @POST("sdm.do?action=LOGIN")
    @FormUrlEncoded
    Observable<LoginUseCase.ResponseValue> login(@FieldMap Map<String, String> params);



}
