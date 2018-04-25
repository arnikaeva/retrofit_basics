package com.greenfoxacademy.openlibrary.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitClient {

  static final String OPEN_LIBRARY_URL = "https://openlibrary.org/";
  static final String CHUCK_NORRIS_URL = "https://api.chucknorris.io/";

  public static Retrofit getConnection(String connectionUrl) {

    Gson gson = new GsonBuilder()
        .setLenient()
        .create();

    return new Retrofit.Builder()
        .baseUrl(connectionUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(new OkHttpClient.Builder().readTimeout(120, TimeUnit.SECONDS).connectTimeout(120, TimeUnit.SECONDS).build())
        .build();
  }

  public static OpenLibraryApi getOpenLibraryApi() {
    return getConnection(OPEN_LIBRARY_URL).create(OpenLibraryApi.class);
  }

  public static ChuckNorrisJokesApi getChuckNorrisJokesApi() {
    return getConnection(CHUCK_NORRIS_URL).create(ChuckNorrisJokesApi.class);
  }
}
