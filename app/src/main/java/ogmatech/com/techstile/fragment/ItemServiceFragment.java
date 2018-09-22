package ogmatech.com.techstile.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import ogmatech.com.techstile.api.service.StaticInfoService;
import ogmatech.com.techstile.controller.StaticInfoController;
import ogmatech.com.techstile.model.Item;
import ogmatech.com.techstile.model.ItemType;
import ogmatech.com.techstile.model.UserCartItem;
import ogmatech.com.techstile.wrapper.CartItemWrapper;
import ogmatech.com.techstile.wrapper.ItemTypeServiceWrapper;
import ogmatech.com.techstile.wrapper.ServiceSelectedWrapper;

public class ItemServiceFragment extends Fragment implements ItemServiceAdapter.ItemServiceChangeListner {

    RecyclerView recyclerView;
    ItemServiceAdapter itemServiceAdapter;

    private List<ServiceSelectedWrapper> serviceSelectedWrappers = new ArrayList<>();
    private List<ItemTypeServiceWrapper> itemTypeServiceWrappers = new ArrayList<>();

    private String displayItemTypeName;
    private String displayItemTypeImageLink;
    private Integer idItemType;
    private Integer idUserCartItem = 0;

    private Integer itemCountText = 1;
    private Integer itemPriceText = 0;

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
        itemServiceTotalPrice.setText("Rs. "+itemPriceText.toString()+"/-");

        itemCount = view.findViewById(R.id.txt_item_service_count);
        itemCount.setText(itemCountText.toString());

        itemTypeName = view.findViewById(R.id.toolbar_title);
        itemTypeName.setText(displayItemTypeName);

        itemTypeImageLink = view.findViewById(R.id.img_item_type);
        itemTypeImageDisplay(itemTypeImageLink, displayItemTypeImageLink);

        incrementItem = view.findViewById(R.id.btn_increase_item);
        incrementItem.setOnClickListener(v -> incrementItemCount());

        decrementItems = view.findViewById(R.id.btn_decrease_item);
        decrementItems.setOnClickListener(v -> decrementItemCount());

        saveItem = view.findViewById(R.id.btn_item_add_to_cart);
        saveItem.setText("Save Item Service");
        saveItem.setOnClickListener(v ->saveItemToCart());

        deleteAll = view.findViewById(R.id.btn_delete_all_service);
        deleteAll.setOnClickListener(v -> removeItemService());

        if(idUserCartItem != 0){
            CartItemService.getCartItemTypeCountService(this.idUserCartItem)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(t -> {itemCount.setText(t.getUserCartItemTypeCount().toString());
                    itemServiceTotalPrice.setText("Rs. "+t.getUserCartItemPrice().toString()+"/-");},
                            throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));

