package ogmatech.com.techstile.model;

import java.util.Date;

public class ItemServiceScan {

    private Integer idItemServiceScan;
    private Date itemServiceScanTime;
    private Byte isDeleted;

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
}
