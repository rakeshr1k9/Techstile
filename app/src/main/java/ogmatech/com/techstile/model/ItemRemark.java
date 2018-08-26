package ogmatech.com.techstile.model;

public class ItemRemark {

    private Integer idItemRemark;
    private Byte isDeleted;
    private String itemRemarkUpdatedByUser;

    private Integer itemId;
    private Integer remarkId;
    private Integer orderId;
    private Integer branchId;

    private Item item;
    private Remark remark;
    private Order order;
    private Branch branch;

    public Integer getIdItemRemark() {
        return idItemRemark;
    }

    public void setIdItemRemark(Integer idItemRemark) {
        this.idItemRemark = idItemRemark;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getItemRemarkUpdatedByUser() {
        return itemRemarkUpdatedByUser;
    }

    public void setItemRemarkUpdatedByUser(String itemRemarkUpdatedByUser) {
        this.itemRemarkUpdatedByUser = itemRemarkUpdatedByUser;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Remark getRemark() {
        return remark;
    }

    public void setRemark(Remark remark) {
        this.remark = remark;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getRemarkId() {
        return remarkId;
    }

    public void setRemarkId(Integer remarkId) {
        this.remarkId = remarkId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
}
