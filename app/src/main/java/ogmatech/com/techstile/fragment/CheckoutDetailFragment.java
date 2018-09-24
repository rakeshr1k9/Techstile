package ogmatech.com.techstile.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.CartItemAdapter;
import ogmatech.com.techstile.adapter.CheckoutCartItemAdapter;
import ogmatech.com.techstile.api.service.CartItemService;
import ogmatech.com.techstile.wrapper.CartItemWrapper;

public class CheckoutDetailFragment extends Fragment {

    private RecyclerView recyclerView;
    private CheckoutCartItemAdapter checkoutCartItemAdapter;

    private Integer itemCountForGrandTotal = 0;

    private TextView customerName, customerMobile, customerAddress, quickDeliveryPrice, cartItemCount, cartItemPrice, receivingDate, deliverDate;


    public CheckoutDetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_checkout_detail, container, false);

        recyclerView = view.findViewById(R.id.recycler_view_checkout_cart);

        getCartItemApi();

        return view;
    }

    private void getCartItemApi(){

        List<CartItemWrapper> cartItemWrappers = new ArrayList<>();

        CartItemService.getCartItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{checkoutCartItemAdapter = new CheckoutCartItemAdapter(getActivity(),t);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(checkoutCartItemAdapter);

                    Integer itemCountTemp=0;
                    Integer itemTotalPriceTemp=0;

                    for (CartItemWrapper cartItemWrapper : t){
                        Integer itemCountInc = cartItemWrapper.getUserCartItemTypeCount();
                        Integer itemTotalPriceInc = cartItemWrapper.getUserCartItemPrice();
                        itemCountTemp = itemCountTemp + itemCountInc;
                        itemTotalPriceTemp = itemTotalPriceTemp + itemTotalPriceInc;
                    }

                   /* cartItemCount.setText(itemCountTemp+" Items");
                    cartItemPrice.setText("Total: Rs. "+itemTotalPriceTemp+"/-");
                    this.itemCountForGrandTotal = itemCountTemp;*/


                }, throwable -> this.itemCountForGrandTotal = 0);//Log.d("error", "throwable erropr");
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }


}
