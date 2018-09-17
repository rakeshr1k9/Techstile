package ogmatech.com.techstile.model;

import java.util.Date;
import java.util.List;

public class Item {

    /*String imageName;
    String itemName;*/

    private Integer idItem;
    private Integer itemQrNumber;
    private Integer itemTotalAmount;
    private Date itemShouldDeliverAt;
    private Date itemDeliveredAt;
    private Byte isQuickDelivery;
    private Byte isDeleted;
    private String itemUpdatedByUser;

    private Integer orderId;
    private Integer itemTypeId;
    private Integer itemStatusId;
    private Integer branchId;

    private Order order;
    private ItemType itemType;
    private ItemStatus itemStatus;
    private Branch branch;

    private List<ItemServiceScan> itemServiceScans;
    private List<ItemRemark> itemRemarks;
    private List<ItemExtraServicePrice> itemExtraServicePrices;
    private List<ItemDyeingColor> itemDyeingColors;
    private List<ItemServicePrice> itemServicePrices;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getItemQrNumber() {
        return itemQrNumber;
    }

    public void setItemQrNumber(Integer itemQrNumber) {
        this.itemQrNumber = itemQrNumber;
    }

    public Integer getItemTotalAmount() {
        return itemTotalAmount;
    }

    public void setItemTotalAmount(Integer itemTotalAmount) {
        this.itemTotalAmount = itemTotalAmount;
    }

    public Date getItemShouldDeliverAt() {
        return itemShouldDeliverAt;
    }

    public void setItemShouldDeliverAt(Date itemShouldDeliverAt) {
        this.itemShouldDeliverAt = itemShouldDeliverAt;
    }

    public Date getItemDeliveredAt() {
        return itemDeliveredAt;
    }

    public void setItemDeliveredAt(Date itemDeliveredAt) {
        this.itemDeliveredAt = itemDeliveredAt;
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

    public String getItemUpdatedByUser() {
        return itemUpdatedByUser;
    }

    public void setItemUpdatedByUser(String itemUpdatedByUser) {
        this.itemUpdatedByUser = itemUpdatedByUser;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public Integer getItemStatusId() {
        return itemStatusId;
    }

    public void setItemStatusId(Integer itemStatusId) {
        this.itemStatusId = itemStatusId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public List<ItemServiceScan> getItemServiceScans() {
        return itemServiceScans;
    }

    public void setItemServiceScans(List<ItemServiceScan> itemServiceScans) {
        this.itemServiceScans = itemServiceScans;
    }

    public List<ItemRemark> getItemRemarks() {
        return itemRemarks;
    }

    public void setItemRemarks(List<ItemRemark> itemRemarks) {
        this.itemRemarks = itemRemarks;
    }

    public List<ItemExtraServicePrice> getItemExtraServicePrices() {
        return itemExtraServicePrices;
    }

    public void setItemExtraServicePrices(List<ItemExtraServicePrice> itemExtraServicePrices) {
        this.itemExtraServicePrices = itemExtraServicePrices;
    }

    public List<ItemDyeingColor> getItemDyeingColors() {
        return itemDyeingColors;
    }

    public void setItemDyeingColors(List<ItemDyeingColor> itemDyeingColors) {
        this.itemDyeingColors = itemDyeingColors;
    }

    public List<ItemServicePrice> getItemServicePrices() {
        return itemServicePrices;
    }

    public void setItemServicePrices(List<ItemServicePrice> itemServicePrices) {
        this.itemServicePrices = itemServicePrices;
    }


}
