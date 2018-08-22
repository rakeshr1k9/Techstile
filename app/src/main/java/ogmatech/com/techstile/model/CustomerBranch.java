package ogmatech.com.techstile.model;

public class CustomerBranch {

    private Integer idCustomerBranch;

    private Branch branch;
    private Customer customer;
    private CustomerType customerType;

    public Integer getIdCustomerBranch() {
        return idCustomerBranch;
    }

    public void setIdCustomerBranch(Integer idCustomerBranch) {
        this.idCustomerBranch = idCustomerBranch;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