            saveItem.setText("Update Item Service");
            saveItem.setOnClickListener(v ->updateItemToCart());

        }

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
                .subscribe(t->{
                    itemTypeServiceWrappers.addAll(t);
                    itemServiceAdapter = new ItemServiceAdapter(getActivity(),t, this);
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

        if(status){
            ItemTypeServiceWrapper itemTypeServiceWrapper1 = itemTypeServiceWrappers.get(position);
            itemTypeServiceWrapper1.setSelected(true);
            itemTypeServiceWrapper1.setSelectedServicePrice(itemTypeServiceWrapper1.getServicePrice());
            itemTypeServiceWrappers.set(position, itemTypeServiceWrapper1);
        }
        else {
            ItemTypeServiceWrapper itemTypeServiceWrapper1 = itemTypeServiceWrappers.get(position);
            itemTypeServiceWrapper1.setSelected(false);
            itemTypeServiceWrapper1.setSelectedServicePrice(null);
            itemTypeServiceWrappers.set(position, itemTypeServiceWrapper1);
        }
        itemServiceAdapter.notifyDataSetChanged();

        String presentCountValue = itemCount.getText().toString();
        Integer presentCountValueInt = Integer.parseInt(presentCountValue);
        Integer priceAdd = 0;
        for (ItemTypeServiceWrapper itemTypeServiceWrapper : itemTypeServiceWrappers){
            if(itemTypeServiceWrapper.getSelectedServicePrice() != null){
                priceAdd = priceAdd + itemTypeServiceWrapper.getSelectedServicePrice();
            }
        }

        Integer presentPriceValueInt = presentCountValueInt * priceAdd;

        itemServiceTotalPrice.setText("Rs. "+presentPriceValueInt.toString()+"/-");

        itemPriceText = presentPriceValueInt;
        /*ItemServiceAdapter adapter = new ItemServiceAdapter(ItemTypeServiceWrapper);
        adapter.notifyDataSetChanged();*/

       //((ItemServiceAdapter) itemServiceView.getAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onTextEdited() {

    }

    private void incrementItemCount() {
        String presentCountValue = itemCount.getText().toString();
        Integer presentCountValueInt = Integer.parseInt(presentCountValue);
        presentCountValueInt++;
        itemCount.setText(presentCountValueInt.toString());

        Integer priceAdd = 0;
        for (ItemTypeServiceWrapper itemTypeServiceWrapper : itemTypeServiceWrappers){
            if(itemTypeServiceWrapper.getSelectedServicePrice() != null){
                priceAdd = priceAdd + itemTypeServiceWrapper.getSelectedServicePrice();
            }
        }

        Integer presentPriceValueInt = presentCountValueInt * priceAdd;

        itemServiceTotalPrice.setText("Rs. "+presentPriceValueInt.toString()+"/-");

        itemCountText = presentCountValueInt;
        itemPriceText = presentPriceValueInt;


    }

    private void decrementItemCount() {
        String presentCountValue = itemCount.getText().toString();
        Integer presentCountValueInt = Integer.parseInt(presentCountValue);
        if(presentCountValueInt > 1)
        {
            presentCountValueInt--;

            itemCount.setText(presentCountValueInt.toString());

            Integer priceAdd = 0;
            for (ItemTypeServiceWrapper itemTypeServiceWrapper : itemTypeServiceWrappers){
                if(itemTypeServiceWrapper.getSelectedServicePrice() != null){
                    priceAdd = priceAdd + itemTypeServiceWrapper.getSelectedServicePrice();
                }
            }

            Integer presentPriceValueInt = presentCountValueInt * priceAdd;

            itemServiceTotalPrice.setText("Rs. "+presentPriceValueInt.toString()+"/-");

            itemCountText = presentCountValueInt;
            itemPriceText = presentPriceValueInt;
        }

    }

    private void saveItemToCart() {

        /* Cart save */

        UserCartItem userCartItem = new UserCartItem();

        Integer userCartItemTypeCount = this.itemCountText;
        Integer userCartItemPrice = this.itemPriceText;
        ItemType itemType = new ItemType();

        List<ItemType> itemTypes = StaticInfoController.getInstance().getItemTypes();
        for (ItemType itemType1:itemTypes){
            if (itemType1.getIdItemType().equals(this.idItemType)){
                itemType = itemType1;
            }
        }

        userCartItem.setItemType(itemType);
        userCartItem.setUserCartItemPrice(userCartItemPrice);
        userCartItem.setUserCartItemTypeCount(userCartItemTypeCount);

        /* Service Save */

        List<ServiceSelectedWrapper> serviceSelectedWrappers = new ArrayList<>();

        for (ItemTypeServiceWrapper itemTypeServiceWrapper: itemTypeServiceWrappers){
            ServiceSelectedWrapper serviceSelectedWrapper = new ServiceSelectedWrapper();
            if(itemTypeServiceWrapper.isSelected() == true){
                serviceSelectedWrapper.setServiceId(itemTypeServiceWrapper.getIdItemService());
                serviceSelectedWrapper.setServicePrice(itemTypeServiceWrapper.getSelectedServicePrice());
                serviceSelectedWrappers.add(serviceSelectedWrapper);
            }
        }

        CartItemService.getUserCartItem(userCartItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {
                  CartItemService.getServiceSelectedWrappers(t.getIdUserCartItem(), serviceSelectedWrappers)
                          .subscribeOn(Schedulers.io())
                          .observeOn(AndroidSchedulers.mainThread())
                          .subscribe(r->{
                              getFragmentManager().popBackStack();
                              getFragmentManager().popBackStack();
                              Fragment frg;
                              frg = getActivity().getSupportFragmentManager().findFragmentByTag("CartItemFragment");
                              final FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                              ft.detach(frg);
                              ft.attach(frg);
                              ft.commit();
                          },
                                  throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));
                },
                        throwable -> Log.d("StatisInfooController1", "loadStaticInfo: 1"));



    }

    private void updateItemToCart() {

        /* Cart save */

        UserCartItem userCartItem = new UserCartItem();

        Integer userCartItemTypeCount = this.itemCountText;
        Integer userCartItemPrice = this.itemPriceText;

        userCartItem.setUserCartItemPrice(userCartItemPrice);
        userCartItem.setUserCartItemTypeCount(userCartItemTypeCount);

        /* Service Save */

        List<ServiceSelectedWrapper> serviceSelectedWrappers = new ArrayList<>();

        for (ItemTypeServiceWrapper itemTypeServiceWrapper: itemTypeServiceWrappers){
            ServiceSelectedWrapper serviceSelectedWrapper = new ServiceSelectedWrapper();
            if(itemTypeServiceWrapper.isSelected() == true){
                serviceSelectedWrapper.setServiceId(itemTypeServiceWrapper.getIdItemService());
                serviceSelectedWrapper.setServicePrice(itemTypeServiceWrapper.getSelectedServicePrice());
                serviceSelectedWrappers.add(serviceSelectedWrapper);
            }
        }

        CartItemService.putUserCartItem(idUserCartItem, userCartItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t -> {
                            CartItemService.getServiceSelectedWrappers(t.getIdUserCartItem(), serviceSelectedWrappers)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .subscribe(r -> {
                                                getFragmentManager().popBackStack();
                                                Fragment frg;
                                                frg = getActivity().getSupportFragmentManager().findFragmentByTag("CartItemFragment");
                                                final FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                                                ft.detach(frg);
                                                ft.attach(frg);
                                                ft.commit();
                                            },
                                            onError -> {
                                                Log.e("LoginFragment", onError.toString());
                                            });
                        },onError -> {
                    Log.e("LoginFragment", onError.toString());
                });

                                            /*throwable -> Log.d("StatisInfooController", "loadStaticInfo: "));
                        },
                        throwable -> Log.d("StatisInfooController1", "loadStaticInfo: 1"));*/

    }

    private void removeItemService() {

        CartItemService.deleteCartItem(idUserCartItem)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((() -> {
                    getFragmentManager().popBackStack();
                    Fragment frg;
                    frg = getActivity().getSupportFragmentManager().findFragmentByTag("CartItemFragment");
                    final FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.detach(frg);
                    ft.attach(frg);
                    ft.commit();
                }), onError-> {
                    Log.e("LoginFragment", onError.toString());
                });

    }

}
