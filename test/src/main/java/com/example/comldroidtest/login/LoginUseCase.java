/**
 *
 */
package com.example.comldroidtest.login;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.retrofit.RetrofitCreator;

import io.reactivex.Observable;
import retrofit2.Retrofit;

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
            return true;
        }
    }

    public static final class ResponseValue extends ResponseValuesWrapper{

        @SerializedName("deptinfo")
        @Expose public DeptInfo deptInfo;

        public static final class DeptInfo{
            @Expose public String dcode ;
            @Expose public String dname ;
            @Expose public String label ;
        }
    }


    @Override
    protected Observable<ResponseValue> buildObservable() {
        // 找个合适的方法去生成service
        // .....
        RequestValues requestValues = getRequestValues();
        Retrofit retrofit = RetrofitCreator.INSTANCE.getInstance();
        LoginService service = retrofit.create(LoginService.class);
        return service.login(requestValues.getParams());
    }
}
