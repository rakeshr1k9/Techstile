package ogmatech.com.techstile.model;

public class OrderStatus {
    private Integer idOrderStatus;
    private String orderStatusName;
    private Byte isDeleted;
    private Integer orderStatusOrder;

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
}
