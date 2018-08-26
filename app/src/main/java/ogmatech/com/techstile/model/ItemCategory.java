package ogmatech.com.techstile.model;

import java.util.List;

public class ItemCategory {

    private Integer idItemCategory;
    private String itemCategoryName;
    private Byte isDeleted;

    private List<ItemType> itemTypes;

    public Integer getIdItemCategory() {
        return idItemCategory;
    }

    public void setIdItemCategory(Integer idItemCategory) {
        this.idItemCategory = idItemCategory;
    }

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<ItemType> getItemTypes() {
        return itemTypes;
    }

    public void setItemTypes(List<ItemType> itemTypes) {
        this.itemTypes = itemTypes;
    }
}
