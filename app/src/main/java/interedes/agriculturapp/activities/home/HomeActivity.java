package interedes.agriculturapp.activities.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.login.LoginActivity;
import interedes.agriculturapp.activities.register_user.RegisterUserActivity;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.linearLayoutIngresar)
    LinearLayout linearLayoutIngresar;
    @BindView(R.id.linearLayoutRegistrar)
    LinearLayout linearLayoutRegistrar;
    @BindView(R.id.linearLayoutContactanos)
    LinearLayout linearLayoutContactanos;
    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }


    //region Methods
    @OnClick({R.id.linearLayoutIngresar, R.id.linearLayoutRegistrar, R.id.linearLayoutContactanos})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linearLayoutIngresar:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.linearLayoutRegistrar:
                startActivity(new Intent(this, RegisterUserActivity.class));
                break;
            case R.id.linearLayoutContactanos:
                break;
        }
    }
    //endregion
}
