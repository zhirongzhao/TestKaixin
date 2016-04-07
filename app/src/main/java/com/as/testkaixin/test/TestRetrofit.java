package com.as.testkaixin.test;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by samsung on 2015/12/11.
 */
public class TestRetrofit {

    public static final String API_URL = "https://api.github.com";

    public static class Contributor {
        public final String login;
        public final int contributions;

        public Contributor(int contributions, String login) {
            this.contributions = contributions;
            this.login = login;
        }
    }

    public interface GitHub {
        @GET("/repos/{owner}/{repo}/contributors")
        Call<List<Contributor>> contributors(@Path("owner") String owner, @Path("repo") String repo);
    }

    public static void main(String... args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        GitHub gitHub = retrofit.create(GitHub.class);
        Call<List<Contributor>> call = gitHub.contributors("square", "retrofit");
        List<Contributor> contributors = call.execute().body();
        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }
    }


}


