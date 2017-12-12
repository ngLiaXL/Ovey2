package com.example.comldroidtest.login;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface LoginService {

    @GET("/users")
    Observable<LoginUseCase.ResponseValue> login(@Query("name") String name, @Query("password") String
            password);

}
