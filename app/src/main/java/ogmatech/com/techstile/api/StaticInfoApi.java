package ogmatech.com.techstile.api;

import java.util.List;

import io.reactivex.Single;
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
import retrofit2.http.GET;

public interface StaticInfoApi {

    @GET("customerType")
    Single<List<CustomerType>> getCustomerType();

    @GET("dyeingColor")
    Single<List<DyeingColor>> getDyeingColor();

    @GET("extraService")
    Single<List<ExtraService>> getExtraService();

    @GET("itemCategory")
    Single<List<ItemCategory>> getItemCategory();

    @GET("itemStatus")
    Single<List<ItemStatus>> getItemStatus();

    @GET("itemType")
    Single<List<ItemType>> getItemType();

    @GET("itemTypeServicePrice")
    Single<List<ItemTypeServicePrice>> getItemTypeServicePrice();

    @GET("orderStatus")
    Single<List<OrderStatus>> getOrderStatus();

    @GET("orderType")
    Single<List<OrderType>> getOrderType();

    @GET("paymentType")
    Single<List<PaymentType>> getPaymentType();

    @GET("remark")
    Single<List<Remark>> getRemark();

    @GET("service")
    Single<List<Service>> getService();

}
