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
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StaticInfoApi {

    @GET("user/initializer")
    Single<UserInitializerWrapper> getUserInitializerWrapper();

    @GET("admin/item-type/{id}")
    Single<List<ItemType>> getItemType(@Path("id") Integer categoryId);

    @GET("admin/customer-type")
    Single<List<CustomerType>> getCustomerType();

    @GET("admin/dyeing-color")
    Single<List<DyeingColor>> getDyeingColor();

    @GET("admin/extra-service")
    Single<List<ExtraService>> getExtraService();

    @GET("admin/item-category")
    Single<List<ItemCategory>> getItemCategory();

    @GET("admin/item-status")
    Single<List<ItemStatus>> getItemStatus();

    @GET("admin/item-type")
    Single<List<ItemType>> getItemType();

    @GET("admin/item-type-service-price")
    Single<List<ItemTypeServicePrice>> getItemTypeServicePrice();

    @GET("admin/order-status")
    Single<List<OrderStatus>> getOrderStatus();

    @GET("admin/order-type")
    Single<List<OrderType>> getOrderType();

    @GET("admin/payment-type")
    Single<List<PaymentType>> getPaymentType();

    @GET("admin/remark")
    Single<List<Remark>> getRemark();

    @GET("admin/service")
    Single<List<Service>> getService();

    @GET("admin/branch/{id}")
    Single<Branch> getBranch(@Path("id") Integer id);


}
