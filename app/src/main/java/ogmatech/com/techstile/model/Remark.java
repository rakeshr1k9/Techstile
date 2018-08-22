package ogmatech.com.techstile.model;

public class Remark {

    private Integer idRemark;
    private String remarkName;
    private Byte isDeleted;

    public Integer getIdRemark() {
        return idRemark;
    }

    public void setIdRemark(Integer idRemark) {
        this.idRemark = idRemark;
    }

    public String getRemarkName() {
        return remarkName;
    }

    public void setRemarkName(String remarkName) {
        this.remarkName = remarkName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}
