package ogmatech.com.techstile.wrapper;

import java.util.List;

public class CartItemWrapper {

    private Integer idUserCartItem;
    private Integer userCartItemTypeCount;
    private Integer userCartItemPrice;
    private String itemTypeName;
    private String itemTypeImageLink;
    private List<String> itemServices;

    public CartItemWrapper(){

    }

    public Integer getIdUserCartItem() {
        return idUserCartItem;
    }

    public void setIdUserCartItem(Integer idUserCartItem) {
        this.idUserCartItem = idUserCartItem;
    }

    public Integer getUserCartItemTypeCount() {
        return userCartItemTypeCount;
    }

    public void setUserCartItemTypeCount(Integer userCartItemTypeCount) {
        this.userCartItemTypeCount = userCartItemTypeCount;
    }

    public Integer getUserCartItemPrice() {
        return userCartItemPrice;
    }

    public void setUserCartItemPrice(Integer userCartItemPrice) {
        this.userCartItemPrice = userCartItemPrice;
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

    public List<String> getItemServices() {
        return itemServices;
    }

    public void setItemServices(List<String> itemServices) {
        this.itemServices = itemServices;
    }
}
