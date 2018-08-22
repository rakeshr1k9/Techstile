package ogmatech.com.techstile.model;

public class ItemExtraServicePrice {

    private Integer idItemExtraServicePrice;
    private Integer itemExtraServiceAmount;
    private Byte isDeleted;
    private String itemExtraServicePriceCreatedByUser;
    private String itemExtraServicePriceUpdatedByUser;

    private ExtraService extraService;
    private Item item;
    private Order order;

    public Integer getIdItemExtraServicePrice() {
        return idItemExtraServicePrice;
    }

    public void setIdItemExtraServicePrice(Integer idItemExtraServicePrice) {
        this.idItemExtraServicePrice = idItemExtraServicePrice;
    }

    public Integer getItemExtraServiceAmount() {
        return itemExtraServiceAmount;
    }

    public void setItemExtraServiceAmount(Integer itemExtraServiceAmount) {
        this.itemExtraServiceAmount = itemExtraServiceAmount;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getItemExtraServicePriceCreatedByUser() {
        return itemExtraServicePriceCreatedByUser;
    }

    public void setItemExtraServicePriceCreatedByUser(String itemExtraServicePriceCreatedByUser) {
        this.itemExtraServicePriceCreatedByUser = itemExtraServicePriceCreatedByUser;
    }

    public String getItemExtraServicePriceUpdatedByUser() {
        return itemExtraServicePriceUpdatedByUser;
    }

    public void setItemExtraServicePriceUpdatedByUser(String itemExtraServicePriceUpdatedByUser) {
        this.itemExtraServicePriceUpdatedByUser = itemExtraServicePriceUpdatedByUser;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
