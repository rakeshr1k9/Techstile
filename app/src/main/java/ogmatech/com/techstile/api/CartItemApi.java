package ogmatech.com.techstile.api;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import ogmatech.com.techstile.model.Service;
import ogmatech.com.techstile.model.UserCartItem;
import ogmatech.com.techstile.wrapper.CartItemWrapper;
import ogmatech.com.techstile.wrapper.ItemTypeServiceWrapper;
import ogmatech.com.techstile.wrapper.ServiceSelectedWrapper;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CartItemApi {

    @GET("user/user-cart-item")
    Single<List<CartItemWrapper>> getCartItem();

    @GET("user/item-type-service/{id}")
    Single<List<ItemTypeServiceWrapper>> getItemTypeService(@Path("id") Integer idItemType);

    @GET("user/cart-item-type-service/{id}")
    Single<List<ServiceSelectedWrapper>> getCartItemTypeService(@Path("id") Integer idUserCartItem);

    @GET("admin/user-cart-item/{id}")
    Single<UserCartItem> getCartItemTypeCountService(@Path("id") Integer idUserCartItem);

    @POST("user/user-cart-item")
    Single<UserCartItem> getUserCartItem(@Body UserCartItem userCartItem);

    @POST("user/user-cart-item-service/{id}")
    Single<List<ServiceSelectedWrapper>> getServiceSelectedWrappers(@Path("id") Integer idUserCartItem, @Body List<ServiceSelectedWrapper> serviceSelectedWrappers);

    @PUT("user/user-cart-item/{id}")
    Single<UserCartItem> putUserCartItem(@Path("id") Integer idUserCartItem, @Body UserCartItem userCartItem);

    @DELETE("user/user-cart-item-service/{id}")
    Completable deleteCartItem(@Path("id") Integer idUserCartItem);
}
