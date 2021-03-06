package ogmatech.com.techstile;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.vision.barcode.Barcode;

import ogmatech.com.techstile.fragment.AllOrderFragment;
import ogmatech.com.techstile.model.SearchString;

public class OrderActivity extends BaseDrawerActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.activity_order, null, false);
        drawer.addView(contentView, 0);

        // Create the adapter that will return a fragment for each of the Five
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.order_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_order_list);
        tabLayout.setupWithViewPager(mViewPager);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

    }

    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_order_all, container, false);
            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
           // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            Bundle bundle = new Bundle();

            switch (position){
                case 0:
                    bundle.putString("orderFilter","allOrder");
                    AllOrderFragment allOrderFragment = new AllOrderFragment();
                    allOrderFragment.setArguments(bundle);
                    return allOrderFragment;
                case 1:
                    bundle.putString("orderFilter","ongoingOrder");
                    AllOrderFragment ongoingOrderFragment = new AllOrderFragment();
                    ongoingOrderFragment.setArguments(bundle);
                    return ongoingOrderFragment;
                case 2:
                    bundle.putString("orderFilter","completedOrder");
                    AllOrderFragment completedOrderFragment = new AllOrderFragment();
                    completedOrderFragment.setArguments(bundle);
                    return completedOrderFragment;
                case 3:
                    bundle.putString("orderFilter","quickOrder");
                    AllOrderFragment quickOrderFragment = new AllOrderFragment();
                    quickOrderFragment.setArguments(bundle);
                    return quickOrderFragment;
                case 4:
                    bundle.putString("orderFilter","taggingOrder");
                    AllOrderFragment taggingOrderFragment = new AllOrderFragment();
                    taggingOrderFragment.setArguments(bundle);
                    return taggingOrderFragment;
                    default:
                        return PlaceholderFragment.newInstance(position + 1);
            }
        }

        
        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "All";
                case 1:
                    return "Ongoing";
                case 2:
                    return "Completed";
                case 3:
                    return "Quick";
                case 4:
                    return "Tagging";
            }
            return null;
        }
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
