package ogmatech.com.techstile.wrapper;

import java.util.List;

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

public class UserInitializerWrapper {

    private List<CustomerType> customerTypes;
    private List<DyeingColor> dyeingColors;
    private List<ExtraService> extraServices;
    private List<ItemCategory> itemCategories;
    private List<ItemStatus> itemStatuses;
    private List<ItemType> itemTypes;
    private List<ItemTypeServicePrice> itemTypeServicePrices;
    private List<OrderStatus> orderStatuses;
    private List<OrderType> orderTypes;
    private List<PaymentType>paymentTypes;
    private List<Remark> remarks;
    private List<Service> services;
    private Branch branch;

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
}
