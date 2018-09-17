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

    public static Single<List<CustomerType>> getCustomerType () {
        return getApi().getCustomerType();
    }

    public static Single<List<DyeingColor>> getDyeingColor() {
        return getApi().getDyeingColor();
    }

    public static Single<List<ExtraService>> getExtraService() {
        return getApi().getExtraService();
    }

    public static Single<List<ItemCategory>> getItemCategory() {
        return getApi().getItemCategory();
    }

    public static Single<List<ItemStatus>> getItemStatus() {
        return getApi().getItemStatus();
    }

    public static Single<List<ItemType>> getItemType() {
        return getApi().getItemType();
    }

    public static Single<List<ItemTypeServicePrice>> getItemTypeServicePrice() {
        return getApi().getItemTypeServicePrice();
    }

    public static Single<List<OrderStatus>> getOrderStatus() {
        return getApi().getOrderStatus();
    }

    public static Single<List<OrderType>> getOrderType() {
        return getApi().getOrderType();
    }

    public static Single<List<PaymentType>> getPaymentType() {
        return getApi().getPaymentType();
    }

    public static Single<List<Remark>> getRemark() {
        return getApi().getRemark();
    }

    public static Single<List<Service>> getService() {
        return getApi().getService();
    }

    public static Single<Branch> getBranch(){
        Integer branchId = 1;
        return getApi().getBranch(branchId);
    }

}
