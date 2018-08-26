package ogmatech.com.techstile.model;

import java.util.List;

public class PaymentType {
    private Integer idPaymentType;
    private String paymentTypeName;
    private Byte isDeleted;

    private List<Payment> payments;

    public Integer getIdPaymentType() {
        return idPaymentType;
    }

    public void setIdPaymentType(Integer idPaymentType) {
        this.idPaymentType = idPaymentType;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
