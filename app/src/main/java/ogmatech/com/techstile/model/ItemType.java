package ogmatech.com.techstile.model;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class ItemType implements Serializable {

    private Integer idItemType;
    private String itemTypeName;
    private String itemTypeImageLink;
    private Byte isDeleted;

    private ItemCategory itemCategory;

    private List<ItemTypeServicePrice> itemTypeServicePrices;
    private List<Item> items;
    private List<UserCartItem> userCartItems;

    private Integer itemCategoryId;

    public ItemType(){

    }

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

    public Integer getItemCategoryId() {
        return itemCategoryId;
    }

    public void setItemCategoryId(Integer itemCategoryId) {
        this.itemCategoryId = itemCategoryId;
    }

    public List<ItemTypeServicePrice> getItemTypeServicePrices() {
        return itemTypeServicePrices;
    }

    public void setItemTypeServicePrices(List<ItemTypeServicePrice> itemTypeServicePrices) {
        this.itemTypeServicePrices = itemTypeServicePrices;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<UserCartItem> getUserCartItems() {
        return userCartItems;
    }

    public void setUserCartItems(List<UserCartItem> userCartItems) {
        this.userCartItems = userCartItems;
    }
}
