package com.prgm.applicationstate;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class APiClient {

    public static final String BASE_URL = "https://api.github.com/users/hadley/";
    static Retrofit retrofit = null;
    static ApiInteface aPiClient;
    static APiClient context;

    private APiClient(){

        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

     retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();

        aPiClient = retrofit.create(ApiInteface.class);
}

        public static APiClient getContext(){

        if (context == null){

            context = new APiClient();

        }

        return context;
        }

        public Observable<List<RetrofitModel>> getApiClientResponse(){

        return aPiClient.getResponse();
        }

}
