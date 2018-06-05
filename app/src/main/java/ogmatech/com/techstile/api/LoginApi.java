package ogmatech.com.techstile.api;




import android.util.Base64;

import ogmatech.com.techstile.model.Token;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Pavan on 04-06-2018.
 */

public interface LoginApi {
    @Headers("Authorization: Basic dHJ1c3RlZC1jbGllbnQ6c2VjcmV0MTIz")
    @POST("oauth/token")
    Call<Token> getToken(@Query("grant_type") String grantType, @Query("username") String username, @Query("password") String password);

    @GET("users")
    Call<Token> getUsers();
}
