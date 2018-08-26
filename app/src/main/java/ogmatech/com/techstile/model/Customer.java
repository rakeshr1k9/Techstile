package ogmatech.com.techstile.model;

import java.util.List;

public class Customer {

    private Integer idCustomer;
    private Long customerMobile;
    private String customerName;
    private Byte isDeleted;
    private String customerAddress;

    private List<Order> orders;
    private List<CustomerBranch> customerBranches;

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(Long customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<CustomerBranch> getCustomerBranches() {
        return customerBranches;
    }

    public void setCustomerBranches(List<CustomerBranch> customerBranches) {
        this.customerBranches = customerBranches;
    }
}
