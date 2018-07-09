package ogmatech.com.techstile;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.adapter.OrderAdapter;
import ogmatech.com.techstile.api.service.OrderService;

public class OrderSearchActivity extends BaseDrawerActivity {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_order_search, null, false);
        drawer.addView(contentView, 0);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        getOrderList();

    }

    private void getOrderList() {
        OrderService.getSearchOrder(SearchActivity.searchOrder)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(orderList1 -> {
                    Log.d("OrderListFragment",orderList1.toString());
                    orderAdapter = new OrderAdapter(this, orderList1);

                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(orderAdapter);
                }, onError -> {

                });
    }


}
