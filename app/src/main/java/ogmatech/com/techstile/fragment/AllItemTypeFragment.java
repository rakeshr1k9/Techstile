package ogmatech.com.techstile.fragment;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.Observable;
import io.reactivex.Single;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.ItemTypeAdapter;
import ogmatech.com.techstile.controller.NewOrderController;
import ogmatech.com.techstile.controller.StaticInfoController;
import ogmatech.com.techstile.model.Item;
import ogmatech.com.techstile.model.ItemType;

public class AllItemTypeFragment extends Fragment {

    RecyclerView recyclerView;
    ItemTypeAdapter itemTypeAdapter;

    public AllItemTypeFragment() {
        // Required empty public constructor
    }

    public static AllItemTypeFragment newInstance() {
        AllItemTypeFragment fragment = new AllItemTypeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_item_type, container, false);

        String itemCategoryFilter = null;
        if (getArguments() != null) {
            itemCategoryFilter = getArguments().getString("itemCategoryFilter");
        }

        switch (itemCategoryFilter) {

            case "Men":
                itemTypeAdapter = new ItemTypeAdapter(getMenList(),(ItemTypeAdapter.ItemTypeClickListener) getActivity());
                break;

            case "Women":
                itemTypeAdapter = new ItemTypeAdapter(getWomenList(),(ItemTypeAdapter.ItemTypeClickListener) getActivity());
                break;

            case "Silk":
                itemTypeAdapter = new ItemTypeAdapter(getSilkList(),(ItemTypeAdapter.ItemTypeClickListener) getActivity());
                break;

            case "Woolen":
                itemTypeAdapter = new ItemTypeAdapter(getWoolenList(),(ItemTypeAdapter.ItemTypeClickListener) getActivity());
                break;

            case "Household":
                itemTypeAdapter = new ItemTypeAdapter(getHouseholdList(),(ItemTypeAdapter.ItemTypeClickListener) getActivity());
                break;

            case "Accessories":
                itemTypeAdapter = new ItemTypeAdapter(getAccessoriesList(),(ItemTypeAdapter.ItemTypeClickListener) getActivity());
                break;

            case "Kids":
                itemTypeAdapter = new ItemTypeAdapter(getKidsList(),(ItemTypeAdapter.ItemTypeClickListener) getActivity());
                break;
        }



        recyclerView = view.findViewById(R.id.recycler_view_item_type);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemTypeAdapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /*
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }




    /*
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }



    private List<ItemType> getMenList() {
        List<ItemType> itemTypes = StaticInfoController.getInstance().getItemTypes();
        Integer categoryId = 1;
        List<ItemType> filtered = itemTypes.stream().filter(itemType -> itemType.getItemCategoryId().equals(categoryId) ).collect(Collectors.toList());
        return filtered;
    }

    private List<ItemType> getWomenList() {
        List<ItemType> itemTypes = StaticInfoController.getInstance().getItemTypes();
        Integer categoryId = 2;
        List<ItemType> filtered = itemTypes.stream().filter(itemType -> itemType.getItemCategoryId().equals(categoryId) ).collect(Collectors.toList());
        return filtered;
    }

    private List<ItemType> getSilkList() {
        List<ItemType> itemTypes = StaticInfoController.getInstance().getItemTypes();
        Integer categoryId = 3;
        List<ItemType> filtered = new ArrayList<>();
        Observable
                .fromIterable(itemTypes)
                .filter(itemType -> {
                    return itemType.getItemCategoryId().equals(categoryId);
                })
                .toList()
                .subscribe(itemTypes1 -> {
                    filtered.addAll(itemTypes1);
                });
       // List<ItemType> filtered = itemTypes.stream().filter(itemType -> itemType.getItemCategoryId().equals(categoryId) ).collect(Collectors.toList());
        return filtered;
    }

    private List<ItemType> getWoolenList() {
        List<ItemType> itemTypes = StaticInfoController.getInstance().getItemTypes();
        Integer categoryId = 4;
        List<ItemType> filtered = itemTypes.stream().filter(itemType -> itemType.getItemCategoryId().equals(categoryId) ).collect(Collectors.toList());
        return filtered;
    }

    private List<ItemType> getHouseholdList() {
        List<ItemType> itemTypes = StaticInfoController.getInstance().getItemTypes();
        Integer categoryId = 5;
        List<ItemType> filtered = itemTypes.stream().filter(itemType -> itemType.getItemCategoryId().equals(categoryId) ).collect(Collectors.toList());
        return filtered;
    }

    private List<ItemType> getAccessoriesList() {
        List<ItemType> itemTypes = StaticInfoController.getInstance().getItemTypes();
        Integer categoryId = 6;
        List<ItemType> filtered = itemTypes.stream().filter(itemType -> itemType.getItemCategoryId().equals(categoryId) ).collect(Collectors.toList());
        return filtered;
    }

    private List<ItemType> getKidsList() {
        List<ItemType> itemTypes = StaticInfoController.getInstance().getItemTypes();
        Integer categoryId = 7;
        List<ItemType> filtered = itemTypes.stream().filter(itemType -> itemType.getItemCategoryId().equals(categoryId) ).collect(Collectors.toList());
        return filtered;
    }



   /* public void onItemTypeClicked(int position, ItemType itemType) {
        Bundle bundle = new Bundle();
        bundle.putString("itemTypeId",itemType.getIdItemType().toString());

        Fragment itemAddFragment = new ItemAddFragment();
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

        itemAddFragment.setArguments(bundle);

        transaction.replace(R.id.fragment_holder, itemAddFragment);

        transaction.commit();


    }*/

   /* @Override
    public void onItemTypeClicked(ItemType itemType) {
        // NewOrderController.getInstance().clearInstance();

        Item item = new Item();
        item.setItemType(itemType);
    }*/

}
