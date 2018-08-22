package ogmatech.com.techstile.model;

public class OrderType {
    private Integer idOrderType;
    private String orderTypeName;
    private Byte isDeleted;

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
}
