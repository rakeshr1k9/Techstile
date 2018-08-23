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

public class AllOrderFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;

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

        String orderFilter = null;
        if (getArguments() != null) {
            orderFilter = getArguments().getString("orderFilter");
        }

        View view = inflater.inflate(R.layout.fragment_order_all, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        switch (orderFilter) {
            case "allOrder":
                getAllOrderList();
                break;

            case "ongoingOrder":
                getOngoingOrderList();
                break;

            case "completedOrder":
                getCompletedOrderList();
                break;

            case "quickOrder":
                getQuickOrderList();
                break;

            case "taggingOrder":
                getTaggingOrderList();
                break;

            case "cancelledOrder":
                getCancelledOrderList();
                break;

            case "deliveredOrder":
                getDeliveredOrderList();
                break;

            default:
                getAllOrderList();
                break;

        }



        return view;
    }

    private void getAllOrderList() {
        List<Integer> orderStatusId = new ArrayList<>();
        orderStatusId.add(1);
        orderStatusId.add(2);
        orderStatusId.add(3);
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

    private void getOngoingOrderList() {
        List<Integer> orderStatusId = new ArrayList<>();
        orderStatusId.add(2);
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

    private void getCompletedOrderList() {
        List<Integer> orderStatusId = new ArrayList<>();
        orderStatusId.add(3);
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

    private void getQuickOrderList() {
        List<Integer> orderStatusId = new ArrayList<>();
        orderStatusId.add(1);
        orderStatusId.add(2);
        orderStatusId.add(3);
        OrderService.getQuickOrders(orderStatusId)
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

    private void getTaggingOrderList() {
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

    private void getCancelledOrderList() {
        List<Integer> orderStatusId = new ArrayList<>();
        orderStatusId.add(5);
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

    private void getDeliveredOrderList() {
        List<Integer> orderStatusId = new ArrayList<>();
        orderStatusId.add(4);
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
