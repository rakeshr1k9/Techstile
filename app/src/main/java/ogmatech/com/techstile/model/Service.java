package ogmatech.com.techstile.model;

import java.util.List;

public class Service {
    private Integer idService;
    private String serviceName;
    private String serviceCode;
    private Byte isDeleted;
    private Integer serviceOrder;

    private List<ItemServicePrice> itemServicePrices;
    private List<ItemTypeServicePrice> itemTypeServicePrices;
    private List<WorkerService> workerServices;

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

    public List<WorkerService> getWorkerServices() {
        return workerServices;
    }

    public void setWorkerServices(List<WorkerService> workerServices) {
        this.workerServices = workerServices;
    }
}
