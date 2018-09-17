package ogmatech.com.techstile.api;

import java.util.List;

import io.reactivex.Single;
import ogmatech.com.techstile.model.ItemType;
import ogmatech.com.techstile.wrapper.UserInitializerWrapper;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StaticInfoApi {

    @GET("user/initializer")
    Single<UserInitializerWrapper> getUserInitializerWrapper();

    @GET("admin/item-type/{id}")
    Single<List<ItemType>> getItemType(@Path("id") Integer categoryId);


}
