package com.as.testkaixin.test;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by samsung on 2015/12/15.
 */
public class TestRetrofitPlanTxt {

    public static final String API_URL = "http://api.kaixin001.com";

    public static class Contributor {
        public final String login;
        public final int contributions;

        public Contributor(int contributions, String login) {
            this.contributions = contributions;
            this.login = login;
        }
    }

    public interface GitHub{

        @FormUrlEncoded
        @POST("/oauth/access_token")
        Observable<Response<ResponseBody>>  contributors (@FieldMap Map<String,String> maps);
    }

    public static void main(String... args) throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
       GitHub service = retrofit.create(GitHub.class);
        Map<String,String> param = new HashMap<String,String>();
       param.put("getsimi","1");
       param.put("oauth_signature",	"amKXSOzlFp98jVzCEj34C2brZF4=");
       param.put("device_name",	"unknown$!AndroidSDKbuiltforx86");
       param.put("x_auth_username",	"zhirong.zhao@samsung.com");
       param.put("x_auth_mode",	"client_auth");
       param.put("oauth_version",	"1.0");
       param.put("oauth_nonce",	"d6b9990d99b3777aaea541ae36380ad1");
       param.put("oauth_signature_method",	"HMAC-SHA1");
       param.put("oauth_consumer_key",	"87247717949570179fa41c43e20ed289");
       param.put("ctype",	"15803AndroidClient");
       param.put("x_auth_password",	"qwer1324!");
       param.put("oauth_timestamp", "1450139034");
        Observable<Response<ResponseBody>>     observable = service.contributors(param ) ;
        observable.filter(responseBodyResponse -> responseBodyResponse.isSuccess()).subscribe((Response<ResponseBody> stringResponse) -> {

            try {
                System.out.println(stringResponse.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

}
