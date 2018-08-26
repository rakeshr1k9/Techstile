package ogmatech.com.techstile.model;

import java.util.Date;

public class UserRole {

    private Integer idUserRole;
    private Byte isDeleted;
    private Date userRoleCat;
    private Date userRoleUat;

    private Integer userId;
    private Integer roleId;

    private User user;
    private Role role;

    public Integer getIdUserRole() {
        return idUserRole;
    }

    public void setIdUserRole(Integer idUserRole) {
        this.idUserRole = idUserRole;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getUserRoleCat() {
        return userRoleCat;
    }

    public void setUserRoleCat(Date userRoleCat) {
        this.userRoleCat = userRoleCat;
    }

    public Date getUserRoleUat() {
        return userRoleUat;
    }

    public void setUserRoleUat(Date userRoleUat) {
        this.userRoleUat = userRoleUat;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
