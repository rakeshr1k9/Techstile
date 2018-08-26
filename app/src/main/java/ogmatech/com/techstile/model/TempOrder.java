package ogmatech.com.techstile.model;

import java.util.Date;

public class TempOrder {

    private Integer idTempOrder;
    private Integer tempOrderNumber;
    private Date tempOrderReceivedAt;
    private Byte isDeleted;

    private Integer orderId;
    private Integer branchId;

    private Order order;
    private Branch branch;

    public Integer getIdTempOrder() {
        return idTempOrder;
    }

    public void setIdTempOrder(Integer idTempOrder) {
        this.idTempOrder = idTempOrder;
    }

    public Integer getTempOrderNumber() {
        return tempOrderNumber;
    }

    public void setTempOrderNumber(Integer tempOrderNumber) {
        this.tempOrderNumber = tempOrderNumber;
    }

    public Date getTempOrderReceivedAt() {
        return tempOrderReceivedAt;
    }

    public void setTempOrderReceivedAt(Date tempOrderReceivedAt) {
        this.tempOrderReceivedAt = tempOrderReceivedAt;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }
}
