package ogmatech.com.techstile.api.service;

import java.util.List;

import io.reactivex.Single;
import ogmatech.com.techstile.api.StaticInfoApi;
import ogmatech.com.techstile.api.generic.ApiClient;
import ogmatech.com.techstile.model.Branch;
import ogmatech.com.techstile.model.CustomerType;
import ogmatech.com.techstile.model.DyeingColor;
import ogmatech.com.techstile.model.ExtraService;
import ogmatech.com.techstile.model.ItemCategory;
import ogmatech.com.techstile.model.ItemStatus;
import ogmatech.com.techstile.model.ItemType;
import ogmatech.com.techstile.model.ItemTypeServicePrice;
import ogmatech.com.techstile.model.OrderStatus;
import ogmatech.com.techstile.model.OrderType;
import ogmatech.com.techstile.model.PaymentType;
import ogmatech.com.techstile.model.Remark;
import ogmatech.com.techstile.model.Service;
import ogmatech.com.techstile.wrapper.UserInitializerWrapper;
import retrofit2.Call;

public class StaticInfoService {

    private static StaticInfoApi getApi () {
        return new ApiClient.Builder().build().create(StaticInfoApi.class);
    }

    public static Single<UserInitializerWrapper> getUserInitializerWrapper(){
        return getApi().getUserInitializerWrapper();
    }

}
