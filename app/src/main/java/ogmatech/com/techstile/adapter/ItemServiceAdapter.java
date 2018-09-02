package ogmatech.com.techstile.adapter;

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
    private ArrayList<ItemExtraServicePrice> itemExtraServicePrices;

    ItemServiceAdapter(ItemType itemType){
        this.itemType = itemType;

    }

    public interface OnServiceAddListener{
        void onItemServiceAddClicked(int position, Item item);
        void onItemExtraServiceAddClicked(int position, Item item);
    }

    private OnServiceAddListener onServiceAddListener;

    public void setOnServiceAddListener(OnServiceAddListener onServiceAddListener) {
        this.onServiceAddListener = onServiceAddListener;
    }

    class ItemServiceViewHolder extends RecyclerView.ViewHolder{

        TextView itemCountNumber;
        TextView itemTotal;
        Button itemServiceAdd;
        Button itemExtraServiceAdd;
        ImageView itemDelete;
        ListView listViewItemService;
        ListView listViewExtraService;

        public ItemServiceViewHolder(View itemView) {
            super(itemView);
            itemCountNumber = itemView.findViewById(R.id.item_count_number);
            itemTotal = itemView.findViewById(R.id.txt_item_total);
            itemServiceAdd = itemView.findViewById(R.id.btn_item_service_add);
            itemExtraServiceAdd = itemView.findViewById(R.id.btn_item_extra_service_add);
            itemDelete = itemView.findViewById(R.id.btn_item_delete);
            listViewItemService = itemView.findViewById(R.id.list_view_item_service);
            listViewExtraService = itemView.findViewById(R.id.list_view_extra_service);
        }
    }

    @NonNull
    @Override
    public ItemServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemServiceView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_srvice, parent, false);

        return new ItemServiceViewHolder(itemServiceView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemServiceViewHolder holder, int position) {

      /*  Item item = NewOrderController.getInstance().getOrder().getItems().get(position);

        holder.itemCountNumber.setText(position);
        holder.itemDelete.setImageResource(R.drawable.ic_close_black);
        holder.itemTotal.setText(item.getItemTotalAmount());
        holder.itemServiceAdd.setOnClickListener(v -> onServiceAddListener.onItemServiceAddClicked(position, item));
        holder.itemExtraServiceAdd.setOnClickListener(v -> onServiceAddListener.onItemExtraServiceAddClicked(position, item));*/

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
