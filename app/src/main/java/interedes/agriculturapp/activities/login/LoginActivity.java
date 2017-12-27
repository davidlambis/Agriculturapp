package interedes.agriculturapp.activities.login;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.register_user.RegisterUserActivity;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edtCedula)
    EditText edtCedula;
    @BindView(R.id.edtContrasena)
    EditText edtContrasena;
    @BindView(R.id.fabLogin)
    FloatingActionButton fabLogin;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.textViewRegistrarse)
    TextView textViewRegistrarse;
    @BindView(R.id.container)
    ScrollView container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);


    }


    //region On Click Cases
    @OnClick({R.id.fabLogin, R.id.textViewRegistrarse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fabLogin:
                break;
            case R.id.textViewRegistrarse:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    textViewRegistrarse.setTextColor(getColor(R.color.colorPrimary));
                    startActivity(new Intent(this, RegisterUserActivity.class));
                }else{
                    startActivity(new Intent(this, RegisterUserActivity.class));
                }
                break;
        }
    }
    //endregion
}
