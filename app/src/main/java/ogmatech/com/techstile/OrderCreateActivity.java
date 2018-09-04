package ogmatech.com.techstile;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import ogmatech.com.techstile.adapter.ItemTypeAdapter;
import ogmatech.com.techstile.fragment.AllItemTypeFragment;
import ogmatech.com.techstile.fragment.CartItemFragment;
import ogmatech.com.techstile.fragment.ItemAddFragment;
import ogmatech.com.techstile.fragment.ItemTypeFragment;
import ogmatech.com.techstile.model.ItemType;
import ogmatech.com.techstile.model.SearchString;

public class OrderCreateActivity extends BaseDrawerActivity implements CartItemFragment.OnItemAddListener,ItemTypeAdapter.ItemTypeClickListener, ItemAddFragment.OnClickButtonListener {

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

    @Override
    public void onAddItemServiceClicked() {

    }

    @Override
    public void onClearItemsClicked() {

    }

    @Override
    public void onAddToCartClicked() {

    }

    public void onItemTypeClicked(int position, ItemType itemType) {
        Bundle bundle = new Bundle();
        bundle.putString("itemTypeName", itemType.getItemTypeName());
        bundle.putString("itemTypeImageLink",itemType.getItemTypeImageLink());
        bundle.putInt("idItemType",itemType.getIdItemType());
        Fragment itemAddFragment = new ItemAddFragment();
        itemAddFragment.setArguments(bundle);
        addFragment(itemAddFragment, "ItemAddFragment");
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
        if (getTopFragment() instanceof ItemAddFragment) {
            getSupportFragmentManager().popBackStack();
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
