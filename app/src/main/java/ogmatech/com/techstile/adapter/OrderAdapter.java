package ogmatech.com.techstile.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.curioustechizen.ago.RelativeTimeTextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.model.Order;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private Context context;
    private List<Order> orderList;

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView orderNumber, customerInfo, orderTotalItem, orderTotalAmount ;
        private RelativeTimeTextView orderReceivedAt, orderShouldDeliverAt;
        private ImageView customerTypeName, orderStatusName, isQuickDelivery;

        private MyViewHolder(View view) {
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
       this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.card_order, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        Calendar calendar = Calendar.getInstance();
        Date todayDate = Calendar.getInstance().getTime();

        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrowDate = calendar.getTime();

        Order order = orderList.get(position);

        holder.orderNumber.setText(String.valueOf(order.getOrderNumber()));

        if(order.getCustomerName().isEmpty()){
            holder.customerInfo.setText(String.valueOf(order.getCustomerMobile()));
        }
        else{
            holder.customerInfo.setText(order.getCustomerName());
        }

        holder.orderTotalItem.setText(String.valueOf(order.getOrderTotalItemCompleted())+"/"+String.valueOf(order.getOrderTotalItem()));
        holder.orderTotalAmount.setText(String.valueOf(order.getOrderTotalAmount()) + "/-");
        holder.orderReceivedAt.setReferenceTime(order.getOrderReceivedAt().getTime());


        if(order.getOrderStatusId()==4 || order.getOrderStatusId()==5) {
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
            case 1 :
                holder.orderStatusName.setImageResource(R.mipmap.order_status_tag);
                break;

            case 2 :
                holder.orderStatusName.setImageResource(R.mipmap.order_status_processing);
                break;

            case 3 :
                holder.orderStatusName.setImageResource(R.mipmap.order_status_completed);
                break;

            case 4 :
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
