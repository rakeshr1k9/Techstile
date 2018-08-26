package ogmatech.com.techstile.model;

import java.util.Date;

public class ItemServiceScan {

    private Integer idItemServiceScan;
    private Date itemServiceScanTime;
    private Byte isDeleted;

    private Integer workerServiceId;
    private Integer itemId;

    private WorkerService workerService;
    private Item item;

    public Integer getIdItemServiceScan() {
        return idItemServiceScan;
    }

    public void setIdItemServiceScan(Integer idItemServiceScan) {
        this.idItemServiceScan = idItemServiceScan;
    }

    public Date getItemServiceScanTime() {
        return itemServiceScanTime;
    }

    public void setItemServiceScanTime(Date itemServiceScanTime) {
        this.itemServiceScanTime = itemServiceScanTime;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public WorkerService getWorkerService() {
        return workerService;
    }

    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getWorkerServiceId() {
        return workerServiceId;
    }

    public void setWorkerServiceId(Integer workerServiceId) {
        this.workerServiceId = workerServiceId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
