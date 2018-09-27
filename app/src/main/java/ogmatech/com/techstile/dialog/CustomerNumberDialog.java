package ogmatech.com.techstile.dialog;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import ogmatech.com.techstile.R;

public class CustomerNumberDialog extends AppCompatDialogFragment {

    private EditText mobileNumberEdit;
    private Long mobileNumber;

    public CustomerNumberDialogListener customerNumberDialogListener;

    public interface CustomerNumberDialogListener{
        void searchCustomerNumber(Long mobileNumber);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_customer_number, null);

        builder.setView(view)
                .setTitle("Find Customer")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Find", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if(mobileNumberEdit.getText().length()==10){
                            Long mobileNumber = Long.parseLong(mobileNumberEdit.getText().toString());
                            customerNumberDialogListener.searchCustomerNumber(mobileNumber);
                        }
                        else {
                            getDialog().dismiss();
                        }

                    }
                });

        mobileNumberEdit = view.findViewById(R.id.edit_text_customer_mobile_dialog);
        /*mobileNumberEdit.requestFocus();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        imm.toggleSoftInputFromWindow(view.getWindowToken(), 0,0);*/

        return builder.create();
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            customerNumberDialogListener = (CustomerNumberDialogListener) getFragmentManager();
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement CustomerNumberDialogListener");
        }
    }*/
}
