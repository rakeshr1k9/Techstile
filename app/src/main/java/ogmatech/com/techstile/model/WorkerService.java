package ogmatech.com.techstile.model;

public class WorkerService {

    private Integer idWorkerService;
    private Byte isDeleted;

    private Service service;

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
}
