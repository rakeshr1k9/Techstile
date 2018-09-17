package ogmatech.com.techstile.controller;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import ogmatech.com.techstile.api.service.StaticInfoService;
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

public class StaticInfoController {

    private static StaticInfoController staticInfoController;
    private List<CustomerType> customerTypes = new ArrayList<>();
    private List<DyeingColor> dyeingColors = new ArrayList<>();
    private List<ExtraService> extraServices = new ArrayList<>();
    private List<ItemCategory> itemCategories = new ArrayList<>();
    private List<ItemStatus> itemStatuses = new ArrayList<>();
    private List<ItemType> itemTypes = new ArrayList<>();
    private List<ItemTypeServicePrice> itemTypeServicePrices = new ArrayList<>();
    private List<OrderStatus> orderStatuses = new ArrayList<>();
    private List<OrderType> orderTypes = new ArrayList<>();
    private List<PaymentType>paymentTypes  = new ArrayList<>();
    private List<Remark> remarks = new ArrayList<>();
    private List<Service> services = new ArrayList<>();
    private Branch branch = new Branch();

    public static StaticInfoController getInstance() {
        if (staticInfoController == null) {
            staticInfoController = new StaticInfoController();
        }
        return staticInfoController;
    }

    public static StaticInfoController getStaticInfoController() {
        return staticInfoController;
    }

    public static void setStaticInfoController(StaticInfoController staticInfoController) {
        StaticInfoController.staticInfoController = staticInfoController;
    }

    public List<CustomerType> getCustomerTypes() {
        return customerTypes;
    }

    public void setCustomerTypes(List<CustomerType> customerTypes) {
        this.customerTypes = customerTypes;
    }

    public List<DyeingColor> getDyeingColors() {
        return dyeingColors;
    }

    public void setDyeingColors(List<DyeingColor> dyeingColors) {
        this.dyeingColors = dyeingColors;
    }

    public List<ExtraService> getExtraServices() {
        return extraServices;
    }

    public void setExtraServices(List<ExtraService> extraServices) {
        this.extraServices = extraServices;
    }

    public List<ItemCategory> getItemCategories() {
        return itemCategories;
    }

    public void setItemCategories(List<ItemCategory> itemCategories) {
        this.itemCategories = itemCategories;
    }

    public List<ItemStatus> getItemStatuses() {
        return itemStatuses;
    }

    public void setItemStatuses(List<ItemStatus> itemStatuses) {
        this.itemStatuses = itemStatuses;
    }

    public List<ItemType> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(List<ItemType> itemTypes) {
        this.itemTypes = itemTypes;
    }

    public List<ItemTypeServicePrice> getItemTypeServicePrices() {
        return itemTypeServicePrices;
    }

    public void setItemTypeServicePrices(List<ItemTypeServicePrice> itemTypeServicePrices) {
        this.itemTypeServicePrices = itemTypeServicePrices;
    }

    public List<OrderStatus> getOrderStatuses() {
        return orderStatuses;
    }

    public void setOrderStatuses(List<OrderStatus> orderStatuses) {
        this.orderStatuses = orderStatuses;
    }

    public List<OrderType> getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(List<OrderType> orderTypes) {
        this.orderTypes = orderTypes;
    }

