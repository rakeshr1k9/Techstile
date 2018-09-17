package ogmatech.com.techstile.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.CartItemAdapter;
import ogmatech.com.techstile.adapter.ItemServiceAdapter;
import ogmatech.com.techstile.api.service.CartItemService;
import ogmatech.com.techstile.wrapper.CartItemWrapper;
import ogmatech.com.techstile.wrapper.ItemTypeServiceWrapper;

public class ItemServiceFragment extends Fragment {

    RecyclerView recyclerView;
    ItemServiceAdapter itemServiceAdapter;

    private String displayItemTypeName;
    private String displayItemTypeImageLink;
    private Integer idItemType;

    private ImageView itemTypeImageLink, deleteAll;
    private TextView itemTypeName, itemServiceTotalPrice, itemCount;
    private Button incrementItem, decrementItems, saveItem;

    public ItemServiceFragment() {
        // Required empty public constructor
    }

    public interface OnServiceAddListener{
        void onItemIncrementClicked();
        void onServiceSaveClicked();
        void onItemDecrementClicked();
        void onDeleteAllServiceClicked();
    }

    public OnServiceAddListener onServiceAddListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_service, container, false);

        getNewServiceApi();

        itemServiceTotalPrice = view.findViewById(R.id.txt_item_service_total_price);
        itemServiceTotalPrice.setText("Total : Rs. 14220/-");

        itemCount = view.findViewById(R.id.txt_item_service_count);
        itemCount.setText("25");

        itemTypeName = view.findViewById(R.id.toolbar_title);
        itemTypeName.setText("Select "+displayItemTypeName+" Service");

        itemTypeImageLink = view.findViewById(R.id.img_item_type);
        itemTypeImageDisplay(itemTypeImageLink, displayItemTypeImageLink);

        incrementItem = view.findViewById(R.id.btn_increase_item);
        incrementItem.setOnClickListener(v -> onServiceAddListener.onItemIncrementClicked());

        decrementItems = view.findViewById(R.id.btn_decrease_item);
        decrementItems.setOnClickListener(v -> onServiceAddListener.onItemDecrementClicked());

        saveItem = view.findViewById(R.id.btn_item_add_to_cart);
        saveItem.setOnClickListener(v -> onServiceAddListener.onServiceSaveClicked());

        deleteAll = view.findViewById(R.id.btn_delete_all_service);
        deleteAll.setOnClickListener(v -> onServiceAddListener.onDeleteAllServiceClicked());

        recyclerView = view.findViewById(R.id.recycler_view_item_service_select);


        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            displayItemTypeName = bundle.getString("itemTypeName");
            displayItemTypeImageLink = bundle.getString("itemTypeImageLink");
            idItemType = bundle.getInt("idItemType");
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

    private void itemTypeImageDisplay(ImageView itemTypeImageLink, String displayItemTypeImageLink) {
        String uri;

        if(displayItemTypeImageLink == null) {
            uri = "@drawable/a102pant";
        }
        else {
            String imgName = displayItemTypeImageLink;
            if(imgName.indexOf(".")>0)
            {
                imgName = imgName.substring(0, imgName.lastIndexOf("."));
            }
            uri = "@drawable/a"+imgName;
        }

        int imageResource = getContext().getResources().getIdentifier(uri, null, getContext().getPackageName());
        Drawable res = getContext().getResources().getDrawable(imageResource);
        itemTypeImageLink.setImageDrawable(res);
    }

    private void getNewServiceApi(){

        List<ItemTypeServiceWrapper> itemTypeServiceWrappers = new ArrayList<>();

        CartItemService.getItemTypeService(this.idItemType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{itemServiceAdapter = new ItemServiceAdapter(getActivity(),t);
                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(itemServiceAdapter);
                });

    }

}
