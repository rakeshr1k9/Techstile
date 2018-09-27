package ogmatech.com.techstile.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ogmatech.com.techstile.OrderCreateActivity;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.adapter.CartItemAdapter;
import ogmatech.com.techstile.adapter.CheckoutCartItemAdapter;
import ogmatech.com.techstile.api.service.CartItemService;
import ogmatech.com.techstile.api.service.CheckoutService;
import ogmatech.com.techstile.dialog.CustomerNumberDialog;
import ogmatech.com.techstile.model.Customer;
import ogmatech.com.techstile.model.Order;
import ogmatech.com.techstile.wrapper.CartItemWrapper;
import ogmatech.com.techstile.wrapper.CustomerWrapper;

public class CheckoutDetailFragment extends Fragment implements DatePickerFragment.DatePickerOkClick, TimePickerFragment.TimePickerOkClick, CustomerNumberDialog.CustomerNumberDialogListener, CustomerFragment.OnCreateCustomerListener{

    private Order order = new Order();
    private CustomerWrapper customerWrapper = new CustomerWrapper();

    Integer dateTimeSelectorFlag;

    Date receivingDate, deliveryDate;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat timeFormat = new SimpleDateFormat("HH:mm");
    String currentDateString, deliveryDateString, currentTimeString, deliveryTimeString;

    Date outputDate;
    Date outputTime;

    /*//Date currentDateTime = new Date();
    Date deliveryDateTime = new Date();


    Date currentDateTime = Calendar.getInstance().getTime();*/

    private RecyclerView recyclerView;
    private CheckoutCartItemAdapter checkoutCartItemAdapter;

    RelativeLayout customerRelativeLayout, customerAddRelativeLayout;
    LinearLayout quickOrderLinearLayout;

    private TextView customerMobile, customerName, customerAddress, customerType, cartItemCount, cartItemPrice, grandTotal, receiveDate, deliverDate, receiveTime, deliveryTime, quickOrderPrice;
    private Spinner quickDeliverySpinner;

    private CheckBox isQuickDelivery;
    private ImageView imageViewCustomerRefresh;

    private Button editCustomer;

    String [] percentages = {"100%", "50%", "25%", "10%", "Rs. 20/-", "Rs. 50/-"};

    private Integer grandTotalPrice = 0;
    private Integer cartItemTotalCount = 0;
    private Integer cartItemTotalPrice = 0;
    private Integer quickOrderTotalPrice = 0;

