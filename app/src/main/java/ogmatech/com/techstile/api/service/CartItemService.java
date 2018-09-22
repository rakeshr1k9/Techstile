package ogmatech.com.techstile.api.service;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import ogmatech.com.techstile.api.CartItemApi;
import ogmatech.com.techstile.api.generic.ApiClient;
import ogmatech.com.techstile.model.Service;
import ogmatech.com.techstile.model.UserCartItem;
import ogmatech.com.techstile.wrapper.CartItemWrapper;
import ogmatech.com.techstile.wrapper.ItemTypeServiceWrapper;
import ogmatech.com.techstile.wrapper.ServiceSelectedWrapper;

public class CartItemService {

    private static CartItemApi getApi(){
        return new ApiClient.Builder().build().create(CartItemApi.class);
    }

    public static Single<List<CartItemWrapper>> getCartItem(){
        return getApi().getCartItem();
    }

    public static Single<List<ItemTypeServiceWrapper>> getItemTypeService(Integer idItemType){
        return getApi().getItemTypeService(idItemType);
    }

    public static Single<List<ServiceSelectedWrapper>> getCartItemTypeService(Integer idUserCartItem){
        return getApi().getCartItemTypeService(idUserCartItem);
    }

    public static Single<UserCartItem> getCartItemTypeCountService(Integer idUserCartItem){
        return getApi().getCartItemTypeCountService(idUserCartItem);
    }

    public static Single<UserCartItem> getUserCartItem(UserCartItem userCartItem){
        return getApi().getUserCartItem(userCartItem);
    }

    public static Single<List<ServiceSelectedWrapper>> getServiceSelectedWrappers(Integer idUserCartItem, List<ServiceSelectedWrapper> serviceSelectedWrappers){
        return getApi().getServiceSelectedWrappers(idUserCartItem, serviceSelectedWrappers);
    }

    public static Single<UserCartItem> putUserCartItem(Integer idUserCartItem, UserCartItem userCartItem){
        return getApi().putUserCartItem(idUserCartItem, userCartItem);
    }

    public static Completable deleteCartItem(Integer idUserCartItem) {
        return getApi().deleteCartItem(idUserCartItem);
    }
}
