package ogmatech.com.techstile.fragment;

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

import ogmatech.com.techstile.R;
import ogmatech.com.techstile.api.ApiClient;
import ogmatech.com.techstile.api.LoginInterface;
import ogmatech.com.techstile.model.Token;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rakesh on 24-02-2018.
 */

public class LoginFragment extends Fragment {

   // @BindView(R.id.usernameLayout)
    TextInputLayout userNameLayout;
    //@BindView(R.id.usernameEditText)
    EditText userNameEditText;
    //@BindView(R.id.passwordLayout)
    TextInputLayout passwordLayout;
    //@BindView(R.id.passwordEditText)
    EditText passwordEditText;
    //@BindView(R.id.loginButton)
    Button loginButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);
        //ButterKnife.setDebug(true);
       // ButterKnife.bind(this, view);
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
        LoginInterface loginService =
                ApiClient.getClient().create(LoginInterface.class);

        Call<Token> call = loginService.getToken("password", "user", "password1");
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token>call, Response<Token> response) {
                //List<Movie> movies = response.body().getResults();
                Log.d("LoginFragment", "Number of movies received: " + response.body());
                Toast.makeText(getContext(), "Valid entries", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Token>call, Throwable t) {
                // Log error here since request failed
                Log.e("LoginFragment", t.toString());
            }
        });

    }
}
