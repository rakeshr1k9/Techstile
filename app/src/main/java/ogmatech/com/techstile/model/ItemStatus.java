package ogmatech.com.techstile.model;

public class ItemStatus {

    private Integer idItemStatus;
    private String itemStatusName;
    private Byte isDeleted;
    private Integer itemStatusOrder;

    public Integer getIdItemStatus() {
        return idItemStatus;
    }

    public void setIdItemStatus(Integer idItemStatus) {
        this.idItemStatus = idItemStatus;
    }

    public String getItemStatusName() {
        return itemStatusName;
    }

    public void setItemStatusName(String itemStatusName) {
        this.itemStatusName = itemStatusName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getItemStatusOrder() {
        return itemStatusOrder;
    }

    public void setItemStatusOrder(Integer itemStatusOrder) {
        this.itemStatusOrder = itemStatusOrder;
    }
}
