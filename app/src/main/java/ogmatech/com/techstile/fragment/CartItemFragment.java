package ogmatech.com.techstile.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.CartItemAdapter;
import ogmatech.com.techstile.api.service.CartItemService;
import ogmatech.com.techstile.wrapper.CartItemWrapper;

public class CartItemFragment extends Fragment {

    private RecyclerView recyclerView;
    private CartItemAdapter cartItemAdapter;

    private TextView itemCount, itemTotalPrice;
    private Integer itemCountForCheckout = 0;

    public CartItemFragment() {

    }

    public interface OnItemAddListener{
        void onAddItemClicked();
        void onCheckoutClicked(Integer itemCountForCheckout);
    }

    private OnItemAddListener onItemAddListener;

    public static CartItemFragment newInstance(OnItemAddListener onItemAddListener) {
        CartItemFragment fragment = new CartItemFragment();
        fragment.onItemAddListener = onItemAddListener;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart_items, container, false);

        itemCount = view.findViewById(R.id.txt_cart_total_item);

        itemTotalPrice = view.findViewById(R.id.txt_cart_total_item_price);

        Button addItem =  view.findViewById(R.id.button_cart_add_item);
        addItem.setOnClickListener(v -> onItemAddListener.onAddItemClicked());

        Button checkout = view.findViewById(R.id.button_cart_checkout);
        checkout.setOnClickListener(v -> onItemAddListener.onCheckoutClicked(itemCountForCheckout));

        recyclerView = view.findViewById(R.id.recycler_view_cart_item);

        getCartItemApi();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void getCartItemApi(){

        List<CartItemWrapper> cartItemWrappers = new ArrayList<>();

        CartItemService.getCartItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{cartItemAdapter = new CartItemAdapter(getActivity(),t,(CartItemAdapter.CartItemClickListner)getActivity());
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(cartItemAdapter);

                    Integer itemCountTemp=0;
                    Integer itemTotalPriceTemp=0;

                    for (CartItemWrapper cartItemWrapper : t){
                        Integer itemCountInc = cartItemWrapper.getUserCartItemTypeCount();
                        Integer itemTotalPriceInc = cartItemWrapper.getUserCartItemPrice();
                        itemCountTemp = itemCountTemp + itemCountInc;
                        itemTotalPriceTemp = itemTotalPriceTemp + itemTotalPriceInc;
                    }

                    itemCount.setText("Items: "+itemCountTemp);
                    itemTotalPrice.setText("Amount: "+itemTotalPriceTemp+"/-");
                    this.itemCountForCheckout = itemCountTemp;


                }, throwable -> this.itemCountForCheckout = 0);//Log.d("error", "throwable erropr");
    }
}

