package ogmatech.com.techstile;

import android.app.Application;

public class TechstileApplication extends Application {


    private static String bearerToken;

    public static String getBearerToken() {
        return bearerToken;
    }

    public static void setBearerToken(String bearerToken) {
        TechstileApplication.bearerToken = bearerToken;
    }
}
