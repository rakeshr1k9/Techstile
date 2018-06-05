package ogmatech.com.techstile.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ogmatech.com.techstile.BaseActivity;
import ogmatech.com.techstile.DashboardActivity;
import ogmatech.com.techstile.OrderActivity;
import ogmatech.com.techstile.R;
import ogmatech.com.techstile.api.ApiClient;
import ogmatech.com.techstile.api.LoginApi;
import ogmatech.com.techstile.model.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Pavan on 04-06-2018.
 */

public class LoginFragment extends Fragment {

    TextInputLayout userNameLayout;
    EditText userNameEditText;
    TextInputLayout passwordLayout;
    EditText passwordEditText;
    Button loginButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        userNameLayout = view.findViewById(R.id.usernameLayout);
        userNameEditText = view.findViewById(R.id.usernameEditText);
        passwordLayout = view.findViewById(R.id.passwordLayout);
        passwordEditText = view.findViewById(R.id.passwordEditText);
        loginButton = view.findViewById(R.id.loginButton);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setListener();
    }

    private void setListener() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    login();
                }
            }
        });
    }

    private boolean validate() {
        String username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        boolean valid = true;
        if(TextUtils.isEmpty(username)){
            userNameLayout.setError("Required");
            valid = false;
        }
        if(TextUtils.isEmpty(password)){
            passwordLayout.setError("Required");
            valid = false;
        }
        return valid;
    }

    private void login() {
        LoginApi loginService =
                ApiClient.getClient(getContext(), false).create(LoginApi.class);

        Call<Token> call = loginService.getToken("password", "user1", "123");
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                //List<Movie> movies = response.body().getResults();
                Log.d("LoginFragment", "Number of movies received: " + response.body());
                Toast.makeText(getContext(), "Valid entries", Toast.LENGTH_LONG).show();
              //  ((BaseActivity)getActivity()).addFragment(new AllOrderFragment(), "AllOrderFragment");
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                startActivity(intent);
                ((Activity) getActivity()).overridePendingTransition(0,0);
            }

            @Override
            public void onFailure(Call<Token>call, Throwable t) {
                // Log error here since request failed
                Log.e("LoginFragment", t.toString());
            }
        });

    }
}
