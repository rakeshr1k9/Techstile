package ogmatech.com.techstile.model;

import java.util.Date;
import java.util.List;

public class UserCartItem {

    private Integer idUserCartItem;
    private Integer userCartItemTypeCount;
    private Integer userCartItemPrice;
    private Date userCartItemCat;
    private Date userCartItemUat;

    private Integer itemTypeId;
    private Integer userId;

    private ItemType itemType;
    private User user;

    private List<UserCartItemService> userCartItemServices;

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

    public Date getUserCartItemCat() {
        return userCartItemCat;
    }

    public void setUserCartItemCat(Date userCartItemCat) {
        this.userCartItemCat = userCartItemCat;
    }

    public Date getUserCartItemUat() {
        return userCartItemUat;
    }

    public void setUserCartItemUat(Date userCartItemUat) {
        this.userCartItemUat = userCartItemUat;
    }

    public Integer getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Integer itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<UserCartItemService> getUserCartItemServices() {
        return userCartItemServices;
    }

    public void setUserCartItemServices(List<UserCartItemService> userCartItemServices) {
        this.userCartItemServices = userCartItemServices;
    }
}
