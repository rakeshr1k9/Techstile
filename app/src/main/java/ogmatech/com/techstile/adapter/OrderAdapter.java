package ogmatech.com.techstile.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.fragment.AllOrderFragment;
import ogmatech.com.techstile.model.Order;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private Context context;
    private List<Order> orderList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView orderNumber, itemCompletionStatus, receivedDate, completionDate ;
        public ImageView quickOrder, orderStatus;

        public MyViewHolder(View view) {
            super(view);
            orderNumber = (TextView) view.findViewById(R.id.textView4);
            itemCompletionStatus = (TextView) view.findViewById(R.id.textView5);
            receivedDate = (TextView) view.findViewById(R.id.textView6);
            completionDate = (TextView) view.findViewById(R.id.textView7);
            quickOrder = (ImageView) view.findViewById(R.id.imageView2);
            orderStatus = (ImageView) view.findViewById(R.id.imageView3);
        }
    }

    public OrderAdapter(Context context, List<Order> orderList) {
      //  this.context = context;
        this.orderList = orderList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_order, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Order order = orderList.get(position);

        holder.orderNumber.setText("O - " + order.getIdOrder());
        holder.itemCompletionStatus.setText(order.getOrderBagNumber());
        holder.receivedDate.setText(order.getOrderReceivedAt());
        holder.completionDate.setText(order.getOrderDeliveredAt());

     /*   // loading album cover using Glide library
        Glide.with(context).load(order.getIsQuickDeivery()).into(holder.quickOrder);
        Glide.with(context).load(order.getOrderStatusId()).into(holder.orderStatus);*/
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
