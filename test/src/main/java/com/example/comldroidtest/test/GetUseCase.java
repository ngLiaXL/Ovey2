/**
 *
 */
package com.example.comldroidtest.test;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.retrofit.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public class GetUseCase extends UseCase<GetUseCase.RequestValues, GetUseCase.ResponseValue> {

    public static final class RequestValues extends RequestValuesWrapper {

        @Expose
        public String q;
        @Expose
        public int start;
        @Expose
        public int count;


        public RequestValues(String q, int start, int count) {
            this.q = q;
            this.start = start;
            this.count = count;
        }

        public Map<String, String> getParams() {
            Map<String, String> params = new HashMap<>();
            params.put("q", q);
            params.put("start", String.valueOf(start));
            params.put("count", String.valueOf(count));
            return params;
        }


        @Override
        public boolean checkInput() {
            return true;
        }
    }

    public static final class ResponseValue extends ResponseValuesWrapper {

        @SerializedName("count")
        @Expose
        public int count;

    }


    @Override
    protected Observable<ResponseValue> buildObservable(RequestValues values) {
        TestService service = ServiceGenerator.getInstance().getService(TestService.class);
        return service.testGet(values.getParams());
    }
}
