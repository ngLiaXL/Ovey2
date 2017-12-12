/**
 *
 */
package com.example.comldroidtest.login;


import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.retrofit.RetrofitCreator;

import io.reactivex.Observable;
import retrofit2.Retrofit;

public class LoginUseCase extends UseCase<LoginUseCase.RequestValues, LoginUseCase.ResponseValue> {

    public static final class RequestValues implements UseCase.RequestValues {
        private String name;
        private String password;

        public RequestValues(String name, String password) {
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }
        public String getPassword() {
            return password;
        }

        @Override
        public boolean checkInput() {
            return true;
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue {

    }


    @Override
    protected Observable<ResponseValue> buildObservable() {
        // 找个合适的方法去生成service
        // .....
        RequestValues requestValues = getRequestValues();
        Retrofit retrofit = RetrofitCreator.INSTANCE.getInstance();
        LoginService service = retrofit.create(LoginService.class);
        return service.login(requestValues.getName(), requestValues.getPassword());
    }
}
