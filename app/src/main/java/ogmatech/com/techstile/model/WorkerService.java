package ogmatech.com.techstile.model;

import java.util.List;

public class WorkerService {

    private Integer idWorkerService;
    private Byte isDeleted;

    private Integer userId;
    private Integer serviceId;

    private User user;
    private Service service;

    private List<ItemServiceScan> itemServiceScans;

    public Integer getIdWorkerService() {
        return idWorkerService;
    }

    public void setIdWorkerService(Integer idWorkerService) {
        this.idWorkerService = idWorkerService;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ItemServiceScan> getItemServiceScans() {
        return itemServiceScans;
    }

    public void setItemServiceScans(List<ItemServiceScan> itemServiceScans) {
        this.itemServiceScans = itemServiceScans;
    }
}
