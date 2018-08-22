package ogmatech.com.techstile.model;

public class ItemDyeingColor {

    private Integer idItemDyeingColor;
    private Byte isDeleted;

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
}
