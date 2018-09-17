package ogmatech.com.techstile.model;

import java.util.Date;

public class UserCartItemService {

    private Integer idUserCartItemService;
    private Date userCartItemServiceCat;
    private Date userCartItemServiceUat;

    private Integer userCartItemId;
    private Integer serviceId;

    private UserCartItem userCartItem;
    private Service service;

    public Integer getIdUserCartItemService() {
        return idUserCartItemService;
    }

    public void setIdUserCartItemService(Integer idUserCartItemService) {
        this.idUserCartItemService = idUserCartItemService;
    }

    public Date getUserCartItemServiceCat() {
        return userCartItemServiceCat;
    }

    public void setUserCartItemServiceCat(Date userCartItemServiceCat) {
        this.userCartItemServiceCat = userCartItemServiceCat;
    }

    public Date getUserCartItemServiceUat() {
        return userCartItemServiceUat;
    }

    public void setUserCartItemServiceUat(Date userCartItemServiceUat) {
        this.userCartItemServiceUat = userCartItemServiceUat;
    }

    public Integer getUserCartItemId() {
        return userCartItemId;
    }

    public void setUserCartItemId(Integer userCartItemId) {
        this.userCartItemId = userCartItemId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public UserCartItem getUserCartItem() {
        return userCartItem;
    }

    public void setUserCartItem(UserCartItem userCartItem) {
        this.userCartItem = userCartItem;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
