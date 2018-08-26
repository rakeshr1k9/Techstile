package ogmatech.com.techstile.model;

import java.util.List;

public class OrderType {
    private Integer idOrderType;
    private String orderTypeName;
    private Byte isDeleted;

    private List<Order> orders;

    public Integer getIdOrderType() {
        return idOrderType;
    }

    public void setIdOrderType(Integer idOrderType) {
        this.idOrderType = idOrderType;
    }

    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
