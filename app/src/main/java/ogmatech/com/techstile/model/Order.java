package ogmatech.com.techstile.model;

import java.util.Date;

public class Order {

    private Long idOrder;
    private Integer orderTotalAmount;
    private Date orderReceivedAt;
    private Date orderShouldDeliverAt;
    private Date orderDeliveredAt;
    private String orderBagNumber;
    private Byte isQuickDeivery;
    private Byte isDeleted;
    private Date orderCat;
    private Date orderUat;
    private Long orderCreatedByUserId;
    private Long orderDeliveredByUserId;

    private Long customerId;
    private Long branchId;
    private Long orderStatusId;
    private Long orderTypeId;

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
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

    public String getOrderBagNumber() {
        return orderBagNumber;
    }

    public void setOrderBagNumber(String orderBagNumber) {
        this.orderBagNumber = orderBagNumber;
    }

    public Byte getIsQuickDeivery() {
        return isQuickDeivery;
    }

    public void setIsQuickDeivery(Byte isQuickDeivery) {
        this.isQuickDeivery = isQuickDeivery;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getOrderCat() {
        return orderCat;
    }

    public void setOrderCat(Date orderCat) {
        this.orderCat = orderCat;
    }

    public Date getOrderUat() {
        return orderUat;
    }

    public void setOrderUat(Date orderUat) {
        this.orderUat = orderUat;
    }

    public Long getOrderCreatedByUserId() {
        return orderCreatedByUserId;
    }

    public void setOrderCreatedByUserId(Long orderCreatedByUserId) {
        this.orderCreatedByUserId = orderCreatedByUserId;
    }

    public Long getOrderDeliveredByUserId() {
        return orderDeliveredByUserId;
    }

    public void setOrderDeliveredByUserId(Long orderDeliveredByUserId) {
        this.orderDeliveredByUserId = orderDeliveredByUserId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public Long getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(Long orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public Long getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(Long orderTypeId) {
        this.orderTypeId = orderTypeId;
    }
}
