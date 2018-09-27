package ogmatech.com.techstile.api;

import java.util.List;

import io.reactivex.Single;
import ogmatech.com.techstile.model.UserCartItem;
import ogmatech.com.techstile.wrapper.CustomerWrapper;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface CheckoutApi {

    @GET("user/customer/{customerMobile}")
    Single<CustomerWrapper> getCustomerByMobileService(@Path("customerMobile") Long customerMobile);

    @POST("user/customer")
    Single<CustomerWrapper> createCustomerService(@Body CustomerWrapper customerWrapper);

    @PUT("user/customer/{id}")
    Single<CustomerWrapper> putCustomerByIdService(@Path("id") Integer idCustomer, @Body CustomerWrapper customerWrapper);
}
