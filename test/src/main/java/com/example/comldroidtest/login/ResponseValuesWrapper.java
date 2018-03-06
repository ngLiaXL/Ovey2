package com.example.comldroidtest.login;

import com.google.gson.annotations.Expose;
import com.ldroid.kwei.UseCase;

/**
 * Created by xianglong.liang on 2017/12/13.
 */
public class ResponseValuesWrapper implements UseCase.ResponseValue {

    @Expose public String status ;
    @Expose public String message ;
}
