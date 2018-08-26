package ogmatech.com.techstile.model;

public class ItemServicePrice {

    private Integer idItemServicePrice;
    private Byte isDeleted;
    private Integer itemServiceAmount;
    private String itemServicePriceCreatedByUser;
    private String itemServicePriceUpdatedByUser;

    private Integer itemId;
    private Integer serviceId;
    private Integer orderId;
    private Integer branchId;

    private Item item;
    private Service service;
    private Order order;
    private Branch branch;

    public Integer getIdItemServicePrice() {
        return idItemServicePrice;
    }

    public void setIdItemServicePrice(Integer idItemServicePrice) {
        this.idItemServicePrice = idItemServicePrice;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getItemServiceAmount() {
        return itemServiceAmount;
    }

    public void setItemServiceAmount(Integer itemServiceAmount) {
        this.itemServiceAmount = itemServiceAmount;
    }

    public String getItemServicePriceCreatedByUser() {
        return itemServicePriceCreatedByUser;
    }

    public void setItemServicePriceCreatedByUser(String itemServicePriceCreatedByUser) {
        this.itemServicePriceCreatedByUser = itemServicePriceCreatedByUser;
    }

    public String getItemServicePriceUpdatedByUser() {
        return itemServicePriceUpdatedByUser;
    }

    public void setItemServicePriceUpdatedByUser(String itemServicePriceUpdatedByUser) {
        this.itemServicePriceUpdatedByUser = itemServicePriceUpdatedByUser;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
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

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
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
