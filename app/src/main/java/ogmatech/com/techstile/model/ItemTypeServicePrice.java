package ogmatech.com.techstile.model;

import java.util.List;

public class ItemTypeServicePrice {

    private Integer idItemTypeServicePrice;
    private Integer itemTypeServiceAmount;
    private Byte isDeleted;

    private ItemType itemType;
    private Service service;
    private Branch branch;

    private Integer itemTypeId;
    private Integer serviceId;
    private Integer branchId;

    public Integer getIdItemTypeServicePrice() {
        return idItemTypeServicePrice;
    }

    public void setIdItemTypeServicePrice(Integer idItemTypeServicePrice) {
        this.idItemTypeServicePrice = idItemTypeServicePrice;
    }

    public Integer getItemTypeServiceAmount() {
        return itemTypeServiceAmount;
    }

    public void setItemTypeServiceAmount(Integer itemTypeServiceAmount) {
        this.itemTypeServiceAmount = itemTypeServiceAmount;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
}
