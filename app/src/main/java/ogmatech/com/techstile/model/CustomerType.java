package ogmatech.com.techstile.model;

import java.util.List;

public class CustomerType {
    private Integer idCustomerType;
    private String customerTypeName;
    private Byte isDeleted;

    private List<CustomerBranch> customerBranches;

    public Integer getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(Integer idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<CustomerBranch> getCustomerBranches() {
        return customerBranches;
    }

    public void setCustomerBranches(List<CustomerBranch> customerBranches) {
        this.customerBranches = customerBranches;
    }

    @Override
    public String toString() {
        return customerTypeName;
    }
}
