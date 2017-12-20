package com.example.comldroidtest.login;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

import static com.ldroid.kwei.retrofit.UrlManager.DOMAIN_NAME_HEADER;


public interface LoginService {


    String MAIN_DOMAIN = "ABC";

    @Headers({DOMAIN_NAME_HEADER + MAIN_DOMAIN})
    @POST("dmcm.do?action=REPORTLOGIN")
    @FormUrlEncoded
    Observable<LoginUseCase.ResponseValue> login(@FieldMap Map<String, String> params);

}
