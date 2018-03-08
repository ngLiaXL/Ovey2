package com.example.comldroidtest.test;

import com.google.gson.GsonBuilder;
import com.ldroid.kwei.UseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class RequestValuesWrapper implements UseCase.RequestValues {


    public List<String> errors = new ArrayList<>();


    public Map<String, String> getParams() {
        return  null ;
    }

    public String toJson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().toJson(this);
    }

    abstract boolean checkInput();
}