    public CheckoutDetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_checkout_detail, container, false);

        customerRelativeLayout = view.findViewById(R.id.layout_checkout_detail_customer_detail);
        customerAddRelativeLayout = view.findViewById(R.id.layout_checkout_button_customer_detail);
        quickOrderLinearLayout = view.findViewById(R.id.linear_layout_checkout_quick_order);

        quickOrderLinearLayout.setVisibility(View.GONE);

        customerMobile = view.findViewById(R.id.txt_checkout_customer_mobile);
        customerName = view.findViewById(R.id.txt_checkout_customer_name);
        customerAddress = view.findViewById(R.id.txt_checkout_customer_address);
        customerType = view.findViewById(R.id.txt_checkout_customer_type);
        quickOrderPrice = view.findViewById(R.id.txt_quick_delivery_price);
        cartItemCount = view.findViewById(R.id.txt_checkout_cart_item_count);
        cartItemPrice = view.findViewById(R.id.txt_checkout_cart_item_price);
        grandTotal = view.findViewById(R.id.txt_checkout_grand_total);
        receiveDate = view.findViewById(R.id.txt_checkout_receive_date);
        deliverDate = view.findViewById(R.id.txt_checkout_delivery_date);
        receiveTime = view.findViewById(R.id.txt_checkout_receive_time);
        deliveryTime = view.findViewById(R.id.txt_checkout_delivery_time);

        imageViewCustomerRefresh = view.findViewById(R.id.icon_checkout_customer_refresh);
        imageViewCustomerRefresh.setOnClickListener(v->onImageCustomerRefreshClicked());
        imageViewCustomerRefresh.setVisibility(View.GONE);

        receivingDate = Calendar.getInstance().getTime();
        currentDateString = dateFormat.format(receivingDate);
        currentTimeString = timeFormat.format(receivingDate);

        Calendar c = Calendar.getInstance();
        c.setTime(receivingDate);
        c.add(Calendar.DAY_OF_MONTH, 4);
        c.set(Calendar.HOUR, 17);
        c.set(Calendar.MINUTE, 00);
        deliveryDate = c.getTime();
        deliveryDateString = dateFormat.format(deliveryDate);
        deliveryTimeString = timeFormat.format(deliveryDate);

        receiveDate.setText(currentDateString);
        deliverDate.setText(deliveryDateString);

        receiveTime.setText(currentTimeString);
        deliveryTime.setText(deliveryTimeString);

        receiveDate.setOnClickListener(v->onReceiveDateImgClick());
        receiveTime.setOnClickListener(v->onReceiveTimeImgClick());
        deliverDate.setOnClickListener(v->onDeliveryDateImgClick());
        deliveryTime.setOnClickListener(v->onDeliveryTimeImgClick());

        grandTotalPrice = quickOrderTotalPrice+cartItemTotalPrice;
        quickOrderPrice.setText("Rs. "+quickOrderTotalPrice+"/-");
        grandTotal.setText("Grand Total : Rs. "+grandTotalPrice.toString()+"/-");

        quickDeliverySpinner = view.findViewById(R.id.spinner_checkout_quick_delivery_info);
        ArrayAdapter<String> quickDeliveryAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, percentages);
        quickDeliverySpinner.setAdapter(quickDeliveryAdapter);
        quickDeliverySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        quickOrderTotalPrice = cartItemTotalPrice;
                        grandTotalPrice = quickOrderTotalPrice+cartItemTotalPrice;
                        quickOrderPrice.setText("Rs. "+quickOrderTotalPrice+"/-");
                        grandTotal.setText("Grand Total : Rs. "+grandTotalPrice.toString()+"/-");
                        break;
                    case 1:
                        quickOrderTotalPrice = cartItemTotalPrice/2;
                        grandTotalPrice = quickOrderTotalPrice+cartItemTotalPrice;
                        quickOrderPrice.setText("Rs. "+quickOrderTotalPrice+"/-");
                        grandTotal.setText("Grand Total : Rs. "+grandTotalPrice.toString()+"/-");
                        break;
                    case 2:
                        quickOrderTotalPrice = cartItemTotalPrice/4;
                        grandTotalPrice = quickOrderTotalPrice+cartItemTotalPrice;
                        quickOrderPrice.setText("Rs. "+quickOrderTotalPrice+"/-");
                        grandTotal.setText("Grand Total : Rs. "+grandTotalPrice.toString()+"/-");
                        break;
                    case 3:
                        quickOrderTotalPrice = cartItemTotalPrice/10;
                        grandTotalPrice = quickOrderTotalPrice+cartItemTotalPrice;
                        quickOrderPrice.setText("Rs. "+quickOrderTotalPrice+"/-");
                        grandTotal.setText("Grand Total : Rs. "+grandTotalPrice.toString()+"/-");
                        break;
                    case 4:
                        quickOrderTotalPrice = cartItemTotalCount*20;
                        grandTotalPrice = quickOrderTotalPrice+cartItemTotalPrice;
                        quickOrderPrice.setText("Rs. "+quickOrderTotalPrice+"/-");
                        grandTotal.setText("Grand Total : Rs. "+grandTotalPrice.toString()+"/-");
                        break;
                    case 5:
                        quickOrderTotalPrice = cartItemTotalCount*50;
                        grandTotalPrice = quickOrderTotalPrice+cartItemTotalPrice;
                        quickOrderPrice.setText("Rs. "+quickOrderTotalPrice+"/-");
                        grandTotal.setText("Grand Total : Rs. "+grandTotalPrice.toString()+"/-");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        isQuickDelivery = view.findViewById(R.id.check_box_quick_delivery);
        isQuickDelivery.isChecked();
        isQuickDelivery.setOnClickListener(v->onCheckboxChange(isQuickDelivery.isChecked()));

        editCustomer =  view.findViewById(R.id.btn_checkout_customer_detail_edit);
        editCustomer.setOnClickListener(v->onEditCustomerClick());
        editCustomer.setVisibility(View.GONE);

        Button addCustomer =  view.findViewById(R.id.btn_checkout_add_customer);
        addCustomer.setOnClickListener(v->OnAddCustomerClick());

        Button editCart =  view.findViewById(R.id.btn_checkout_cart_detail_edit);
        editCart.setOnClickListener(v->onEditCartClick());

        Button createOrder =  view.findViewById(R.id.btn_create_order_pay);
        createOrder.setOnClickListener(v->onCreateOrderClick());

        if(this.customerWrapper.getIdCustomer() == null){
            customerAddRelativeLayout.setVisibility(View.VISIBLE);
            customerRelativeLayout.setVisibility(View.GONE);
        }
        else {
            customerAddRelativeLayout.setVisibility(View.GONE);
            customerRelativeLayout.setVisibility(View.VISIBLE);
            customerMobile.setText("99000");
            customerName.setText("Test");
            customerAddress.setText("New");
            customerType.setText("Regular");
        }

        recyclerView = view.findViewById(R.id.recycler_view_checkout_cart);

        getCartItemApi();

        return view;
    }

    private void getCartItemApi(){

        List<CartItemWrapper> cartItemWrappers = new ArrayList<>();

        CartItemService.getCartItem()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{checkoutCartItemAdapter = new CheckoutCartItemAdapter(getActivity(),t);
                    RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),1));
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    recyclerView.setAdapter(checkoutCartItemAdapter);

                    Integer itemCountTemp=0;
                    Integer itemTotalPriceTemp=0;

                    for (CartItemWrapper cartItemWrapper : t){
                        Integer itemCountInc = cartItemWrapper.getUserCartItemTypeCount();
                        Integer itemTotalPriceInc = cartItemWrapper.getUserCartItemPrice();
                        itemCountTemp = itemCountTemp + itemCountInc;
                        itemTotalPriceTemp = itemTotalPriceTemp + itemTotalPriceInc;
                    }

                    cartItemCount.setText(itemCountTemp+" Items");
                    cartItemPrice.setText("Total: Rs. "+itemTotalPriceTemp+"/-");
                    this.cartItemTotalPrice = itemTotalPriceTemp;
                    this.cartItemTotalCount = itemCountTemp;

                    grandTotal.setText("Grand Total : Rs. "+cartItemTotalPrice.toString()+"/-");


                }, throwable -> this.cartItemTotalPrice = 0);//Log.d("error", "throwable error");
    }

    private void onImageCustomerRefreshClicked(){
        customerWrapper = null;
        customerName.setText("");
        customerType.setText("");
        customerMobile.setText("");
        customerAddress.setText("");

        editCustomer.setVisibility(View.GONE);
        imageViewCustomerRefresh.setVisibility(View.GONE);

        customerAddRelativeLayout.setVisibility(View.VISIBLE);
        customerRelativeLayout.setVisibility(View.GONE);


    }

    private void onCheckboxChange(boolean checked) {
        if(checked){
            quickOrderLinearLayout.setVisibility(View.VISIBLE);
            quickDeliverySpinner.setSelection(0);
            quickOrderTotalPrice = cartItemTotalPrice;
            grandTotalPrice = quickOrderTotalPrice+cartItemTotalPrice;
            quickOrderPrice.setText("Rs. "+quickOrderTotalPrice+"/-");
            grandTotal.setText("Grand Total : Rs. "+grandTotalPrice.toString()+"/-");

            Calendar c = Calendar.getInstance();
            c.setTime(receivingDate);
            c.add(Calendar.DAY_OF_MONTH, 1);
            deliveryDate = c.getTime();
            deliveryDateString = dateFormat.format(deliveryDate);
            deliverDate.setText(deliveryDateString);

        }
        else {
            quickOrderLinearLayout.setVisibility(View.GONE);
            quickOrderTotalPrice = 0;
            grandTotalPrice = quickOrderTotalPrice+cartItemTotalPrice;
            quickOrderPrice.setText("Rs. "+quickOrderTotalPrice+"/-");
            grandTotal.setText("Grand Total : Rs. "+grandTotalPrice.toString()+"/-");

            Calendar c = Calendar.getInstance();
            c.setTime(receivingDate);
            c.add(Calendar.DAY_OF_MONTH, 4);
            deliveryDate = c.getTime();
            deliveryDateString = dateFormat.format(deliveryDate);
            deliverDate.setText(deliveryDateString);
        }
    }

    private void onEditCustomerClick() {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("isComingFrom", "UpdateCustomerClick");
        bundle.putLong("mobileNumber", customerWrapper.getCustomerMobile());
        bundle.putInt("idCustomer", customerWrapper.getIdCustomer());
        bundle.putString("customerName", customerWrapper.getCustomerName());
        bundle.putString("customerAddress", customerWrapper.getCustomerAddress());
        bundle.putString("customerTypeName", customerWrapper.getCustomerTypeName());
        bundle.putInt("idCustomerType",customerWrapper.getIdCustomerType());
        CustomerFragment customerFragment = new CustomerFragment();
        customerFragment.onCreateCustomerListener = CheckoutDetailFragment.this;
        customerFragment.setArguments(bundle);

        ft.add(R.id.fragment_holder, customerFragment).addToBackStack(null);
        ft.commit();
    }

    private void OnAddCustomerClick() {
        CustomerNumberDialog customerNumberDialog = new CustomerNumberDialog();
        customerNumberDialog.customerNumberDialogListener = CheckoutDetailFragment.this;
        customerNumberDialog.show(getFragmentManager(),"customer number dialog");
    }

    private void onEditCartClick() {
        getFragmentManager().popBackStack();
    }

    private void onReceiveTimeImgClick() {
        dateTimeSelectorFlag = 1;
        openTimePicker(receivingDate);
    }

    private void onReceiveDateImgClick() {
        dateTimeSelectorFlag = 2;
        openDatePicker(receivingDate);
    }

    private void onDeliveryDateImgClick() {
        dateTimeSelectorFlag = 3;
        openDatePicker(deliveryDate);
    }

    private void onDeliveryTimeImgClick() {
        dateTimeSelectorFlag = 4;
        openTimePicker(deliveryDate);
    }

    @Override
    public void onCreateClicked(CustomerWrapper customerWrapper) {
        hideKeyboard();
        CheckoutService.createCustomerService(customerWrapper)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{

                    this.customerWrapper = t;

                    editCustomer.setVisibility(View.VISIBLE);
                    imageViewCustomerRefresh.setVisibility(View.VISIBLE);

                    customerAddRelativeLayout.setVisibility(View.GONE);
                    customerRelativeLayout.setVisibility(View.VISIBLE);
                    customerType.setText(t.getCustomerTypeName());
                    customerMobile.setText(t.getCustomerMobile().toString());

                    if(t.getCustomerName()==null && t.getCustomerName()==""){
                        customerName.setText("--Nil--");
                    }
                    else {
                        customerName.setText(t.getCustomerName());
                    }

                    if(t.getCustomerAddress()==null){
                        customerAddress.setText("--Nil--");
                    }
                    else {
                        customerAddress.setText(t.getCustomerAddress());
                    }

                    getFragmentManager().popBackStack();

                }, throwable -> Log.d("error", "throwable erropr"));
    }

    @Override
    public void onUpdateClicked(CustomerWrapper customerWrapper) {
        hideKeyboard();
        CheckoutService.putCustomerByIdService(customerWrapper.getIdCustomer(), customerWrapper)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{

                    this.customerWrapper = t;

                    editCustomer.setVisibility(View.VISIBLE);
                    imageViewCustomerRefresh.setVisibility(View.VISIBLE);

                    customerAddRelativeLayout.setVisibility(View.GONE);
                    customerRelativeLayout.setVisibility(View.VISIBLE);
                    customerType.setText(t.getCustomerTypeName());
                    customerMobile.setText(t.getCustomerMobile().toString());

                    if(t.getCustomerName()==null){
                        customerName.setText("--Nil--");
                    }
                    else {
                        customerName.setText(t.getCustomerName());
                    }

                    if(t.getCustomerAddress()==null){
                        customerAddress.setText("--Nil--");
                    }
                    else {
                        customerAddress.setText(t.getCustomerAddress());
                    }

                    getFragmentManager().popBackStack();

                }, throwable -> Log.d("error", "throwable erropr"));

    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
    }

    private void openDatePicker(Date inputDate) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();

        Calendar c = Calendar.getInstance();
        c.setTime(inputDate);
        Bundle bundle = new Bundle();
        bundle.putInt("year", c.get(Calendar.YEAR));
        bundle.putInt("month", c.get(Calendar.MONTH));
        bundle.putInt("day", c.get(Calendar.DAY_OF_MONTH));
        datePickerFragment.setArguments(bundle);

        datePickerFragment.datePickerOkClick = CheckoutDetailFragment.this;
        datePickerFragment.setCancelable(false);
        datePickerFragment.show(getFragmentManager(), "datePicker");
    }

    private void openTimePicker(Date inputTime) {
        TimePickerFragment timePickerFragment = new TimePickerFragment();

        Calendar c = Calendar.getInstance();
        c.setTime(inputTime);
        Bundle bundle = new Bundle();
        bundle.putInt("hour", c.get(Calendar.HOUR));
        bundle.putInt("minute", c.get(Calendar.MINUTE));
        timePickerFragment.setArguments(bundle);

        timePickerFragment.timePickerOkClick = CheckoutDetailFragment.this;
        timePickerFragment.setCancelable(false);
        timePickerFragment.show(getFragmentManager(), "timePicker");
    }

    @Override
    public void onTimeSelected(int hours, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, hours);
        c.set(Calendar.MINUTE, minute);
        outputTime = c.getTime();
        dateTimeSetter();
    }

    @Override
    public void onDateSelected(int day, int month, int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.YEAR, year);
        outputDate = c.getTime();
        dateTimeSetter();
    }

    private void dateTimeSetter(){

        if(dateTimeSelectorFlag == 1){
            Calendar cal = Calendar.getInstance();
            cal.setTime(outputTime);

            Calendar c = Calendar.getInstance();
            c.setTime(receivingDate);
            c.set(Calendar.HOUR, cal.get(Calendar.HOUR));
            c.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
            receivingDate = c.getTime();

            currentTimeString = timeFormat.format(receivingDate);
            receiveTime.setText(currentTimeString);
        }

        if(dateTimeSelectorFlag == 2){
            Calendar cal = Calendar.getInstance();
            cal.setTime(outputDate);

            Calendar c = Calendar.getInstance();
            c.setTime(receivingDate);
            c.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
            c.set(Calendar.MONTH, cal.get(Calendar.MONTH));
            c.set(Calendar.YEAR, cal.get(Calendar.YEAR));
            receivingDate = c.getTime();

            currentDateString = dateFormat.format(receivingDate);
            receiveDate.setText(currentDateString);

            if(isQuickDelivery.isChecked()){
                Calendar newDate = Calendar.getInstance();
                newDate.setTime(receivingDate);
                newDate.add(Calendar.DAY_OF_MONTH, 1);
                deliveryDate = newDate.getTime();
                deliveryDateString = dateFormat.format(deliveryDate);
                deliverDate.setText(deliveryDateString);
            }
            else {
                Calendar newDate = Calendar.getInstance();
                newDate.setTime(receivingDate);
                newDate.add(Calendar.DAY_OF_MONTH, 4);
                deliveryDate = newDate.getTime();
                deliveryDateString = dateFormat.format(deliveryDate);
                deliverDate.setText(deliveryDateString);
            }

        }
        if(dateTimeSelectorFlag == 3){
            Calendar cal = Calendar.getInstance();
            cal.setTime(outputDate);

            Calendar c = Calendar.getInstance();
            c.setTime(deliveryDate);
            c.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH));
            c.set(Calendar.MONTH, cal.get(Calendar.MONTH));
            c.set(Calendar.YEAR, cal.get(Calendar.YEAR));
            deliveryDate = c.getTime();

            deliveryDateString = dateFormat.format(deliveryDate);
            deliverDate.setText(deliveryDateString);

        }
        if(dateTimeSelectorFlag == 4){
            Calendar cal = Calendar.getInstance();
            cal.setTime(outputTime);

            Calendar c = Calendar.getInstance();
            c.setTime(deliveryDate);
            c.set(Calendar.HOUR, cal.get(Calendar.HOUR));
            c.set(Calendar.MINUTE, cal.get(Calendar.MINUTE));
            deliveryDate = c.getTime();

            deliveryTimeString = timeFormat.format(deliveryDate);
            deliveryTime.setText(deliveryTimeString);

        }

    }

    @Override
    public void searchCustomerNumber(Long mobileNumber) {

        CheckoutService.getCustomerByMobileService(mobileNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(t->{

                    this.customerWrapper = t;

                    editCustomer.setVisibility(View.VISIBLE);
                    imageViewCustomerRefresh.setVisibility(View.VISIBLE);

                    customerAddRelativeLayout.setVisibility(View.GONE);
                    customerRelativeLayout.setVisibility(View.VISIBLE);
                    customerType.setText(t.getCustomerTypeName());
                    customerMobile.setText(t.getCustomerMobile().toString());

                    if(t.getCustomerName()==null){
                        customerName.setText("--Nil--");
                    }
                    else {
                        customerName.setText(t.getCustomerName());
                    }

                    if(t.getCustomerAddress()==null){
                        customerAddress.setText("--Nil--");
                    }
                    else {
                        customerAddress.setText(t.getCustomerAddress());
                    }

                }, throwable -> {FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString("isComingFrom", "CreateCustomerClick");
        bundle.putLong("mobileNumber", mobileNumber);
        CustomerFragment customerFragment = new CustomerFragment();
        customerFragment.onCreateCustomerListener = CheckoutDetailFragment.this;
        customerFragment.setArguments(bundle);

        ft.add(R.id.fragment_holder, customerFragment).addToBackStack(null);
        ft.commit();});//Log.d("error", "throwable erropr"); or this.cartItemTotalPrice = 0
    }

    public void hideKeyboard() {
        // Check if no view has focus:
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private void onCreateOrderClick() {
    }
}

