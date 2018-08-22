package ogmatech.com.techstile.model;

public class Service {
    private Integer idService;
    private String serviceName;
    private String serviceCode;
    private Byte isDeleted;
    private Integer serviceOrder;

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Integer getServiceOrder() {
        return serviceOrder;
    }

    public void setServiceOrder(Integer serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}
