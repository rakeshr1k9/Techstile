package ogmatech.com.techstile.model;

import java.util.List;

public class ExtraService {

    private Integer idExtraService;
    private String extraServiceName;
    private Byte isDeleted;

    private List<ItemExtraServicePrice> itemExtraServicePrices;

    public Integer getIdExtraService() {
        return idExtraService;
    }

    public void setIdExtraService(Integer idExtraService) {
        this.idExtraService = idExtraService;
    }

    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<ItemExtraServicePrice> getItemExtraServicePrices() {
        return itemExtraServicePrices;
    }

    public void setItemExtraServicePrices(List<ItemExtraServicePrice> itemExtraServicePrices) {
        this.itemExtraServicePrices = itemExtraServicePrices;
    }
}
