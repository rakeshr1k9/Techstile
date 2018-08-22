package ogmatech.com.techstile.model;

public class ExtraService {

    private Integer idExtraService;
    private String extraServiceName;
    private Byte isDeleted;

    public Integer getIdExtraService() {
        return idExtraService;
    }

    public void setIdExtraService(Integer idExtraService) {
        this.idExtraService = idExtraService;
    }

    public String getExtraServiceName() {
        return extraServiceName;
    }

    public void setExtraServiceName(String extraServiceName) {
        this.extraServiceName = extraServiceName;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}
