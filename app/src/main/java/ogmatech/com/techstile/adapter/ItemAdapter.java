package ogmatech.com.techstile.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.model.Item;
import ogmatech.com.techstile.model.ItemType;

//public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
public class ItemAdapter {
  /*  private ArrayList<ItemType> itemTypes;

    public interface ItemClickListener {
        void onItemClicked(Item item);
    }

    private ItemClickListener itemClickListener;

    public ItemAdapter(List<Item> itemList, ItemClickListener itemClickListener) {
        this.itemTypes = new ArrayList<>();
        this.itemClickListener = itemClickListener;
        this.itemTypes.addAll(itemTypes);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView thumbnail;
        CardView cardView;

        ItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemTypes.get(position);
        holder.title.setText(item.getItemName());
        holder.thumbnail.setImageResource(R.drawable.ic_cart);
        holder.cardView.setOnClickListener(v -> itemClickListener.onItemClicked(item));
    }

    @Override
    public int getItemCount() {
        return itemTypes.size();
    }
*/

}
