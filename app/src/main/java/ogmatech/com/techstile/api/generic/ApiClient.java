package ogmatech.com.techstile.api.generic;

import java.util.concurrent.TimeUnit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import ogmatech.com.techstile.TechstileApplication;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static OkHttpClient initOkHttp(boolean addBearerToken) {
        int REQUEST_TIMEOUT = 60;
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(interceptor);

        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();
                   // .addHeader("Accept", "application/json")
                   // .addHeader("Content-Type", "application/json");

            /*if(addBearerToken) {
                requestBuilder.addHeader("Authorization", TechstileApplication.getBearerToken());
            }*/

            Request request = requestBuilder.build();
            return chain.proceed(request);
        });

        return httpClient.build();
    }

    public static class Builder {
        private boolean addBearerToken = true;
        private String baseUrl = "http://192.168.1.144:8091/api/";

        public Builder setAddBearerToken(boolean addBearerToken) {
            this.addBearerToken = addBearerToken;
            return this;
        }

        public Builder setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Retrofit build() {
            return new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(initOkHttp(addBearerToken))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
    }
}
