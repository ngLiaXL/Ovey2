package com.example.comldroidtest.login;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;



public interface LoginService {


    String MAIN_DOMAIN = "key";

    @Headers({MAIN_DOMAIN + ":" + "abc"})
    @POST("dmcm.do?action=REPORTLOGIN")
    @FormUrlEncoded
    Observable<LoginUseCase.ResponseValue> login(@FieldMap Map<String, String> params);
    @GET("misc/oa_desktop_url")
    Observable<LoginUseCase.ResponseValue> reqAuthUrl();
}
