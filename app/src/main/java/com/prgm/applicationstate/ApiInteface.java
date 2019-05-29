package com.prgm.applicationstate;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface ApiInteface {

    @GET("orgs")
    Observable<List<RetrofitModel>> getResponse();


}
