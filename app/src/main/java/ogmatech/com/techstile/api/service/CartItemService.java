package ogmatech.com.techstile.api.service;

import java.util.List;

import io.reactivex.Single;
import ogmatech.com.techstile.api.CartItemApi;
import ogmatech.com.techstile.api.generic.ApiClient;
import ogmatech.com.techstile.wrapper.CartItemWrapper;

public class CartItemService {

    private static CartItemApi getApi(){
        return new ApiClient.Builder().build().create(CartItemApi.class);
    }

    public static Single<List<CartItemWrapper>> getCartItem(){
        return getApi().getCartItem();
    }

    public static Single<CartItemWrapper> deleteCartItem(Integer idUserCartItem) {
        return getApi().deleteCartItem(idUserCartItem);
    }
}
