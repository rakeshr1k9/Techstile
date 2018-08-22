package ogmatech.com.techstile.model;

import java.util.Date;

public class Payment {

    private Integer idPayment;
    private Integer paymentAmount;
    private Byte isDeleted;
    private String paymentManageByUser;
    private Date paymentAt;

    private Order order;
    private PaymentType paymentType;
    private Branch branch;

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getPaymentManageByUser() {
        return paymentManageByUser;
    }

    public void setPaymentManageByUser(String paymentManageByUser) {
        this.paymentManageByUser = paymentManageByUser;
    }

    public Date getPaymentAt() {
        return paymentAt;
    }

    public void setPaymentAt(Date paymentAt) {
        this.paymentAt = paymentAt;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
