package ogmatech.com.techstile.model;

import java.util.Date;
import java.util.List;

public class User {

    private Integer idUser;
    private String username;
    private String password;
    private Long userMobile;
    private Byte isDeleted;
    private Date userCat;
    private Date userUat;
    private String userDeviceIdentity;

    private Integer branchId;

    private Branch branch;

    private List<WorkerService> workerServices;
    private List<UserRole> userRoles;

    private UserCartItem userCartItem;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(Long userMobile) {
        this.userMobile = userMobile;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getUserCat() {
        return userCat;
    }

    public void setUserCat(Date userCat) {
        this.userCat = userCat;
    }

    public Date getUserUat() {
        return userUat;
    }

    public void setUserUat(Date userUat) {
        this.userUat = userUat;
    }

    public String getUserDeviceIdentity() {
        return userDeviceIdentity;
    }

    public void setUserDeviceIdentity(String userDeviceIdentity) {
        this.userDeviceIdentity = userDeviceIdentity;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<WorkerService> getWorkerServices() {
        return workerServices;
    }

    public void setWorkerServices(List<WorkerService> workerServices) {
        this.workerServices = workerServices;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public UserCartItem getUserCartItem() {
        return userCartItem;
    }

    public void setUserCartItem(UserCartItem userCartItem) {
        this.userCartItem = userCartItem;
    }
}
