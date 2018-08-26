package ogmatech.com.techstile.model;

public class ItemDyeingColor {

    private Integer idItemDyeingColor;
    private Byte isDeleted;

    private Integer itemId;
    private Integer dyeingColorId;

    private Item item;
    private DyeingColor dyeingColor;

    public Integer getIdItemDyeingColor() {
        return idItemDyeingColor;
    }

    public void setIdItemDyeingColor(Integer idItemDyeingColor) {
        this.idItemDyeingColor = idItemDyeingColor;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public DyeingColor getDyeingColor() {
        return dyeingColor;
    }

    public void setDyeingColor(DyeingColor dyeingColor) {
        this.dyeingColor = dyeingColor;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getDyeingColorId() {
        return dyeingColorId;
    }

    public void setDyeingColorId(Integer dyeingColorId) {
        this.dyeingColorId = dyeingColorId;
    }
}
