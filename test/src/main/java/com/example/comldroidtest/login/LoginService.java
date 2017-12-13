package com.example.comldroidtest.login;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface LoginService {

    @POST("dmcm.do?action=REPORTLOGIN")
    @FormUrlEncoded
    Observable<LoginUseCase.ResponseValue> login(@FieldMap Map<String, String> params);

}
