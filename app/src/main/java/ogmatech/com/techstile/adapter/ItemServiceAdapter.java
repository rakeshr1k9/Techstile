package ogmatech.com.techstile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class ItemServiceAdapter extends RecyclerView.Adapter<ItemServiceAdapter.ItemServiceViewHolder> {

    private ItemType itemType;
    private ArrayList<Item> items;
    private ArrayList<ItemServicePrice> itemServicePrices;

    ItemServiceAdapter(ItemType itemType){
        this.itemType = itemType;
    }

    public interface OnServiceAddListener{
        void onItemServiceAddClicked(int position, Item item);
    }

    private OnServiceAddListener onServiceAddListener;

    public void setOnServiceAddListener(OnServiceAddListener onServiceAddListener) {
        this.onServiceAddListener = onServiceAddListener;
    }

    class ItemServiceViewHolder extends RecyclerView.ViewHolder{

        TextView itemTotal;
        ImageView itemDelete;

        public ItemServiceViewHolder(View itemView) {
            super(itemView);
            itemTotal = itemView.findViewById(R.id.txt_item_total);
            itemDelete = itemView.findViewById(R.id.btn_item_delete);
        }
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

      /*  Item item = NewOrderController.getInstance().getOrder().getItems().get(position);

        holder.itemCountNumber.setText(position);
        holder.itemDelete.setImageResource(R.drawable.ic_close_black);
        holder.itemTotal.setText(item.getItemTotalAmount());
        holder.itemServiceAdd.setOnClickListener(v -> onServiceAddListener.onItemServiceAddClicked(position, item));*/

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
