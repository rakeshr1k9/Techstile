package ogmatech.com.techstile.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.controller.StaticInfoController;
import ogmatech.com.techstile.model.CustomerType;
import ogmatech.com.techstile.wrapper.CustomerWrapper;

public class CustomerFragment extends Fragment {

    private CustomerWrapper newCustomerWrapper = new CustomerWrapper();

    private Long customerMobile;
    private String customerName = "";
    private String customerAddress = "";
    private Integer idCustomer;
    private Integer idCustomerType;
    private Boolean isUpdate;

    private Spinner spinnerCustomerType;
    private Button createCustomer;

    private List<CustomerType> customerTypes = new ArrayList<>();
    private CustomerType selectedCustomerType;

    public CustomerFragment() {
    }

    public OnCreateCustomerListener onCreateCustomerListener;

    public interface OnCreateCustomerListener{
        void onCreateClicked(CustomerWrapper customerWrapper);
        void onUpdateClicked(CustomerWrapper customerWrapper);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_customer, container, false);

        EditText editTextCustomerMobile = view.findViewById(R.id.edit_text_customer_mobile);
        editTextCustomerMobile.setText(customerMobile.toString());
        EditText editTextCustomerName = view.findViewById(R.id.edit_text_customer_name);
        EditText editTextCustomerAddress = view.findViewById(R.id.edit_text_customer_address);

        TextView toolBarTitle = view.findViewById(R.id.toolbar_title);

        customerTypes = StaticInfoController.getInstance().getCustomerTypes();

        for (CustomerType customerType : customerTypes){
            if(customerType.getIdCustomerType() == this.idCustomerType){
                selectedCustomerType = customerType;
            }
        }

        spinnerCustomerType = view.findViewById(R.id.spinner_customer_type_spinner);
        customerTypes = StaticInfoController.getInstance().getCustomerTypes();

        ArrayAdapter<CustomerType> adapter = new ArrayAdapter<CustomerType>(getActivity(), android.R.layout.simple_spinner_item, customerTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerCustomerType.setAdapter(adapter);

        if(isUpdate){

            int spinnerPosition = adapter.getPosition(selectedCustomerType);
            spinnerCustomerType.setSelection(spinnerPosition);

            editTextCustomerName.setText(customerName);
            editTextCustomerAddress.setText(customerAddress);

            createCustomer = view.findViewById(R.id.btn_create_customer);
            createCustomer.setOnClickListener(v-> {
                newCustomerWrapper.setIdCustomer(this.idCustomer);
                newCustomerWrapper.setIdCustomerType(this.idCustomerType);
                newCustomerWrapper.setCustomerName(editTextCustomerName.getText().toString());
                newCustomerWrapper.setCustomerMobile(Long.parseLong(editTextCustomerMobile.getText().toString()));
                newCustomerWrapper.setCustomerAddress(editTextCustomerAddress.getText().toString());
                onCreateCustomerListener.onUpdateClicked(newCustomerWrapper);
            });

            toolBarTitle.setText("Update Customer Details");
            createCustomer.setText("Update Customer");
        }
        else {
            createCustomer = view.findViewById(R.id.btn_create_customer);
            createCustomer.setOnClickListener(v-> {
                newCustomerWrapper.setIdCustomerType(this.idCustomerType);
                newCustomerWrapper.setCustomerName(editTextCustomerName.getText().toString());
                newCustomerWrapper.setCustomerMobile(Long.parseLong(editTextCustomerMobile.getText().toString()));
                newCustomerWrapper.setCustomerAddress(editTextCustomerAddress.getText().toString());
                onCreateCustomerListener.onCreateClicked(newCustomerWrapper);
            });
        }

        spinnerCustomerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                CustomerType customerType = (CustomerType)spinnerCustomerType.getSelectedItem();
                idCustomerType = customerType.getIdCustomerType();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = this.getArguments();
        if(bundle != null){
            String isComingFrom = bundle.getString("isComingFrom");
            if (isComingFrom == "UpdateCustomerClick"){
                isUpdate = true;
                customerMobile = bundle.getLong("mobileNumber");
                customerName = bundle.getString("customerName");
                customerAddress = bundle.getString("customerAddress");
                idCustomer = bundle.getInt("idCustomer");
                idCustomerType = bundle.getInt("idCustomerType");
            }
            if (isComingFrom == "CreateCustomerClick"){
                isUpdate = false;
                customerMobile = bundle.getLong("mobileNumber");
            }
        }
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




}
