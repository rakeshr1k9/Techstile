package ogmatech.com.techstile;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.adapter.OrderAdapter;
import ogmatech.com.techstile.api.service.OrderService;
import ogmatech.com.techstile.model.SearchString;

public class OrderSearchActivity extends BaseDrawerActivity {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent(getIntent());
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_order_search, null, false);
        drawer.addView(contentView, 0);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        getOrderList();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
        handleIntent(intent);
    }

    /**
     * Handling intent data
     */
    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);

            /**
             * Use this query to display search results like
             * 1. Getting the data from SQLite and showing in listview
             * 2. Making webrequest and displaying the data
             * For now we just display the query only
             */
            SearchString.setSearchOrder(query);
            getOrderList();
        }
        else {
            getOrderList();
        }
    }

    private void getOrderList() {
        OrderService.getSearchOrder(SearchString.getSearchOrder())
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_base_actions, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(getApplicationContext(), OrderSearchActivity.class)));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_cart:
                Intent intent2 = new Intent(this, OrderCreateActivity.class);
                startActivityForResult(intent2, 0);
                return true;
            case R.id.action_search:
                // location found
                return true;
            case R.id.action_qrcode:
                Intent intent = new Intent(this, BarcodeCaptureActivity.class);
                startActivityForResult(intent, 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0){
            if(requestCode == CommonStatusCodes.SUCCESS){
                if(data != null){
                    Barcode barcode = data.getParcelableExtra("barcode");
                    SearchString.setSearchOrder(barcode.displayValue);
                }
                else {
                    SearchString.setSearchOrder("");
                }
            }
        }
        Intent intent = new Intent(this, OrderSearchActivity.class);
        startActivity(intent);
    }
}
