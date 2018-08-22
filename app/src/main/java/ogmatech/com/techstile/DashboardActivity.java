package ogmatech.com.techstile;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import ogmatech.com.techstile.model.SearchString;

public class DashboardActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_dashboard, null, false);
        drawer.addView(contentView, 0);
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
                startActivity(intent2);
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
                    Intent intent = new Intent(this, OrderSearchActivity.class);
                    startActivity(intent);
                }
                else {
                    SearchString.setSearchOrder("");
                    Intent intent = new Intent(this, OrderSearchActivity.class);
                    startActivity(intent);
                }
            }
        }

    }
}
