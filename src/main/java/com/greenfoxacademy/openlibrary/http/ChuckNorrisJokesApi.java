package com.greenfoxacademy.openlibrary.http;

import com.greenfoxacademy.openlibrary.model.ChuckNorrisJoke;
import com.greenfoxacademy.openlibrary.model.WorksBySubject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ChuckNorrisJokesApi {

  @GET("jokes/random")
  Call<ChuckNorrisJoke> getRandomJoke();
}
