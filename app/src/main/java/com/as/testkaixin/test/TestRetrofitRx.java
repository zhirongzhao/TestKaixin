package com.as.testkaixin.test;


import java.io.IOException;
import java.util.List;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;
import rx.functions.Action1;

/**
 * Created by samsung on 2015/12/14.
 */
public class TestRetrofitRx {
    public static final String API_URL = "https://api.github.com";

    public static class Contributor {
        public final String login;
        public final int contributions;

        public Contributor(int contributions, String login) {
            this.contributions = contributions;
            this.login = login;
        }
    }

    public interface GitHub{
        @GET("/repos/{owner}/{repo}/contributors")
        Observable<List<Contributor>> contributors (@Path("owner") String owner, @Path("repo") String repo);
    }

    public static void main(String... args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        GitHub gitHub = retrofit.create(GitHub.class);
        Observable<List<Contributor>> observable = gitHub.contributors("square", "retrofit");
        observable.subscribe(new Action1<List<Contributor>>() {
            @Override
            public void call(List<Contributor> contributors) {
                for (Contributor contributor : contributors) {
                    System.out.println(contributor.login + " (" + contributor.contributions + ")");
                }
            }
        });
        System.out.println("================4lambda======================================");
        observable.subscribe((List<Contributor> contributors) -> {
            for (Contributor contributor : contributors) {
                System.out.println(contributor.login + " (" + contributor.contributions + ")");
            }
        });
        System.out.println("================4lambda from======================================");
        observable.subscribe(contributors -> {
            Observable.from(contributors)
                    .subscribe(contributor -> System.out.println(contributor.login + " (" + contributor.contributions + ")"));
        });
        System.out.println("================4lambda flat Map======================================");
        observable.flatMap(contributors -> Observable.from(contributors))
                 .subscribe(contributor -> System.out.println(contributor.login + " (" + contributor.contributions + ")"));
        System.out.println("================4lambda filter======================================");
        observable.flatMap(contributors -> Observable.from(contributors))
                 .filter(contributor -> contributor != null)
                 .subscribe(contributor -> System.out.println(contributor.login + " (" + contributor.contributions + ")"));
        System.out.println("================4lambda get======================================");
        observable.flatMap(contributors -> Observable.from(contributors))
                  .take(5)
                  .subscribe(contributor -> System.out.println(contributor.login + " (" + contributor.contributions + ")"));
        System.out.println("================4lambda doOnNext======================================");
        observable.flatMap(contributors -> Observable.from(contributors))
                .doOnNext(contributor -> System.out.println("do someThing...."+contributor.getClass().toString()) )
                .subscribe(contributor ->System.out.println(contributor.login + " (" + contributor.contributions + ")"));
    }
}
