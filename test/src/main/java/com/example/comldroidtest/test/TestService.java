package com.example.comldroidtest.test;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;

import static com.example.comldroidtest.TestUrlFactory.MAIN_DOMAIN;
import static com.example.comldroidtest.TestUrlFactory.UrlKeys.SD;


public interface TestService {


    @Headers({MAIN_DOMAIN + ":" + SD})
    @FormUrlEncoded
    @POST("/v2/book/search")
    Observable<PostUseCase.ResponseValue> testPost(@FieldMap Map<String, String> params);

    @GET("/v2/book/search")
    Observable<GetUseCase.ResponseValue> testGet(@QueryMap Map<String, String> params);

    @Multipart
    @POST("sdmupload.do?action=UPLOAD")
    Observable<UploadUseCase.ResponseValue> testUpload(@PartMap Map<String, RequestBody> params);


}
