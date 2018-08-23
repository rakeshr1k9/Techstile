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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.OrderAdapter;
import ogmatech.com.techstile.api.service.OrderService;
import ogmatech.com.techstile.viewmodel.OrderViewModel;

public class TaggingOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;

    public TaggingOrderFragment() {
    }

    public static TaggingOrderFragment newInstance() {
        TaggingOrderFragment fragment = new TaggingOrderFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order_all, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        getOrderList();

        return view;
    }

    private void getOrderList() {
        List<Integer> orderStatusId = new ArrayList<>();
        orderStatusId.add(1);
        OrderService.getActiveOrders(orderStatusId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(orderList1 -> {
                    Log.d("OrderListFragment",orderList1.toString());
                    orderAdapter = new OrderAdapter(getActivity(), orderList1);

                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(orderAdapter);
                }, onError -> {
                    Toast.makeText(getContext(), onError.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                });
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
