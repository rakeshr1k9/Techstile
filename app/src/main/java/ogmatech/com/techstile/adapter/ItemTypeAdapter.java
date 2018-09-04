package ogmatech.com.techstile.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import ogmatech.com.techstile.model.ItemType;

public class ItemTypeAdapter extends RecyclerView.Adapter<ItemTypeAdapter.ItemTypeViewHolder>{

    private ArrayList<ItemType> itemTypes;

    public interface ItemTypeClickListener {
        void onItemTypeClicked(int position, ItemType itemType);
    }

    private ItemTypeClickListener itemTypeClickListener;

    public void setItemTypeClickListener(ItemTypeClickListener itemTypeClickListener) {
        this.itemTypeClickListener = itemTypeClickListener;
    }

    public ItemTypeAdapter(List<ItemType> itemTypes, ItemTypeClickListener itemTypeClickListener) {
        this.itemTypes = new ArrayList<>();
        this.itemTypeClickListener = itemTypeClickListener;
        this.itemTypes.addAll(itemTypes);
    }

    class ItemTypeViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView thumbnail;
        CardView cardView;

        ItemTypeViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }

    @NonNull
    @Override
    public ItemTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View itemTypeView = LayoutInflater.from(context)
                .inflate(R.layout.card_item, parent, false);

        return new ItemTypeViewHolder(itemTypeView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemTypeViewHolder holder, int position) {
        ItemType itemType = itemTypes.get(position);
        holder.title.setText(itemType.getItemTypeName());

        String uri;

        if(itemType.getItemTypeImageLink() == null) {
            uri = "@drawable/a102pant";
        }
        else {
            String imgName = itemType.getItemTypeImageLink();
            if(imgName.indexOf(".")>0)
            {
                imgName = imgName.substring(0, imgName.lastIndexOf("."));
            }
            uri = "@drawable/a"+imgName;
        }
        int imageResource = holder.itemView.getContext().getResources().getIdentifier(uri, null, holder.itemView.getContext().getPackageName());
        Drawable res = holder.itemView.getContext().getResources().getDrawable(imageResource);
        holder.thumbnail.setImageDrawable(res);
        holder.cardView.setOnClickListener(v -> itemTypeClickListener.onItemTypeClicked(position, itemType));

    }

    @Override
    public int getItemCount() {
        return itemTypes.size();
    }

}
