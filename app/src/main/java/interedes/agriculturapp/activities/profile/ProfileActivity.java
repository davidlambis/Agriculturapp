package interedes.agriculturapp.activities.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.comprador.mercado_comprador.MercadoCompradorActivity;
import interedes.agriculturapp.activities.comprador.my_account_comprador.MyAccountCompradorActivity;
import interedes.agriculturapp.activities.productor.my_account_productor.MyAccountProductorActivity;

public class ProfileActivity extends AppCompatActivity implements ProfileView {

    @BindView(R.id.circleImageViewProfile)
    CircleImageView circleImageViewProfile;
    @BindView(R.id.nombreUsuario)
    TextView nombreUsuario;
    @BindView(R.id.imageViewMiCuenta)
    ImageView imageViewMiCuenta;
    @BindView(R.id.textViewMiCuenta)
    TextView textViewMiCuenta;
    @BindView(R.id.linearLayoutMiCuenta)
    LinearLayout linearLayoutMiCuenta;
    @BindView(R.id.imageViewMercado)
    ImageView imageViewMercado;
    @BindView(R.id.textViewMercado)
    TextView textViewMercado;
    @BindView(R.id.linearLayoutMercado)
    LinearLayout linearLayoutMercado;
    @BindView(R.id.imageViewNotificaciones)
    ImageView imageViewNotificaciones;
    @BindView(R.id.textViewNotificaciones)
    TextView textViewNotificaciones;
    @BindView(R.id.linearLayoutNotificaciones)
    LinearLayout linearLayoutNotificaciones;
    @BindView(R.id.imageViewSalir)
    ImageView imageViewSalir;
    @BindView(R.id.container)
    FrameLayout container;

    //Variables Globales
    private String isCompradorOProductor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ButterKnife.bind(this);
        isCompradorOProductor();
    }


    //region Métodos Interfaz
    @Override
    public void isCompradorOProductor() {
        //TODO el valor lo debe obtener como dato del Usuario después de ser registrado para saber si es comprador o productor
        isCompradorOProductor = getIntent().getExtras().getString("isCompradorOProductor");
        if (isCompradorOProductor.equals("productor")) {
            linearLayoutMercado.setVisibility(View.GONE);
        } else if (isCompradorOProductor.equals("comprador")) {
            linearLayoutMercado.setVisibility(View.VISIBLE);
        }
    }

    @Override
    @OnClick(R.id.linearLayoutMiCuenta)
    public void navigateToMiCuenta() {
        textViewMiCuenta.setTextColor(getResources().getColor(R.color.colorPrimary));
        imageViewMiCuenta.setColorFilter(getResources().getColor(R.color.colorPrimary));
        if (isCompradorOProductor.equals("productor")) {
            Intent i = new Intent(this, MyAccountProductorActivity.class);
            startActivity(i);
        } else if (isCompradorOProductor.equals("comprador")) {
            Intent i = new Intent(this, MyAccountCompradorActivity.class);
            startActivity(i);
        }
    }

    @Override
    @OnClick(R.id.linearLayoutMercado)
    public void navigateToMercado() {
        if (isCompradorOProductor.equals("comprador")) {
            textViewMercado.setTextColor(getResources().getColor(R.color.colorPrimary));
            imageViewMercado.setColorFilter(getResources().getColor(R.color.colorPrimary));
            Intent i = new Intent(this, MercadoCompradorActivity.class);
            startActivity(i);
        }
    }

    @Override
    @OnClick(R.id.linearLayoutNotificaciones)
    public void navigateToNotificaciones() {
        
    }

    @Override
    public void limpiarCambios() {
        textViewMiCuenta.setTextColor(getResources().getColor(R.color.white));
        imageViewMiCuenta.setColorFilter(getResources().getColor(R.color.white));
        textViewMercado.setTextColor(getResources().getColor(R.color.white));
        imageViewMercado.setColorFilter(getResources().getColor(R.color.white));
    }
    //endregion

    //region Métodos Generales
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //endregion

    //region Ciclo de Vida Actividad
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        limpiarCambios();
    }
    //endregion
}
