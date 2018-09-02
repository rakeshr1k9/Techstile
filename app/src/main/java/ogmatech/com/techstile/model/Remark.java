package ogmatech.com.techstile.model;

import java.util.List;

public class Remark {

    private Integer idRemark;
    private String remarkName;
    private Byte isDeleted;

    private List<ItemRemark> itemRemarks;

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

    public List<ItemRemark> getItemRemarks() {
        return itemRemarks;
    }

    public void setItemRemarks(List<ItemRemark> itemRemarks) {
        this.itemRemarks = itemRemarks;
    }
}
