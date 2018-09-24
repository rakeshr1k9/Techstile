package ogmatech.com.techstile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.wrapper.CartItemWrapper;

public class CheckoutCartItemAdapter extends RecyclerView.Adapter<CheckoutCartItemAdapter.CheckoutCartItemViewHolder> {

    private Context context;
    private List<CartItemWrapper> cartItemWrappers;

    public class CheckoutCartItemViewHolder extends RecyclerView.ViewHolder{
        private TextView cartItemTypeCount, cartItemPrice, itemTypeName, itemServices;

        private CheckoutCartItemViewHolder(View view){
            super(view);
            cartItemTypeCount = view.findViewById(R.id.txt_checkout_cart_item_count);
            cartItemPrice = view.findViewById(R.id.txt_checkout_cart_item_price);
            itemTypeName = view.findViewById(R.id.txt_checkout_cart_item_type);
            itemServices = view.findViewById(R.id.txt_checkout_cart_service_code);
        }
    }

    public CheckoutCartItemAdapter(Context context, List<CartItemWrapper> cartItemWrappers) {
        this.context = context;
        this.cartItemWrappers = cartItemWrappers;
    }

    @NonNull
    @Override
    public CheckoutCartItemAdapter.CheckoutCartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.row_cart_item_service, parent, false);
        return new CheckoutCartItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutCartItemAdapter.CheckoutCartItemViewHolder holder, int position) {

        CartItemWrapper cartItemWrapper = cartItemWrappers.get(position);

        holder.itemTypeName.setText(cartItemWrapper.getItemTypeName());

        String itemServiceList = "";
        for(String services : cartItemWrapper.getItemServices()){
            itemServiceList = itemServiceList+services+", ";
        }
        holder.itemServices.setText("[ "+itemServiceList+"]");

        holder.cartItemTypeCount.setText(cartItemWrapper.getUserCartItemTypeCount().toString());
        holder.cartItemPrice.setText(cartItemWrapper.getUserCartItemPrice().toString()+"/-");

    }

    @Override
    public int getItemCount() {
        return cartItemWrappers.size();
    }


}
