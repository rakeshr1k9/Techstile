package ogmatech.com.techstile.api.service;

import io.reactivex.Single;
import ogmatech.com.techstile.api.CheckoutApi;
import ogmatech.com.techstile.api.generic.ApiClient;
import ogmatech.com.techstile.wrapper.CustomerWrapper;

public class CheckoutService {

    private static CheckoutApi getApi(){
        return new ApiClient.Builder().build().create(CheckoutApi.class);
    }

    public static Single<CustomerWrapper> getCustomerByMobileService(Long customerMobile){
        return getApi().getCustomerByMobileService(customerMobile);
    }

    public static Single<CustomerWrapper> createCustomerService(CustomerWrapper customerWrapper){
        return getApi().createCustomerService(customerWrapper);
    }

    public static Single<CustomerWrapper> putCustomerByIdService(Integer idCustomer, CustomerWrapper customerWrapper){
        return getApi().putCustomerByIdService(idCustomer, customerWrapper);
    }
}
