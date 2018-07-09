package ogmatech.com.techstile.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.github.curioustechizen.ago.RelativeTimeTextView;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.fragment.AllOrderFragment;
import ogmatech.com.techstile.model.Order;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private Context context;
    private List<Order> orderList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView orderNumber, customerInfo, orderTotalItem, orderTotalAmount ;
        public RelativeTimeTextView orderReceivedAt, orderShouldDeliverAt;
        public ImageView customerTypeName, orderStatusName, isQuickDelivery;

        public MyViewHolder(View view) {
            super(view);
            orderNumber = view.findViewById(R.id.txt_order_list_order_number);
            customerInfo = view.findViewById(R.id.txt_order_list_customer_info);
            orderTotalItem = view.findViewById(R.id.txt_order_list_items);
            orderTotalAmount = view.findViewById(R.id.txt_order_list_total_amount);
            orderReceivedAt = view.findViewById(R.id.txt_order_list_start_date);
            orderShouldDeliverAt = view.findViewById(R.id.txt_order_list_end_date);
            customerTypeName = view.findViewById(R.id.icon_order_list_customer_type);
            orderStatusName = view.findViewById(R.id.icon_order_list_order_status);
            isQuickDelivery = view.findViewById(R.id.icon_order_list_quick_delivery);
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

        Calendar calendar = Calendar.getInstance();
        Date todayDate = Calendar.getInstance().getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrowDate = calendar.getTime();

        Order order = orderList.get(position);

        holder.orderNumber.setText(order.getOrderNumber().toString());

        if(order.getCustomerName().isEmpty()){
            holder.customerInfo.setText(order.getCustomerMobile().toString());
        }
        else{
            holder.customerInfo.setText(order.getCustomerName());
        }

        holder.orderTotalItem.setText(order.getOrderTotalItemCompleted().toString()+"/"+order.getOrderTotalItem().toString());
        holder.orderTotalAmount.setText(order.getOrderTotalAmount().toString() + "/-");
        holder.orderReceivedAt.setReferenceTime(order.getOrderReceivedAt().getTime());


        if(order.getOrderStatusId()==5 || order.getOrderStatusId()==6) {
            holder.orderShouldDeliverAt.setReferenceTime(order.getOrderDeliveredAt().getTime());
            holder.orderReceivedAt.setTextColor(Color.parseColor("#212121"));
            holder.orderShouldDeliverAt.setTextColor(Color.parseColor("#212121"));
        }
        else {
            holder.orderShouldDeliverAt.setReferenceTime(order.getOrderShouldDeliverAt().getTime());
            if(todayDate.after(order.getOrderShouldDeliverAt())) {
                holder.orderReceivedAt.setTextColor(Color.parseColor("#dd2c00"));
                holder.orderShouldDeliverAt.setTextColor(Color.parseColor("#dd2c00"));
            }
            else {
                if(order.getIsQuickDelivery()==1) {
                    holder.orderReceivedAt.setTextColor(Color.parseColor("#ff6f00"));
                    holder.orderShouldDeliverAt.setTextColor(Color.parseColor("#ff6f00"));
                }
                else {
                    {
                        if(tomorrowDate.after(order.getOrderShouldDeliverAt())) {
                            holder.orderReceivedAt.setTextColor(Color.parseColor("#ff6f00"));
                            holder.orderShouldDeliverAt.setTextColor(Color.parseColor("#ff6f00"));
                        }
                        else {
                            holder.orderReceivedAt.setTextColor(Color.parseColor("#1b5e20"));
                            holder.orderShouldDeliverAt.setTextColor(Color.parseColor("#1b5e20"));
                        }
                    }
                }
            }

        }


        switch (order.getCustomerTypeName())
        {
            case "VIP" :
                holder.customerTypeName.setImageResource(R.mipmap.customer_type_vip);
                break;

            case "Regular" :
                holder.customerTypeName.setImageResource(R.mipmap.customer_type_regular);
                break;

            case "Business" :
                holder.customerTypeName.setImageResource(R.mipmap.customer_type_business);
                break;

                default:
                    holder.customerTypeName.setImageResource(R.mipmap.customer_type_normal);
                    break;
        }

        switch (order.getOrderStatusId())
        {
            case 2 :
                holder.orderStatusName.setImageResource(R.mipmap.order_status_tag);
                break;

            case 3 :
                holder.orderStatusName.setImageResource(R.mipmap.order_status_processing);
                break;

            case 4 :
                holder.orderStatusName.setImageResource(R.mipmap.order_status_completed);
                break;

            case 5 :
                holder.orderStatusName.setImageResource(R.mipmap.order_status_delivered);
                break;

            default:
                holder.orderStatusName.setImageResource(R.mipmap.order_status_cancelled);
                break;
        }

       if(order.getIsQuickDelivery() == 1) {
            holder.isQuickDelivery.setVisibility(View.VISIBLE);
        }

     /*   // loading album cover using Glide library
        Glide.with(context).load(order.getIsQuickDeivery()).into(holder.quickOrder);
        Glide.with(context).load(order.getOrderStatusId()).into(holder.orderStatus);*/
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }
}
