package ogmatech.com.techstile.api;

import io.reactivex.Single;
import ogmatech.com.techstile.wrapper.UserInitializerWrapper;
import retrofit2.http.GET;

public interface StaticInfoApi {

    @GET("user/initializer")
    Single<UserInitializerWrapper> getUserInitializerWrapper();

}
