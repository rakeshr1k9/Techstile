package ogmatech.com.techstile.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ogmatech.com.techstile.R;

public class CartItemFragment extends Fragment {

    public CartItemFragment() {

    }

    public interface OnItemAddListener{
        void onAddItemClicked();
        void onCheckoutClicked();
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart_items, container, false);

           Button addItem =  view.findViewById(R.id.button_cart_add_item);
        addItem.setOnClickListener((View view1) -> onItemAddListener.onAddItemClicked());

        Button checkout = view.findViewById(R.id.button_cart_checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemAddListener.onCheckoutClicked();
            }
        });

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

}

