/**
 *
 */
package com.example.comldroidtest.login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.retrofit.ServiceGenerator;

import io.reactivex.Observable;

public class UploadUseCase extends UseCase<UploadUseCase.RequestValues, UploadUseCase.ResponseValue> {

    public static final class RequestValues extends RequestValuesWrapper {

        @Expose
        public String username;
        @Expose
        public String password;

        public RequestValues(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public boolean checkInput() {
            if (username == null) {
                errors.add("请输入用户名");
                return false;
            }
            return true;
        }
    }

    public static final class ResponseValue extends ResponseValuesWrapper {

        @SerializedName("username")
        @Expose
        public String username;

    }


    @Override
    protected Observable<ResponseValue> buildObservable(RequestValues values) {
        return null;
    }
}
