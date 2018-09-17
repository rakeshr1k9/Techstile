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

            switch (position){
                case 0:
                    bundle.putInt("categoryId",1);
                    AllItemTypeFragment allItemTypeFragment1 = new AllItemTypeFragment();
                    allItemTypeFragment1.setArguments(bundle);
                    return allItemTypeFragment1;
                case 1:
                    bundle.putInt("categoryId",2);
                    AllItemTypeFragment allItemTypeFragment2 = new AllItemTypeFragment();
                    allItemTypeFragment2.setArguments(bundle);
                    return allItemTypeFragment2;
                case 2:
                    bundle.putInt("categoryId",3);
                    AllItemTypeFragment allItemTypeFragment3 = new AllItemTypeFragment();
                    allItemTypeFragment3.setArguments(bundle);
                    return allItemTypeFragment3;
                case 3:
                    bundle.putInt("categoryId",4);
                    AllItemTypeFragment allItemTypeFragment4 = new AllItemTypeFragment();
                    allItemTypeFragment4.setArguments(bundle);
                    return allItemTypeFragment4;
                case 4:
                    bundle.putInt("categoryId",5);
                    AllItemTypeFragment allItemTypeFragment5 = new AllItemTypeFragment();
                    allItemTypeFragment5.setArguments(bundle);
                    return allItemTypeFragment5;
                case 5:
                    bundle.putInt("categoryId",6);
                    AllItemTypeFragment allItemTypeFragment6 = new AllItemTypeFragment();
                    allItemTypeFragment6.setArguments(bundle);
                    return allItemTypeFragment6;
                case 6:
                    bundle.putInt("categoryId",7);
                    AllItemTypeFragment allItemTypeFragment7 = new AllItemTypeFragment();
                    allItemTypeFragment7.setArguments(bundle);
                    return allItemTypeFragment7;
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return 7;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Men";
                case 1:
                    return "Women";
                case 2:
                    return "Silk";
                case 3:
                    return "Woolen";
                case 4:
                    return "Household";
                case 5:
                    return "Accessories";
                case 6:
                    return "Kids";
            }
            return null;
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
