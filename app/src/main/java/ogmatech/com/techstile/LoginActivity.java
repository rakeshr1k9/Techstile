package ogmatech.com.techstile;

import android.os.Bundle;

import ogmatech.com.techstile.fragment.LoginFragment;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoginFragment loginFragment = new LoginFragment();
        addFragment(loginFragment, "Login");
    }
}
