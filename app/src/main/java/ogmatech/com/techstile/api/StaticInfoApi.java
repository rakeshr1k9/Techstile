package ogmatech.com.techstile.api;

import java.util.List;

import io.reactivex.Single;
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
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StaticInfoApi {

    @GET("user/initializer")
    Single<UserInitializerWrapper> getUserInitializerWrapper();

}
