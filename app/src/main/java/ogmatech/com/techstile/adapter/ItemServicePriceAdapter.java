package ogmatech.com.techstile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.controller.StaticInfoController;
import ogmatech.com.techstile.model.ItemServicePrice;
import ogmatech.com.techstile.model.ItemType;
import ogmatech.com.techstile.model.ItemTypeServicePrice;
import ogmatech.com.techstile.model.Service;

public class ItemServicePriceAdapter extends RecyclerView.Adapter<ItemServicePriceAdapter.ItemServicePriceViewHolder> {

    private List<ItemTypeServicePrice> itemTypeServicePrices;
    private List<Service> services;
    private List<ItemServicePrice> itemServicePrices;
    private int rowIndex = -1;

    public ItemServicePriceAdapter(Integer idItemType){

        List<ItemTypeServicePrice> itemTypeServicePrices = new ArrayList<>(StaticInfoController.getInstance().getItemTypeServicePriceHashMap().values());
        List<ItemTypeServicePrice> filterItemTypeServicePrice = itemTypeServicePrices.stream().filter(itemTypeServicePrice -> itemTypeServicePrice.getItemTypeId().equals(idItemType)).collect(Collectors.toList());

    }

    public void setRowIndex(int index) {
        rowIndex = index;
    }

    public class ItemServicePriceViewHolder extends RecyclerView.ViewHolder{

        ImageView serviceImage;
        TextView serviceName;
        TextView itemTypeServiceAmount;

        public ItemServicePriceViewHolder(View itemView) {
            super(itemView);
            serviceImage = itemView.findViewById(R.id.img_service_icon);
            serviceName = itemView.findViewById(R.id.txt_item_service_name);
            itemTypeServiceAmount = itemView.findViewById(R.id.txt_item_service_amount);
        }
    }

    @NonNull
    @Override
    public ItemServicePriceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View itemServicePriceView = LayoutInflater.from(context)
                .inflate(R.layout.row_item_extra_service_select, parent, false);

        return new ItemServicePriceViewHolder(itemServicePriceView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemServicePriceViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
