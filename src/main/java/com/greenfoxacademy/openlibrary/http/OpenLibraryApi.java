package com.greenfoxacademy.openlibrary.http;

import com.greenfoxacademy.openlibrary.model.WorksBySubject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface OpenLibraryApi {

  @Headers({"Content-Type: application/json", "Accept: application/json"})
  @GET("subjects/{subject}")
  Call<WorksBySubject> getWorksBySubject(@Path("subject") String subject);

}
