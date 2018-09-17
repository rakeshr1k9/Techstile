package ogmatech.com.techstile.fragment;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.CartItemAdapter;
import ogmatech.com.techstile.adapter.ItemTypeAdapter;
import ogmatech.com.techstile.api.service.CartItemService;
import ogmatech.com.techstile.api.service.StaticInfoService;
import ogmatech.com.techstile.controller.StaticInfoController;
import ogmatech.com.techstile.model.ItemType;
import ogmatech.com.techstile.wrapper.CartItemWrapper;

public class AllItemTypeFragment extends Fragment {

    RecyclerView recyclerView;
    ItemTypeAdapter itemTypeAdapter;

    private Integer categoryId;

    public AllItemTypeFragment() {

    }

    public static AllItemTypeFragment newInstance() {
        AllItemTypeFragment fragment = new AllItemTypeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_all_item_type, container, false);

        if (getArguments() != null) {
            categoryId = getArguments().getInt("categoryId");
        }

        recyclerView = view.findViewById(R.id.recycler_view_item_type);

        getItemTypeList(categoryId);
        itemTypeAdapter = new ItemTypeAdapter(getItemTypeList(categoryId),(ItemTypeAdapter.ItemTypeClickListener) getActivity());

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

    private List<ItemType> getItemTypeList(Integer categoryId){

        /*StaticInfoService.getItemType(categoryId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{itemTypeAdapter = new ItemTypeAdapter(t,(ItemTypeAdapter.ItemTypeClickListener) getActivity());
                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 3);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(4), true));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(itemTypeAdapter);
                });*/


        List<ItemType> itemTypes = new ArrayList<>(StaticInfoController.getInstance().getItemTypeHashMap().values());
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
}
