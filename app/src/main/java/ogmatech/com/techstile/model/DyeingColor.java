package ogmatech.com.techstile.model;

import java.util.List;

public class DyeingColor {

    private Integer idDyeingColor;
    private Integer dyeingColorNumber;
    private String dyeingColorName;
    private Byte isDeleted;

    private List<ItemDyeingColor> itemDyeingColors;

    public Integer getIdDyeingColor() {
        return idDyeingColor;
    }

    public void setIdDyeingColor(Integer idDyeingColor) {
        this.idDyeingColor = idDyeingColor;
    }

    public Integer getDyeingColorNumber() {
        return dyeingColorNumber;
    }

    public void setDyeingColorNumber(Integer dyeingColorNumber) {
        this.dyeingColorNumber = dyeingColorNumber;
    }

    public String getDyeingColorName() {
        return dyeingColorName;
    }

    public void setDyeingColorName(String dyeingColorName) {
        this.dyeingColorName = dyeingColorName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<ItemDyeingColor> getItemDyeingColors() {
        return itemDyeingColors;
    }

    public void setItemDyeingColors(List<ItemDyeingColor> itemDyeingColors) {
        this.itemDyeingColors = itemDyeingColors;
    }
}
