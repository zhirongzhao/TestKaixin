package com.as.testkaixin.util;

import com.as.testkaixin.vo.bs.LoginVO;
import com.squareup.okhttp.ResponseBody;

import java.util.Map;

import retrofit.Response;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by samsung on 2015/12/11.
 */
public interface HttpClientHelper {
    @FormUrlEncoded
    @POST("/oauth/access_token")
    Observable<Response<ResponseBody>> contributors (@FieldMap Map<String,String> maps);

    @FormUrlEncoded
    @POST("/oauth/access_token")
    Observable<LoginVO> login (@FieldMap Map<String,String> maps);


}
