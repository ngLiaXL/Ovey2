/**
 *
 */
package com.example.comldroidtest.test;


import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.retrofit.ServiceGenerator;

import io.reactivex.Observable;

public class HttpsUseCase extends UseCase<HttpsUseCase.RequestValues, HttpsUseCase.ResponseValue> {

    public static final class RequestValues extends RequestValuesWrapper {
        @Override
        public boolean checkInput() {
            return true;
        }
    }

    public static final class ResponseValue extends ResponseValuesWrapper {

    }

    @Override
    protected Observable<ResponseValue> buildObservable(RequestValues values) {
        TestService service = ServiceGenerator.getInstance().getService(TestService.class);
        return service.testHttps();
    }
}
