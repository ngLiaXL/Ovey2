package com.example.comldroidtest.login;

import com.google.gson.GsonBuilder;
import com.ldroid.kwei.UseCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xianglong.liang on 2017/12/13.
 */
public abstract class RequestValuesWrapper implements UseCase.RequestValues {


    public List<String> errors = new ArrayList<>();


    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("data", toJson());
        return params;
    }

    public String toJson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);
    }

    abstract boolean checkInput();
}
