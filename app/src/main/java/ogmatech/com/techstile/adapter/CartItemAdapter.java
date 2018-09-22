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

import java.util.List;
import java.util.stream.Collectors;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.wrapper.CartItemWrapper;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {

    private Context context;
    private List<CartItemWrapper> cartItemWrappers;

    public interface CartItemClickListner{
        void onCartItemClicked(CartItemWrapper cartItemWrapper);
        void onItemDeleteClicked(Integer idUserCartItem);
    }

    private CartItemClickListner cartItemClickListner;

    public void setCartItemClickListner(CartItemClickListner cartItemClickListner) {
        this.cartItemClickListner = cartItemClickListner;
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder{
        private TextView userCartItemTypeCount, userCartItemPrice, itemTypeName, itemServices;
        private ImageView itemTypeImageLink, cartItemDelete;
        private CardView cartCardView;

        private CartItemViewHolder(View view){
            super(view);
            userCartItemTypeCount = view.findViewById(R.id.txt_cart_item_count);
            userCartItemPrice = view.findViewById(R.id.txt_cart_item_total_amount);
            itemTypeName = view.findViewById(R.id.txt_item_type_name);
            itemServices = view.findViewById(R.id.txt_item_service);
            itemTypeImageLink = view.findViewById(R.id.icon_cart_item_type);
            cartCardView = view.findViewById(R.id.cart_card_view);
            cartItemDelete = view.findViewById(R.id.img_btn_cart_item_close);
        }
    }

    public CartItemAdapter(Context context, List<CartItemWrapper> cartItemWrappers, CartItemClickListner cartItemClickListner) {
        this.context = context;
        this.cartItemWrappers = cartItemWrappers;
        this.cartItemClickListner = cartItemClickListner;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.card_cart_item, parent, false);
        return new CartItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartItemViewHolder holder, int position) {

        CartItemWrapper cartItemWrapper = cartItemWrappers.get(position);

        String uri;
        if(cartItemWrapper.getItemTypeImageLink() == null) {
            uri = "@drawable/a102pant";
        }
        else {
            String imgName = cartItemWrapper.getItemTypeImageLink();
            if(imgName.indexOf(".")>0)
            {
                imgName = imgName.substring(0, imgName.lastIndexOf("."));
            }
            uri = "@drawable/a"+imgName;
        }
        int imageResource = holder.itemView.getContext().getResources().getIdentifier(uri, null, holder.itemView.getContext().getPackageName());
        Drawable res = holder.itemView.getContext().getResources().getDrawable(imageResource);
        holder.itemTypeImageLink.setImageDrawable(res);

        holder.itemTypeName.setText(cartItemWrapper.getItemTypeName());

        String itemServiceList = "";
        for(String services : cartItemWrapper.getItemServices()){
            itemServiceList = itemServiceList+services+"\n";
        }
        holder.itemServices.setText(itemServiceList);

        holder.userCartItemTypeCount.setText(cartItemWrapper.getUserCartItemTypeCount().toString());
        holder.userCartItemPrice.setText(cartItemWrapper.getUserCartItemPrice().toString()+"/-");

        holder.cartItemDelete.setOnClickListener(v->cartItemClickListner.onItemDeleteClicked(cartItemWrapper.getIdUserCartItem()));

        holder.cartCardView.setOnClickListener(v -> cartItemClickListner.onCartItemClicked(cartItemWrapper));

    }

    @Override
    public int getItemCount() {
        return cartItemWrappers.size();
    }
}
