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
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.CartItemAdapter;
import ogmatech.com.techstile.adapter.ItemServiceAdapter;
import ogmatech.com.techstile.adapter.ItemTypeAdapter;
import ogmatech.com.techstile.api.service.CartItemService;
import ogmatech.com.techstile.wrapper.CartItemWrapper;
import ogmatech.com.techstile.wrapper.ItemTypeServiceWrapper;
import ogmatech.com.techstile.wrapper.ServiceSelectedWrapper;

public class ItemServiceFragment extends Fragment implements ItemServiceAdapter.ItemServiceChangeListner {

    RecyclerView recyclerView;
    ItemServiceAdapter itemServiceAdapter;

    List<ServiceSelectedWrapper> serviceSelectedWrappers = new ArrayList<>();
    private List<ItemTypeServiceWrapper> itemTypeServiceWrappers = new ArrayList<>();

    private String displayItemTypeName;
    private String displayItemTypeImageLink;
    private Integer idItemType;
    private Integer idUserCartItem;

    private ImageView itemTypeImageLink, deleteAll;
    private TextView itemTypeName, itemServiceTotalPrice, itemCount;
    private Button incrementItem, decrementItems, saveItem;

    public ItemServiceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item_service, container, false);

      /*  if(idUserCartItem == null){
            getNewServiceApi();
        }
        else {
            getCartItemServiceApi(serviceSelectedWrappers);
        }*/

        itemServiceTotalPrice = view.findViewById(R.id.txt_item_service_total_price);
        itemServiceTotalPrice.setText("Total : Rs. 14220/-");

        itemCount = view.findViewById(R.id.txt_item_service_count);
        itemCount.setText("25");

        itemTypeName = view.findViewById(R.id.toolbar_title);
        itemTypeName.setText(displayItemTypeName);

        itemTypeImageLink = view.findViewById(R.id.img_item_type);
        itemTypeImageDisplay(itemTypeImageLink, displayItemTypeImageLink);

        incrementItem = view.findViewById(R.id.btn_increase_item);
        incrementItem.setOnClickListener(v -> incrementItemCount());

        decrementItems = view.findViewById(R.id.btn_decrease_item);
        decrementItems.setOnClickListener(v -> decrementItemCount());

        saveItem = view.findViewById(R.id.btn_item_add_to_cart);
        saveItem.setOnClickListener(v ->saveItemToCart());

        deleteAll = view.findViewById(R.id.btn_delete_all_service);
        deleteAll.setOnClickListener(v -> removeItemService());

        recyclerView = view.findViewById(R.id.recycler_view_item_service_select);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            String isComingFrom = bundle.getString("isComingFrom");
            if(isComingFrom == "ItemTypeClick") {
                displayItemTypeName = bundle.getString("itemTypeName");
                displayItemTypeImageLink = bundle.getString("itemTypeImageLink");
                idItemType = bundle.getInt("idItemType");
                getNewServiceApi();
            }
            if(isComingFrom == "CartItemClick"){
                displayItemTypeName = bundle.getString("itemTypeName");
                displayItemTypeImageLink = bundle.getString("itemTypeImageLink");
                idItemType = bundle.getInt("idItemType");
                idUserCartItem = bundle.getInt("idUserCartItem");

                /*CompositeDisposable compositeDisposable = new CompositeDisposable();
                Disposable disposable = */
                CartItemService.getCartItemTypeService(this.idUserCartItem)
                        .subscribeOn(Schedulers.io())
                       // .doOnSubscribe(disposable -> showProgress())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(t->{serviceSelectedWrappers.clear();
                            serviceSelectedWrappers.addAll(t);
                        //    dismissProgress();
                                getCartItemServiceApi(serviceSelectedWrappers);
                            });

               /* compositeDisposable.add(disposable); //IDE is satisfied that the Disposable is being managed.
                compositeDisposable.dispose();*/
            }

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

        CartItemService.getItemTypeService(this.idItemType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{itemServiceAdapter = new ItemServiceAdapter(getActivity(),t, this);
                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(itemServiceAdapter);
                });

    }

    private void getCartItemServiceApi(List<ServiceSelectedWrapper> serviceSelectedWrappers){

        CartItemService.getItemTypeService(this.idItemType)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{/*itemServiceAdapter = new ItemServiceAdapter(getActivity(),t,serviceSelectedWrappers, (ItemServiceAdapter.ItemServiceChangeListner) getActivity());
                    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(itemServiceAdapter);*/
                    itemTypeServiceWrappers.addAll(t);
                    CartItemService.getCartItemTypeService(this.idUserCartItem)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(r->{serviceSelectedWrappers.clear();
                                serviceSelectedWrappers.addAll(r);
                                List<ItemTypeServiceWrapper> itemTypeServiceWrappers = new ArrayList<>();
                                for (ItemTypeServiceWrapper itemTypeServiceWrapper : t){
                                    for (ServiceSelectedWrapper serviceSelectedWrapper : r){
                                        if(itemTypeServiceWrapper.getIdItemService().equals(serviceSelectedWrapper.getServiceId())){
                                            itemTypeServiceWrapper.setSelected(true);
                                            itemTypeServiceWrapper.setSelectedServicePrice(serviceSelectedWrapper.getServicePrice());
                                            itemTypeServiceWrappers.add(itemTypeServiceWrapper);
                                        }
                                    }
                                }

                                displayServices();
                            });
                });
    }

    private void displayServices() {
        itemServiceAdapter = new ItemServiceAdapter(getActivity(),itemTypeServiceWrappers, this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemServiceAdapter);
    }

    public void updatePrice(String price) {
        itemServiceTotalPrice.setText(price);
    }

    @Override
    public void onCheckboxChanged(Integer position, Boolean status) {
        itemServiceAdapter.notifyDataSetChanged();
        /*ItemServiceAdapter adapter = new ItemServiceAdapter(ItemTypeServiceWrapper);
        adapter.notifyDataSetChanged();*/

        //((ItemServiceAdapter) itemServiceView.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onTextEdited() {

    }

    private void incrementItemCount() {

    }

    private void decrementItemCount() {

    }

    private void saveItemToCart() {

    }

    private void updateItemToCart() {

    }

    private void removeItemService() {

    }

}
