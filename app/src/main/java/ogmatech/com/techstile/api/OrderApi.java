package ogmatech.com.techstile.api;

import java.util.List;

import io.reactivex.Single;
import ogmatech.com.techstile.model.Order;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface OrderApi {

    @GET("order")
    Single<List<Order>> getOrders();

    @GET("order/active")
    Single<List<Order>> getActiveOrders(@Query("branchId") Integer branchId, @Query("orderStatusId") List<Integer> orderStatusId);

    @GET("order/quick")
    Single<List<Order>> getQuickOrders(@Query("branchId") Integer branchId, @Query("orderStatusId") List<Integer> orderStatusId);

    @GET("order/search")
    Single<List<Order>> getSearchOrder(@Query("branchId") Integer branchId, @Query("searchOrder") String searchOrder);

}
