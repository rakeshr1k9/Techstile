package ogmatech.com.techstile.wrapper;

public class ItemTypeServiceWrapper {

    private Integer idItemService;
    private String serviceName;
    private Integer servicePrice;
    private String serviceImageLink;

    public Integer getIdItemService() {
        return idItemService;
    }

    public void setIdItemService(Integer idItemService) {
        this.idItemService = idItemService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Integer servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getServiceImageLink() {
        return serviceImageLink;
    }

    public void setServiceImageLink(String serviceImageLink) {
        this.serviceImageLink = serviceImageLink;
    }
}
