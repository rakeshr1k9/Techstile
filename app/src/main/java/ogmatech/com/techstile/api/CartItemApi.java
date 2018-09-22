package ogmatech.com.techstile.api;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import ogmatech.com.techstile.wrapper.CartItemWrapper;
import ogmatech.com.techstile.wrapper.ItemTypeServiceWrapper;
import ogmatech.com.techstile.wrapper.ServiceSelectedWrapper;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CartItemApi {

    @GET("user/user-cart-item")
    Single<List<CartItemWrapper>> getCartItem();

    @GET("user/item-type-service/{id}")
    Single<List<ItemTypeServiceWrapper>> getItemTypeService(@Path("id") Integer idItemType);

    @GET("user/cart-item-type-service/{id}")
    Single<List<ServiceSelectedWrapper>> getCartItemTypeService(@Path("id") Integer idUserCartItem);

    @DELETE("user/user-cart-item-service/{id}")
    Completable deleteCartItem(@Path("id") Integer idUserCartItem);
}
