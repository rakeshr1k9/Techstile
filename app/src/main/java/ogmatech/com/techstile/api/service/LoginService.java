package ogmatech.com.techstile.api.service;

import io.reactivex.Single;
import ogmatech.com.techstile.api.LoginApi;
import ogmatech.com.techstile.api.generic.ApiClient;
import ogmatech.com.techstile.model.Token;

public class LoginService{
    private static LoginApi getApi () {
        return new ApiClient.Builder()
                .setAddBearerToken(false)
                .setBaseUrl("http://192.168.1.44:8090/")
                .build()
                .create(LoginApi.class);
    }

    public static Single<Token> login (String grantType, String username, String password) {
        return getApi().getToken(grantType, username, password);
    }
}
