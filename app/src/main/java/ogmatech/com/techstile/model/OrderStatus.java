package ogmatech.com.techstile.model;

import java.util.List;

public class OrderStatus {
    private Integer idOrderStatus;
    private String orderStatusName;
    private Byte isDeleted;
    private Integer orderStatusOrder;

    private List<Order> orders;

    public Integer getIdOrderStatus() {
        return idOrderStatus;
    }

    public void setIdOrderStatus(Integer idOrderStatus) {
        this.idOrderStatus = idOrderStatus;
    }

    public String getOrderStatusName() {
        return orderStatusName;
    }

    public void setOrderStatusName(String orderStatusName) {
        this.orderStatusName = orderStatusName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getOrderStatusOrder() {
        return orderStatusOrder;
    }

    public void setOrderStatusOrder(Integer orderStatusOrder) {
        this.orderStatusOrder = orderStatusOrder;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
