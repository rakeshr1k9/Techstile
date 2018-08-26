package ogmatech.com.techstile.model;

import java.util.List;

public class Branch {

    private Integer idBranch;
    private String branchCode;
    private String branchName;
    private String branchPlace;
    private Byte isDeleted;
    private String branchLocation;
    private String branchAddress;
    private Integer branchPincode;
    private Long branchPhone1;
    private String branchWebsite;
    private String branchGstin;
    private String branchTagline;
    private Long branchPhone2;
    private Long branchPhone3;

    private List<User> users;
    private List<CustomerBranch> customerBranches;
    private List<Order> orders;
    private List<Item> items;
    private List<ItemRemark> itemRemarks;
    private List<Payment> payments;
    private List<TempOrder> tempOrders;
    private List<ItemServicePrice> itemServicePrices;
    private List<ItemTypeServicePrice> itemTypeServicePrices;

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchPlace() {
        return branchPlace;
    }

    public void setBranchPlace(String branchPlace) {
        this.branchPlace = branchPlace;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Integer getBranchPincode() {
        return branchPincode;
    }

    public void setBranchPincode(Integer branchPincode) {
        this.branchPincode = branchPincode;
    }

    public Long getBranchPhone1() {
        return branchPhone1;
    }

    public void setBranchPhone1(Long branchPhone1) {
        this.branchPhone1 = branchPhone1;
    }

    public String getBranchWebsite() {
        return branchWebsite;
    }

    public void setBranchWebsite(String branchWebsite) {
        this.branchWebsite = branchWebsite;
    }

    public String getBranchGstin() {
        return branchGstin;
    }

    public void setBranchGstin(String branchGstin) {
        this.branchGstin = branchGstin;
    }

    public String getBranchTagline() {
        return branchTagline;
    }

    public void setBranchTagline(String branchTagline) {
        this.branchTagline = branchTagline;
    }

    public Long getBranchPhone2() {
        return branchPhone2;
    }

    public void setBranchPhone2(Long branchPhone2) {
        this.branchPhone2 = branchPhone2;
    }

    public Long getBranchPhone3() {
        return branchPhone3;
    }

    public void setBranchPhone3(Long branchPhone3) {
        this.branchPhone3 = branchPhone3;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<CustomerBranch> getCustomerBranches() {
        return customerBranches;
    }

    public void setCustomerBranches(List<CustomerBranch> customerBranches) {
        this.customerBranches = customerBranches;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<ItemRemark> getItemRemarks() {
        return itemRemarks;
    }

    public void setItemRemarks(List<ItemRemark> itemRemarks) {
        this.itemRemarks = itemRemarks;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<TempOrder> getTempOrders() {
        return tempOrders;
    }

    public void setTempOrders(List<TempOrder> tempOrders) {
        this.tempOrders = tempOrders;
    }

    public List<ItemServicePrice> getItemServicePrices() {
        return itemServicePrices;
    }

    public void setItemServicePrices(List<ItemServicePrice> itemServicePrices) {
        this.itemServicePrices = itemServicePrices;
    }

    public List<ItemTypeServicePrice> getItemTypeServicePrices() {
        return itemTypeServicePrices;
    }

    public void setItemTypeServicePrices(List<ItemTypeServicePrice> itemTypeServicePrices) {
        this.itemTypeServicePrices = itemTypeServicePrices;
    }
}
