package ogmatech.com.techstile.wrapper;

import ogmatech.com.techstile.model.Customer;
import ogmatech.com.techstile.model.CustomerBranch;

public class CustomerWrapper {

    private Integer idCustomer;
    private Long customerMobile;
    private String customerName;
    private String customerAddress;
    private Integer idCustomerType;
    private String customerTypeName;

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

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

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
}
