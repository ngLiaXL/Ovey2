/**
 *
 */
package com.example.comldroidtest.login;


import android.os.Environment;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ldroid.kwei.UseCase;
import com.ldroid.kwei.retrofit.ServiceGenerator;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class UploadUseCase extends UseCase<UploadUseCase.RequestValues, UploadUseCase.ResponseValue> {

    public static final class RequestValues extends RequestValuesWrapper {

        @Override
        boolean checkInput() {
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
        LoginService service = ServiceGenerator.getInstance().getService(LoginService.class);

        File file = new File(Environment.getExternalStorageDirectory(), "icon.png");
        RequestBody photo = RequestBody.create(MediaType.parse("image/png"), file);

        HashMap<String, Object> params = new HashMap<>();
        params.put("udid", "0000000000000000");
        params.put("username", "cs.ansmsmahaibin");
        params.put("addressno", "123123");
        params.put("summary", "summary");


        Map<String, RequestBody> photos = new HashMap<>();
        photos.put("shoppng[0]\"; filename=\"icon.png", photo);
        photos.put("data", RequestBody.create(null, new Gson().toJson(params)));


        return service.upload(photos);
    }
}
