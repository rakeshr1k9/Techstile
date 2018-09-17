package ogmatech.com.techstile;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.adapter.CartItemAdapter;
import ogmatech.com.techstile.adapter.ItemTypeAdapter;
import ogmatech.com.techstile.api.service.CartItemService;
import ogmatech.com.techstile.controller.NewOrderController;
import ogmatech.com.techstile.controller.StaticInfoController;
import ogmatech.com.techstile.fragment.CartItemFragment;
import ogmatech.com.techstile.fragment.ItemServiceFragment;
import ogmatech.com.techstile.fragment.ItemTypeFragment;
import ogmatech.com.techstile.model.Branch;
import ogmatech.com.techstile.model.Item;
import ogmatech.com.techstile.model.ItemStatus;
import ogmatech.com.techstile.model.ItemType;
import ogmatech.com.techstile.model.SearchString;

public class OrderCreateActivity extends BaseDrawerActivity implements CartItemFragment.OnItemAddListener,ItemTypeAdapter.ItemTypeClickListener, ItemServiceFragment.OnServiceAddListener, CartItemAdapter.CartItemClickListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addFragment(CartItemFragment.newInstance(this), "CartItemFragment");
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
    public boolean onPrepareOptionsMenu(Menu menu) {

            menu.removeItem(R.id.action_cart);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
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

    @Override
    public void onAddItemClicked() {
       addFragment(new ItemTypeFragment(), "ItemTypeFragment");

    }

   /* @Override
    public void onAddItemServiceClicked(Integer idItemType, int itemCount) {

        if(itemCount == -1){
            HashMap<Integer, ItemType> itemTypeHash = new HashMap<>(StaticInfoController.getInstance().getItemTypeHashMap());
            HashMap<Integer, ItemStatus> itemStatusHash = new HashMap<>(StaticInfoController.getInstance().getItemStatusHashMap());
            Branch branch = StaticInfoController.getInstance().getBranch();
            ItemStatus itemStatus = itemStatusHash.get(1);
            ItemType itemType = itemTypeHash.get(idItemType);

            Item item = new Item();
            item.setItemType(itemType);
            item.setBranch(branch);
            item.setItemStatus(itemStatus);

            List<Item> items = new ArrayList<>();
            items.add(item);

            NewOrderController newOrderController = new NewOrderController();
            newOrderController.getOrder().setItems(items);
        }
        else {

        }



    }
    */

    public void onItemTypeClicked(int position, ItemType itemType) {
        Bundle bundle = new Bundle();
        bundle.putString("itemTypeName", itemType.getItemTypeName());
        bundle.putString("itemTypeImageLink",itemType.getItemTypeImageLink());
        bundle.putInt("idItemType",itemType.getIdItemType());
        Fragment itemAddFragment = new ItemServiceFragment();
        itemAddFragment.setArguments(bundle);
        addFragment(itemAddFragment, "ItemServiceFragment");
    }


    @Override
    public void onCheckoutClicked() {
        Toast.makeText(this,"COB clicked", Toast.LENGTH_SHORT).show();
    }

   /* @Override
    public void onItemTypeClicked(int position) {
        Toast.makeText(this,"position is"+position, Toast.LENGTH_SHORT).show();
    }*/

    @Override
    public void onBackPressed() {
        if (getTopFragment() instanceof ItemServiceFragment) {
            getSupportFragmentManager().popBackStack();
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onCartItemClicked() {

    }

    @Override
    public void onItemDeleteClicked(Integer idUserCartItem) {

        /*CartItemFragment cartItemFragment = new CartItemFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(cartItemFragment).attach(cartItemFragment).commit();*/

        CartItemService.deleteCartItem(idUserCartItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((t -> {
                    Log.d("LoginFragment", "Number of movies received: " + t);
                }), onError-> {
                    Log.e("LoginFragment", onError.toString());
                });

        Fragment frg;
        frg = getSupportFragmentManager().findFragmentByTag("CartItemFragment");
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.detach(frg);
        ft.attach(frg);
        ft.commit();

    }

    @Override
    public void onItemIncrementClicked() {

    }

    @Override
    public void onServiceSaveClicked() {

    }

    @Override
    public void onItemDecrementClicked() {

    }

    @Override
    public void onDeleteAllServiceClicked() {

    }
}
