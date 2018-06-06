package ogmatech.com.techstile.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.OrderAdapter;
import ogmatech.com.techstile.model.Order;
import ogmatech.com.techstile.viewmodel.OrderViewModel;

public class AllOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;
    private List<Order> orderList;

    public AllOrderFragment() {
    }

    public static AllOrderFragment newInstance() {
        AllOrderFragment fragment = new AllOrderFragment();
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

        orderList = new ArrayList<>();
        orderAdapter = new OrderAdapter(getActivity(), orderList);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(orderAdapter);

        prepareOrder();

        return view;
    }

    private void prepareOrder() {
        Order order = new Order(52L, "25-02-2016", "26-03-2015", "5");
        orderList.add(order);

        order = new Order(52L, "25-02-2016", "26-03-2015", "5");
        orderList.add(order);

        order = new Order(52L, "25-02-2016", "26-03-2015", "5");
        orderList.add(order);

        order = new Order(52L, "25-02-2016", "26-03-2015", "5");
        orderList.add(order);

        order = new Order(52L, "25-02-2016", "26-03-2015", "5");
        orderList.add(order);

        order = new Order(52L, "25-02-2016", "26-03-2015", "5");
        orderList.add(order);

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
