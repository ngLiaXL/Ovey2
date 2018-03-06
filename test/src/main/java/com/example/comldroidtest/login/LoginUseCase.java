/**
 *
 */
package com.example.comldroidtest.login;


import android.os.SystemClock;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.retrofit.ServiceGenerator;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

public class LoginUseCase extends UseCase<LoginUseCase.RequestValues, LoginUseCase.ResponseValue> {

    public static final class RequestValues extends RequestValuesWrapper {

        @Expose
        public String username;
        @Expose
        public String password;
        @Expose
        public String type;

        public RequestValues(String username, String password) {
            this.username = username;
            this.password = password;
            this.type = "LOGIN";
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

        @SerializedName("deptinfo")
        @Expose
        public DeptInfo deptInfo;

        public static final class DeptInfo {
            @Expose
            public String dname;
        }
    }


    @Override
    protected Observable<ResponseValue> buildObservable(RequestValues values) {
        // 找个合适的方法去生成 observable service
        // .....
        // 或者在这里生成任意一个 observable
        LoginService service = ServiceGenerator.getInstance().getService(LoginService.class);
        final Observable<LoginUseCase.ResponseValue> observer =  service.reqAuthUrl();
        return observer ;
    }
}
