package com.example.zomatoapp.webservices;

import com.example.zomatoapp.models.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Api {
    String BASE_URL="https://developers.zomato.com/api/v2.1/";

    @Headers("user-key: bdeb76eb19119d41ca49248b6d3baff2")
    @GET("locations?")
    Call<Example>getLocation(@Query("query")String query);

    @Headers("user-key: bdeb76eb19119d41ca49248b6d3baff2")
    @GET("search?")
    Call<com.example.zomatoapp.models.model2.Example>getDetail(@Query("lat")double lat,@Query("lon")double lon);
}
