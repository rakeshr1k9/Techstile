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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.ItemServiceAdapter;
import ogmatech.com.techstile.api.service.StaticInfoService;
import ogmatech.com.techstile.controller.StaticInfoController;

public class ItemAddFragment extends Fragment {

    RecyclerView recyclerView;
    ItemServiceAdapter itemServiceAdapter;

    private String displayItemTypeName;
    private String displayItemTypeImageLink;
    private Integer idItemType;

    public ItemAddFragment() {
        // Required empty public constructor
    }

    public interface OnClickButtonListener{
        void onAddItemServiceClicked(Integer idItemType);
        void onClearItemsClicked();
        void onAddToCartClicked();
    }

    private OnClickButtonListener onClickButtonListner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_add, container, false);

        TextView itemTypeName = view.findViewById(R.id.toolbar_title);
        itemTypeName.setText(displayItemTypeName);

        ImageView itemTypeImageLink = view.findViewById(R.id.img_item_type);
        itemTypeImageDisplay(itemTypeImageLink, displayItemTypeImageLink);

        Button addItem = view.findViewById(R.id.btn_increase_item);
        addItem.setOnClickListener(v -> onClickButtonListner.onAddItemServiceClicked(idItemType));

        Button clearItems = view.findViewById(R.id.btn_item_delete_all);
        clearItems.setOnClickListener(v -> onClickButtonListner.onClearItemsClicked());

        Button addToCart = view.findViewById(R.id.btn_item_add_to_cart);
        addToCart.setOnClickListener(v -> onClickButtonListner.onAddToCartClicked());

        recyclerView = view.findViewById(R.id.recycler_view_item_add);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemServiceAdapter);
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

}
