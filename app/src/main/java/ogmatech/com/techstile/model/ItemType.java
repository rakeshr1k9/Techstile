package ogmatech.com.techstile.model;

public class ItemType {

    private Integer idItemType;
    private String itemTypeName;
    private String itemTypeImageLink;
    private Byte isDeleted;

    private ItemCategory itemCategory;

    public Integer getIdItemType() {
        return idItemType;
    }

    public void setIdItemType(Integer idItemType) {
        this.idItemType = idItemType;
    }

    public String getItemTypeName() {
        return itemTypeName;
    }

    public void setItemTypeName(String itemTypeName) {
        this.itemTypeName = itemTypeName;
    }

    public String getItemTypeImageLink() {
        return itemTypeImageLink;
    }

    public void setItemTypeImageLink(String itemTypeImageLink) {
        this.itemTypeImageLink = itemTypeImageLink;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }
}
