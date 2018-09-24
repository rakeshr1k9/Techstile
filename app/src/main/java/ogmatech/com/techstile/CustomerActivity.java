package ogmatech.com.techstile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CustomerActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
