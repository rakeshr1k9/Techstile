package ogmatech.com.techstile.model;

public class PaymentType {
    private Integer idPaymentType;
    private String paymentTypeName;
    private Byte isDeleted;

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
}