    public List<PaymentType> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(List<PaymentType> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public List<Remark> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Remark> remarks) {
        this.remarks = remarks;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void clearInstance() {
        staticInfoController = null;
    }

    public void loadStaticInfo(){
        StaticInfoService.getCustomerType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setCustomerTypes(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getDyeingColor()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setDyeingColors(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getExtraService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setExtraServices(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getItemCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setItemCategories(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getItemCategory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setItemCategories(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getItemStatus()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setItemStatuses(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getItemType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setItemTypes(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getItemTypeServicePrice()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setItemTypeServicePrices(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getOrderStatus()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setOrderStatuses(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getOrderType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setOrderTypes(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getPaymentType()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setPaymentTypes(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getRemark()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setRemarks(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setServices(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

        StaticInfoService.getBranch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {staticInfoController.setBranch(t);
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));
    }

    /*private static StaticInfoController staticInfoController;

    private Map<Integer, CustomerType> customerTypeHashMap = new HashMap<>();
    private Map<Integer, DyeingColor> dyeingColorHashMap = new HashMap<>();
    private Map<Integer, ExtraService> extraServiceHashMap = new HashMap<>();
    private Map<Integer, ItemCategory> itemCategoryHashMap = new HashMap<>();
    private Map<Integer, ItemStatus> itemStatusHashMap = new HashMap<>();
    private Map<Integer, ItemType> itemTypeHashMap = new HashMap<>();
    private Map<Integer, ItemTypeServicePrice> itemTypeServicePriceHashMap = new HashMap<>();
    private Map<Integer, OrderStatus> orderStatusHashMap = new HashMap<>();
    private Map<Integer, OrderType> orderTypeHashMap = new HashMap<>();
    private Map<Integer, PaymentType> paymentTypeHashMap = new HashMap<>();
    private Map<Integer, Remark> remarkHashMap = new HashMap<>();
    private Map<Integer, Service> serviceHashMap = new HashMap<>();
    private Branch branch = new Branch();

    public static StaticInfoController getInstance() {
        if (staticInfoController == null) {
            staticInfoController = new StaticInfoController();
        }
        return staticInfoController;
    }

    public static StaticInfoController getStaticInfoController() {
        return staticInfoController;
    }

    public static void setStaticInfoController(StaticInfoController staticInfoController) {
        StaticInfoController.staticInfoController = staticInfoController;
    }

    public void clearInstance() {
        staticInfoController = null;
    }


    public Map<Integer, CustomerType> getCustomerTypeHashMap() {
        return customerTypeHashMap;
    }

    public void setCustomerTypeHashMap(Map<Integer, CustomerType> customerTypeHashMap) {
        this.customerTypeHashMap = customerTypeHashMap;
    }

    public Map<Integer, DyeingColor> getDyeingColorHashMap() {
        return dyeingColorHashMap;
    }

    public void setDyeingColorHashMap(Map<Integer, DyeingColor> dyeingColorHashMap) {
        this.dyeingColorHashMap = dyeingColorHashMap;
    }

    public Map<Integer, ExtraService> getExtraServiceHashMap() {
        return extraServiceHashMap;
    }

    public void setExtraServiceHashMap(Map<Integer, ExtraService> extraServiceHashMap) {
        this.extraServiceHashMap = extraServiceHashMap;
    }

    public Map<Integer, ItemCategory> getItemCategoryHashMap() {
        return itemCategoryHashMap;
    }

    public void setItemCategoryHashMap(Map<Integer, ItemCategory> itemCategoryHashMap) {
        this.itemCategoryHashMap = itemCategoryHashMap;
    }

    public Map<Integer, ItemStatus> getItemStatusHashMap() {
        return itemStatusHashMap;
    }

    public void setItemStatusHashMap(Map<Integer, ItemStatus> itemStatusHashMap) {
        this.itemStatusHashMap = itemStatusHashMap;
    }

    public Map<Integer, ItemType> getItemTypeHashMap() {
        return itemTypeHashMap;
    }

    public void setItemTypeHashMap(Map<Integer, ItemType> itemTypeHashMap) {
        this.itemTypeHashMap = itemTypeHashMap;
    }

    public Map<Integer, ItemTypeServicePrice> getItemTypeServicePriceHashMap() {
        return itemTypeServicePriceHashMap;
    }

    public void setItemTypeServicePriceHashMap(Map<Integer, ItemTypeServicePrice> itemTypeServicePriceHashMap) {
        this.itemTypeServicePriceHashMap = itemTypeServicePriceHashMap;
    }

    public Map<Integer, OrderStatus> getOrderStatusHashMap() {
        return orderStatusHashMap;
    }

    public void setOrderStatusHashMap(Map<Integer, OrderStatus> orderStatusHashMap) {
        this.orderStatusHashMap = orderStatusHashMap;
    }

    public Map<Integer, OrderType> getOrderTypeHashMap() {
        return orderTypeHashMap;
    }

    public void setOrderTypeHashMap(Map<Integer, OrderType> orderTypeHashMap) {
        this.orderTypeHashMap = orderTypeHashMap;
    }

    public Map<Integer, PaymentType> getPaymentTypeHashMap() {
        return paymentTypeHashMap;
    }

    public void setPaymentTypeHashMap(Map<Integer, PaymentType> paymentTypeHashMap) {
        this.paymentTypeHashMap = paymentTypeHashMap;
    }

    public Map<Integer, Remark> getRemarkHashMap() {
        return remarkHashMap;
    }

    public void setRemarkHashMap(Map<Integer, Remark> remarkHashMap) {
        this.remarkHashMap = remarkHashMap;
    }

    public Map<Integer, Service> getServiceHashMap() {
        return serviceHashMap;
    }

    public void setServiceHashMap(Map<Integer, Service> serviceHashMap) {
        this.serviceHashMap = serviceHashMap;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public void loadStaticInfo(){

        StaticInfoService.getUserInitializerWrapper()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {
                    staticInfoController.setBranch(t.getBranch());

                    for (CustomerType customerType : t.getCustomerTypes()){
                        customerTypeHashMap.put(customerType.getIdCustomerType(),customerType);
                    }

                    for (DyeingColor dyeingColor : t.getDyeingColors()){
                        dyeingColorHashMap.put(dyeingColor.getIdDyeingColor(),dyeingColor);
                    }

                    for (ExtraService extraService : t.getExtraServices()){
                        extraServiceHashMap.put(extraService.getIdExtraService(),extraService);
                    }

                    for (ItemCategory itemCategory : t.getItemCategories()){
                        itemCategoryHashMap.put(itemCategory.getIdItemCategory(),itemCategory);
                    }

                    for (ItemStatus itemStatus : t.getItemStatuses()){
                        itemStatusHashMap.put(itemStatus.getIdItemStatus(),itemStatus);
                    }

                    for (ItemType itemType : t.getItemTypes()){
                        itemTypeHashMap.put(itemType.getIdItemType(),itemType);
                    }

                    for (ItemTypeServicePrice itemTypeServicePrice : t.getItemTypeServicePrices()){
                        itemTypeServicePriceHashMap.put(itemTypeServicePrice.getIdItemTypeServicePrice(),itemTypeServicePrice);
                    }

                    for (OrderStatus orderStatus : t.getOrderStatuses()){
                        orderStatusHashMap.put(orderStatus.getIdOrderStatus(),orderStatus);
                    }

                    for (OrderType orderType : t.getOrderTypes()){
                        orderTypeHashMap.put(orderType.getIdOrderType(),orderType);
                    }

                    for (PaymentType paymentType : t.getPaymentTypes()){
                        paymentTypeHashMap.put(paymentType.getIdPaymentType(),paymentType);
                    }

                    for (Remark remark : t.getRemarks()){
                        remarkHashMap.put(remark.getIdRemark(),remark);
                    }

                    for (Service service : t.getServices()){
                        serviceHashMap.put(service.getIdService(),service);
                    }
                            Log.d("StatisInfooController", "loadStaticInfo: ");},
                        throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

    }
*/
}
