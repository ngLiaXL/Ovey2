package com.ldroid.kwei.module.login;

import com.ldroid.kwei.entities.out.LoginOutEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface LoginService {

    @GET("/users")
    Observable<LoginOutEntity> login(@Query("name") String name, @Query("password") String
            password);

}
