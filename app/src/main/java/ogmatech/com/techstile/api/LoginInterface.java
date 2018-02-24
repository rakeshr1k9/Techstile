package ogmatech.com.techstile.api;

import ogmatech.com.techstile.model.Token;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Rakesh on 24-02-2018.
 */

public interface LoginInterface {
    @POST("oauth/token")
    Call<Token> getToken(@Query("grant_type") String grantType, @Query("username") String username, @Query("password") String password);

    @GET("users")
    Call<Token> getUsers();
}
