package interedes.agriculturapp.activities.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.login.LoginActivity;
import interedes.agriculturapp.activities.register_user.RegisterUserActivity;

public class HomeActivity extends AppCompatActivity implements HomeView {


    //UI Elements
    @BindView(R.id.imageViewIngresar)
    ImageView imageViewIngresar;
    @BindView(R.id.linearLayoutIngresar)
    LinearLayout linearLayoutIngresar;
    @BindView(R.id.imageViewRegistrarse)
    ImageView imageViewRegistrarse;
    @BindView(R.id.linearLayoutRegistrar)
    LinearLayout linearLayoutRegistrar;
    @BindView(R.id.imageViewContactanos)
    ImageView imageViewContactanos;
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


    //region Métodos Interfaz
    @Override
    @OnClick(R.id.linearLayoutIngresar)
    public void ingresar() {
        imageViewIngresar.setColorFilter(getResources().getColor(R.color.colorPrimary));
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    @OnClick(R.id.linearLayoutRegistrar)
    public void registrarse() {
        imageViewRegistrarse.setColorFilter(getResources().getColor(R.color.colorPrimary));
        startActivity(new Intent(this, RegisterUserActivity.class));
    }

    @Override
    @OnClick(R.id.linearLayoutContactanos)
    public void contactarnos() {
        imageViewContactanos.setColorFilter(getResources().getColor(R.color.colorPrimary));
        Snackbar.make(container, "Go to Contactarnos", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void limpiarCambios() {
        imageViewIngresar.setColorFilter(getResources().getColor(R.color.white));
        imageViewRegistrarse.setColorFilter(getResources().getColor(R.color.white));
        imageViewContactanos.setColorFilter(getResources().getColor(R.color.white));
    }
    //endregion


    //region Ciclo de Vida Actividad

    @Override
    protected void onResume() {
        super.onResume();
        limpiarCambios();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    //endregion

}
