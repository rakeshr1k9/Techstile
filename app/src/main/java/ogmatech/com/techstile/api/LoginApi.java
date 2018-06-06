package ogmatech.com.techstile.api;

import io.reactivex.Single;
import ogmatech.com.techstile.model.Token;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginApi {
    @Headers("Authorization: Basic dHJ1c3RlZC1jbGllbnQ6c2VjcmV0MTIz")
    @POST("oauth/token")
    Single<Token> getToken(@Query("grant_type") String grantType, @Query("username") String username, @Query("password") String password);
}
