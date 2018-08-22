package ogmatech.com.techstile.model;

public class ItemCategory {

    private Integer idItemCategory;
    private String itemCategoryName;
    private Byte isDeleted;

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
}
