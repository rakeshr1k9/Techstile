package ogmatech.com.techstile.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.ItemServiceAdapter;

public class ItemAddFragment extends Fragment {

    RecyclerView recyclerView;
    ItemServiceAdapter itemServiceAdapter;


    public ItemAddFragment() {
        // Required empty public constructor
    }

    public interface OnClickButtonListener{
        void onAddItemServiceClicked();
        void onClearItemsClicked();
        void onAddToCartClicked();
    }

    private OnClickButtonListener onClickButtonListner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_add, container, false);

        Button addItem = view.findViewById(R.id.btn_increase_item);
        addItem.setOnClickListener(v -> onClickButtonListner.onAddItemServiceClicked());

        Button clearItems = view.findViewById(R.id.btn_item_delete_all);
        clearItems.setOnClickListener(v -> onClickButtonListner.onClearItemsClicked());

        Button addToCart = view.findViewById(R.id.btn_item_add_to_cart);
        addToCart.setOnClickListener(v -> onClickButtonListner.onAddToCartClicked());

        recyclerView = view.findViewById(R.id.recycler_view_item_add);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemServiceAdapter);
        return view;
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
