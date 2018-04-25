package com.greenfoxacademy.openlibrary;

import com.greenfoxacademy.openlibrary.http.ChuckNorrisJokesApi;
import com.greenfoxacademy.openlibrary.http.OpenLibraryApi;
import com.greenfoxacademy.openlibrary.http.RetrofitClient;
import com.greenfoxacademy.openlibrary.model.ChuckNorrisJoke;
import com.greenfoxacademy.openlibrary.model.WorksBySubject;
import okhttp3.ResponseBody;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

@SpringBootApplication
public class OpenlibraryApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(OpenlibraryApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    openLibraryTestMethod();
    chuckNorrisJokeTestMethod();
  }

  private void chuckNorrisJokeTestMethod() {
    ChuckNorrisJokesApi api = RetrofitClient.getChuckNorrisJokesApi();
    api.getRandomJoke().enqueue(new Callback<ChuckNorrisJoke>() {
      @Override
      public void onResponse(Call<ChuckNorrisJoke> call, Response<ChuckNorrisJoke> response) {
        ChuckNorrisJoke joke = response.body();
        System.out.println(joke.getValue());
      }

      @Override
      public void onFailure(Call<ChuckNorrisJoke> call, Throwable t) {

      }
    });
  }

  private void openLibraryTestMethod() {
    OpenLibraryApi openLibraryApi = RetrofitClient.getOpenLibraryApi();

    Call<WorksBySubject> hungarianWorksCall = openLibraryApi.getWorksBySubject("hungarian");

    hungarianWorksCall.enqueue(new Callback<WorksBySubject>() {
      @Override
      public void onResponse(Call<WorksBySubject> call, Response<WorksBySubject> response) {
        WorksBySubject worksBySubject = response.body();
        System.out.println();
      }

      @Override
      public void onFailure(Call<WorksBySubject> call, Throwable t) {
        t.printStackTrace();
      }
    });
  }
}
