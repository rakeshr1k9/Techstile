package ogmatech.com.techstile.model;

import java.util.Date;

public class Order {

    private Integer idOrder;
    private Integer orderTotalAmount;
    private Date orderReceivedAt;
    private Date orderShouldDeliverAt;
    private Date orderDeliveredAt;
    private Byte isQuickDelivery;
    private Byte isDeleted;
    private String customerName;
    private Long customerMobile;
    private Integer orderTotalItem;
    private Integer orderTotalItemCompleted;
    private String customerTypeName;
    private Integer orderNumber;
    private String orderReceivedByUser;
    private String orderUpdatedByUser;
    private String orderDeliveredByUser;
    private String orderStatusName;
    private String orderBranchCode;

    private Customer customer;
    private Branch branch;
    private OrderStatus orderStatus;
    private OrderType orderType;

    private Integer customerId;
    private Integer branchId;
    private Integer orderStatusId;
    private Integer OrderTypeId;

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getOrderTotalAmount() {
        return orderTotalAmount;
    }

    public void setOrderTotalAmount(Integer orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }

    public Date getOrderReceivedAt() {
        return orderReceivedAt;
    }

    public void setOrderReceivedAt(Date orderReceivedAt) {
        this.orderReceivedAt = orderReceivedAt;
    }

    public Date getOrderShouldDeliverAt() {
        return orderShouldDeliverAt;
    }

    public void setOrderShouldDeliverAt(Date orderShouldDeliverAt) {
        this.orderShouldDeliverAt = orderShouldDeliverAt;
    }

    public Date getOrderDeliveredAt() {
        return orderDeliveredAt;
    }

    public void setOrderDeliveredAt(Date orderDeliveredAt) {
        this.orderDeliveredAt = orderDeliveredAt;
    }

    public Byte getIsQuickDelivery() {
        return isQuickDelivery;
    }

    public void setIsQuickDelivery(Byte isQuickDelivery) {
        this.isQuickDelivery = isQuickDelivery;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(Long customerMobile) {
        this.customerMobile = customerMobile;
    }

    public Integer getOrderTotalItem() {
        return orderTotalItem;
    }

    public void setOrderTotalItem(Integer orderTotalItem) {
        this.orderTotalItem = orderTotalItem;
    }

    public Integer getOrderTotalItemCompleted() {
        return orderTotalItemCompleted;
    }

    public void setOrderTotalItemCompleted(Integer orderTotalItemCompleted) {
        this.orderTotalItemCompleted = orderTotalItemCompleted;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderReceivedByUser() {
        return orderReceivedByUser;
    }

    public void setOrderReceivedByUser(String orderReceivedByUser) {
        this.orderReceivedByUser = orderReceivedByUser;
    }

    public String getOrderUpdatedByUser() {
        return orderUpdatedByUser;
    }

    public void setOrderUpdatedByUser(String orderUpdatedByUser) {
        this.orderUpdatedByUser = orderUpdatedByUser;
    }

    public String getOrderDeliveredByUser() {
        return orderDeliveredByUser;
    }

    public void setOrderDeliveredByUser(String orderDeliveredByUser) {
        this.orderDeliveredByUser = orderDeliveredByUser;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public String getOrderBranchCode() {
        return orderBranchCode;
    }

    public void setOrderBranchCode(String orderBranchCode) {
        this.orderBranchCode = orderBranchCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Integer getOrderTypeId() {
        return OrderTypeId;
    }

    public void setOrderTypeId(Integer orderTypeId) {
        OrderTypeId = orderTypeId;
    }
}
