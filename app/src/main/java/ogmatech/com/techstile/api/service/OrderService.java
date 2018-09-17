package ogmatech.com.techstile.api.service;

import java.util.List;

import io.reactivex.Single;
import ogmatech.com.techstile.api.OrderApi;
import ogmatech.com.techstile.api.generic.ApiClient;
import ogmatech.com.techstile.model.Order;

public class OrderService {
    private static OrderApi getApi () {
        return new ApiClient.Builder().build().create(OrderApi.class);
    }

    public static Single<List<Order>> getOrders () {
        return getApi().getOrders();
    }
    
    public static Single<List<Order>> getActiveOrders (List<Integer> orderStatusId) {
        Integer branchId = 1;
        return getApi().getActiveOrders(branchId, orderStatusId);
    }

    public static Single<List<Order>> getQuickOrders (List<Integer> orderStatusId) {
        Integer branchId = 1;
        return getApi().getQuickOrders(branchId, orderStatusId);
    }

    public static Single<List<Order>> getSearchOrder (String searchOrder) {
        Integer branchId = 1;
        return getApi().getSearchOrder(branchId, searchOrder);
    }
}
