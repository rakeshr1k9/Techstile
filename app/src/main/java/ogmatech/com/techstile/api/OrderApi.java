package ogmatech.com.techstile.api;

import ogmatech.com.techstile.model.Order;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface OrderApi {

    @Headers("Authorization: Basic dHJ1c3RlZC1jbGllbnQ6c2VjcmV0MTIz")

    @GET("orders")
    Call<Order> getOrders();
}
