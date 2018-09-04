package ogmatech.com.techstile.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ogmatech.com.techstile.OrderActivity;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.controller.StaticInfoController;
import ogmatech.com.techstile.model.ItemCategory;


public class ItemTypeFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabLayout;

    List<ItemCategory> itemCategories = new ArrayList<>(StaticInfoController.getInstance().getItemCategoryHashMap().values());

    public ItemTypeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_item_type, container, false);

        // Create the adapter that will return a fragment for each of the Five
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        // Set up the ViewPager with the sections adapter.
        viewPager = view.findViewById(R.id.item_type_container);
        viewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = view.findViewById(R.id.tab_item_category_list);
        tabLayout.setupWithViewPager(viewPager);

       // getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        return view;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            Bundle bundle = new Bundle();
            bundle.putInt("categoryId",itemCategories.get(position).getIdItemCategory());
            AllItemTypeFragment allItemTypeFragment = new AllItemTypeFragment();
            allItemTypeFragment.setArguments(bundle);
            return allItemTypeFragment;
        }

        @Override
        public int getCount() {
            return itemCategories == null ? 0 : itemCategories.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String tabTitle = itemCategories.get(position).getItemCategoryName();
            return tabTitle;
        }
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
