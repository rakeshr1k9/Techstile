package ogmatech.com.techstile.model;

import java.util.Date;
import java.util.List;

public class Role {

    private Integer idRole;
    private String roleName;
    private Byte isDeleted;
    private Date roleCat;
    private Date roleUat;

    private List<UserRole> userRoles;

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getRoleCat() {
        return roleCat;
    }

    public void setRoleCat(Date roleCat) {
        this.roleCat = roleCat;
    }

    public Date getRoleUat() {
        return roleUat;
    }

    public void setRoleUat(Date roleUat) {
        this.roleUat = roleUat;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
