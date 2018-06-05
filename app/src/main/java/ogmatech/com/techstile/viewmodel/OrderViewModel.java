package ogmatech.com.techstile.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import ogmatech.com.techstile.model.Order;

public class OrderViewModel extends ViewModel {

    private String orderId;
    private LiveData<Order> order;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LiveData<Order> getOrder() {
        return order;
    }

    public void setOrder(LiveData<Order> order) {
        this.order = order;
    }
}
