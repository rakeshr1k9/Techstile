package ogmatech.com.techstile.api.service;

import java.util.List;

import io.reactivex.Single;
import ogmatech.com.techstile.api.StaticInfoApi;
import ogmatech.com.techstile.api.generic.ApiClient;
import ogmatech.com.techstile.model.ItemType;
import ogmatech.com.techstile.wrapper.UserInitializerWrapper;

public class StaticInfoService {

    private static StaticInfoApi getApi () {
        return new ApiClient.Builder().build().create(StaticInfoApi.class);
    }

    public static Single<UserInitializerWrapper> getUserInitializerWrapper(){
        return getApi().getUserInitializerWrapper();
    }

    public static Single<List<ItemType>> getItemType(Integer categoryId){
        return getApi().getItemType(categoryId);
    }

}
