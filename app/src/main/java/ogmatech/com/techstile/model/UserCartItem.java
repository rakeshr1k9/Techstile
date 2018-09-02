package ogmatech.com.techstile.model;

import java.util.List;

public class UserCartItem {

    private Integer idUserCartItem;
    private Integer userCartItemTypeId;
    private String userCartItemTypeName;
    private Integer userCartItemTypeCount;
    private Integer userId;
    private Integer userCartItemPrice;

    private List<UserCartItemService> userCartItemServices;

    public Integer getIdUserCartItem() {
        return idUserCartItem;
    }

    public void setIdUserCartItem(Integer idUserCartItem) {
        this.idUserCartItem = idUserCartItem;
    }

    public Integer getUserCartItemTypeId() {
        return userCartItemTypeId;
    }

    public void setUserCartItemTypeId(Integer userCartItemTypeId) {
        this.userCartItemTypeId = userCartItemTypeId;
    }

    public String getUserCartItemTypeName() {
        return userCartItemTypeName;
    }

    public void setUserCartItemTypeName(String userCartItemTypeName) {
        this.userCartItemTypeName = userCartItemTypeName;
    }

    public Integer getUserCartItemTypeCount() {
        return userCartItemTypeCount;
    }

    public void setUserCartItemTypeCount(Integer userCartItemTypeCount) {
        this.userCartItemTypeCount = userCartItemTypeCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserCartItemPrice() {
        return userCartItemPrice;
    }

    public void setUserCartItemPrice(Integer userCartItemPrice) {
        this.userCartItemPrice = userCartItemPrice;
    }

    public List<UserCartItemService> getUserCartItemServices() {
        return userCartItemServices;
    }

    public void setUserCartItemServices(List<UserCartItemService> userCartItemServices) {
        this.userCartItemServices = userCartItemServices;
    }
}
