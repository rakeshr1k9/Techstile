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

import ogmatech.com.techstile.OrderActivity;
import ogmatech.com.techstile.R;


public class ItemTypeFragment extends Fragment {

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
        ViewPager mViewPager = view.findViewById(R.id.item_type_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_item_category_list);
        tabLayout.setupWithViewPager(mViewPager);

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
                    bundle.putString("itemCategoryFilter","Men");
                    AllItemTypeFragment MenFragment = new AllItemTypeFragment();
                    MenFragment.setArguments(bundle);
                    return MenFragment;
                case 1:
                    bundle.putString("itemCategoryFilter","Women");
                    AllItemTypeFragment womenFragment = new AllItemTypeFragment();
                    womenFragment.setArguments(bundle);
                    return womenFragment;
                case 2:
                    bundle.putString("itemCategoryFilter","Silk");
                    AllItemTypeFragment silkFragment = new AllItemTypeFragment();
                    silkFragment.setArguments(bundle);
                    return silkFragment;
                case 3:
                    bundle.putString("itemCategoryFilter","Woolen");
                    AllItemTypeFragment woolenFragment = new AllItemTypeFragment();
                    woolenFragment.setArguments(bundle);
                    return woolenFragment;
                case 4:
                    bundle.putString("itemCategoryFilter","Household");
                    AllItemTypeFragment householdFragment = new AllItemTypeFragment();
                    householdFragment.setArguments(bundle);
                    return householdFragment;
                case 5:
                    bundle.putString("itemCategoryFilter","Accessories");
                    AllItemTypeFragment accessoriesFragment = new AllItemTypeFragment();
                    accessoriesFragment.setArguments(bundle);
                    return accessoriesFragment;
                case 6:
                    bundle.putString("itemCategoryFilter","Kids");
                    AllItemTypeFragment kidsFragment = new AllItemTypeFragment();
                    kidsFragment.setArguments(bundle);
                    return kidsFragment;
                default:
                    return OrderActivity.PlaceholderFragment.newInstance(position + 1);
            }
        }


        @Override
        public int getCount() {
            // Show 7 total pages.
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
