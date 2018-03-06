package com.ldroid.kwei.retrofit;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;

public abstract class BaseUrlFactory extends HashMap<String, String> {

    @Nullable
    public abstract String getUrlHeaderName();

    @NonNull
    public abstract String getBaseUrl();
}
