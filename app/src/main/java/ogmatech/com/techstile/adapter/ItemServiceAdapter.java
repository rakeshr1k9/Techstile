package ogmatech.com.techstile.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.controller.NewOrderController;
import ogmatech.com.techstile.model.Item;
import ogmatech.com.techstile.model.ItemExtraServicePrice;
import ogmatech.com.techstile.model.ItemServicePrice;
import ogmatech.com.techstile.model.ItemType;
import ogmatech.com.techstile.wrapper.CartItemWrapper;
import ogmatech.com.techstile.wrapper.ItemTypeServiceWrapper;

public class ItemServiceAdapter extends RecyclerView.Adapter<ItemServiceAdapter.ItemServiceViewHolder> {

    private Context context;

    List<ItemTypeServiceWrapper> itemTypeServiceWrappers;

    class ItemServiceViewHolder extends RecyclerView.ViewHolder{

        ImageView serviceIcon;
        EditText itemServicePriceEdit;
        TextView itemServiceInfo;

        public ItemServiceViewHolder(View itemView) {
            super(itemView);
            serviceIcon = itemView.findViewById(R.id.icon_service);
            itemServiceInfo = itemView.findViewById(R.id.txt_item_service_info);
            itemServicePriceEdit = itemView.findViewById(R.id.edit_text_item_service_price);
        }
    }

    public ItemServiceAdapter(Context context, List<ItemTypeServiceWrapper> itemTypeServiceWrappers){
        this.context = context;
        this.itemTypeServiceWrappers = itemTypeServiceWrappers;
    }

    @NonNull
    @Override
    public ItemServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View itemServiceView = LayoutInflater.from(context)
                .inflate(R.layout.card_item_srvice, parent, false);

        return new ItemServiceViewHolder(itemServiceView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemServiceViewHolder holder, int position) {

        ItemTypeServiceWrapper itemTypeServiceWrapper = itemTypeServiceWrappers.get(position);

        String imgName = itemTypeServiceWrapper.getServiceImageLink();
        if(imgName.indexOf(".")>0)
        {
            imgName = imgName.substring(0, imgName.lastIndexOf("."));
        }
        String uri = "@drawable/"+imgName;
        int imageResource = holder.itemView.getContext().getResources().getIdentifier(uri, null, holder.itemView.getContext().getPackageName());
        Drawable res = holder.itemView.getContext().getResources().getDrawable(imageResource);
        holder.serviceIcon.setImageDrawable(res);

        String serviceInfo = itemTypeServiceWrapper.getServiceName() + " - (Rs. " + itemTypeServiceWrapper.getServicePrice().toString()+"/-)";
        holder.itemServiceInfo.setText(serviceInfo);

    }

    @Override
    public int getItemCount() {
        return itemTypeServiceWrappers.size();
    }
}
