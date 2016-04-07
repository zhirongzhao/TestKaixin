package com.as.testkaixin.test;

import com.squareup.okhttp.ResponseBody;

import java.io.IOException;

import retrofit.Response;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.GET;
import rx.Observable;

/**
 * Created by samsung on 2015/12/30.
 */
public class TestFanli {

    public static final String API_URL = "http://fun.fanli.com";

    public static class Contributor {
        public final String login;
        public final int contributions;

        public Contributor(int contributions, String login) {
            this.contributions = contributions;
            this.login = login;
        }
    }

    public interface GitHub{
        @GET("/Landingapp/mobile_step2?tel=13911431684&cd=eyJtYyI6MTksImNoYW5uZWwiOiJBbmRyb2lkOjE5IiwiaXAiOiI2MC4yNDcuMTIyLjEwIiwiZGV2aWQiOjY5NzA4Mjg0MTY0MTI4LCJjX3NyYyI6IjIiLCJjX3YiOiI0LjcuMC40MSJ9&go_url=http%3A%2F%2Fm.fanli.com%2Fsuper&devid=69708284164128")
        Observable<Response<ResponseBody>> contributors ();
    }

    public static void main(String... args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        GitHub gitHub = retrofit.create(GitHub.class);
        Observable<Response<ResponseBody>>  observable = gitHub.contributors();
        observable.filter(responseBodyResponse -> responseBodyResponse.isSuccess()).subscribe((Response<ResponseBody> stringResponse) -> {

            try {
                System.out.println(stringResponse.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }

}
