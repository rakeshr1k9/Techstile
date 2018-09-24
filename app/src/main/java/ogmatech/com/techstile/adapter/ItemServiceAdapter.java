package ogmatech.com.techstile.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.wrapper.ItemTypeServiceWrapper;

public class ItemServiceAdapter extends RecyclerView.Adapter<ItemServiceAdapter.ItemServiceViewHolder> {

    private Context context;
    private List<ItemTypeServiceWrapper> itemTypeServiceWrappers;

    public interface ItemServiceChangeListner{
        void onCheckboxChanged(Integer position, Boolean status);
        void onTextEdited();
    }

    private ItemServiceChangeListner itemServiceChangeListner;

    public void setItemServiceChangeListner(ItemServiceChangeListner itemServiceChangeListner) {
        this.itemServiceChangeListner = itemServiceChangeListner;
    }

    class ItemServiceViewHolder extends RecyclerView.ViewHolder{

        ImageView serviceIcon;
        TextView itemServicePriceEdit;
        TextView itemServiceInfo;
        CheckBox itemServiceCheckbox;

        public ItemServiceViewHolder(View itemView) {
            super(itemView);
            serviceIcon = itemView.findViewById(R.id.icon_service);
            itemServiceInfo = itemView.findViewById(R.id.txt_item_service_info);
            itemServicePriceEdit = itemView.findViewById(R.id.edit_text_item_service_price);
            itemServiceCheckbox = itemView.findViewById(R.id.check_box_item_service);
        }
    }

    public ItemServiceAdapter(Context context, List<ItemTypeServiceWrapper> itemTypeServiceWrappers, ItemServiceChangeListner itemServiceChangeListner){
        this.context = context;
        this.itemTypeServiceWrappers = itemTypeServiceWrappers;
        this.itemServiceChangeListner = itemServiceChangeListner;
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

        String serviceInfo = itemTypeServiceWrapper.getServiceName() + " - (Rs. " + itemTypeServiceWrapper.getServicePrice().toString()+"/-)";
        holder.itemServiceInfo.setText(serviceInfo);

        String imgName = itemTypeServiceWrapper.getServiceImageLink();



        if(itemTypeServiceWrapper.isSelected()){

            imgName = "z" + imgName;
            if(imgName.indexOf(".")>0)
            {
                imgName = imgName.substring(0, imgName.lastIndexOf("."));
            }
            String uri = "@drawable/"+imgName;
            int imageResource = holder.itemView.getContext().getResources().getIdentifier(uri, null, holder.itemView.getContext().getPackageName());
            Drawable res = holder.itemView.getContext().getResources().getDrawable(imageResource);
            holder.serviceIcon.setImageDrawable(res);

            holder.itemServicePriceEdit.setVisibility(View.VISIBLE);
            holder.itemServicePriceEdit.setText(itemTypeServiceWrapper.getSelectedServicePrice().toString());

            holder.itemServiceCheckbox.setChecked(true);
            holder.itemServiceCheckbox.setOnClickListener(v->itemServiceChangeListner.onCheckboxChanged(position, false));

        }
        else {

            if(imgName.indexOf(".")>0)
            {
                imgName = imgName.substring(0, imgName.lastIndexOf("."));
            }
            String uri = "@drawable/"+imgName;
            int imageResource = holder.itemView.getContext().getResources().getIdentifier(uri, null, holder.itemView.getContext().getPackageName());
            Drawable res = holder.itemView.getContext().getResources().getDrawable(imageResource);
            holder.serviceIcon.setImageDrawable(res);

            holder.itemServicePriceEdit.setVisibility(View.GONE);

            holder.itemServiceCheckbox.setChecked(false);
            holder.itemServiceCheckbox.setOnClickListener(v->itemServiceChangeListner.onCheckboxChanged(position, true));

        }

    }

    @Override
    public int getItemCount() {
        return itemTypeServiceWrappers.size();
    }
}
