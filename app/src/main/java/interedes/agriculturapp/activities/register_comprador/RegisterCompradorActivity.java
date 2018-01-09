package interedes.agriculturapp.activities.register_comprador;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.profile.ProfileActivity;

public class RegisterCompradorActivity extends AppCompatActivity {

    //region UI Elements
    @BindView(R.id.ivBackButtonRegisterComprador)
    ImageView ivBackButtonRegisterComprador;
    @BindView(R.id.edtContrasena)
    EditText edtContrasena;
    @BindView(R.id.edtConfirmarContrasena)
    EditText edtConfirmarContrasena;
    @BindView(R.id.spinnerInteresProductos)
    MaterialBetterSpinner spinnerInteresProductos;
    @BindView(R.id.spinnerMetodoPago)
    MaterialBetterSpinner spinnerMetodoPago;
    @BindView(R.id.spinnerBanco)
    MaterialBetterSpinner spinnerBanco;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.textInputNumeroCuenta)
    TextInputLayout textInputNumeroCuenta;
    @BindView(R.id.edtNumeroCuenta)
    EditText edtNumeroCuenta;
    @BindView(R.id.btnRegistrarComprador)
    Button btnRegistrarComprador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_comprador);
        ButterKnife.bind(this);
        loadInfo();
    }

    //region On Click
    @OnClick({R.id.ivBackButtonRegisterComprador, R.id.btnRegistrarComprador})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivBackButtonRegisterComprador:
                returnToParentActivity();
                break;
            case R.id.btnRegistrarComprador:
                //startActivity(new Intent(this, ProfileActivity.class));
                break;
            default:
                break;
        }
    }
    //endregion

    //region Methods
    private void loadInfo() {
        //Spinner Interes Productos
        String[] itemsInteresProductos = {"Aguacate", "Cacao", "Fríjol"};
        List<String> interesProductosList = new ArrayList<>();
        interesProductosList.addAll(Arrays.asList(itemsInteresProductos));
        spinnerInteresProductos.setAdapter(null);
        ArrayAdapter<String> interesProductosArrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, interesProductosList);
        spinnerInteresProductos.setAdapter(interesProductosArrayAdapter);

        //Spinner Método de Pago
        String[] itemsMetodoPago = {"Transferencia Bancaria", "Efectivo", "Otros"};
        final List<String> metodoPagoList = new ArrayList<>();
        metodoPagoList.addAll(Arrays.asList(itemsMetodoPago));
        spinnerMetodoPago.setAdapter(null);
        ArrayAdapter<String> metodoPagoArrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, metodoPagoList);
        spinnerMetodoPago.setAdapter(metodoPagoArrayAdapter);

        spinnerMetodoPago.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (metodoPagoList.get(position).toString().equals("Transferencia Bancaria")) {
                    //Carga Spinner Banco
                    spinnerBanco.setVisibility(View.VISIBLE);
                    spinnerBanco.setText("");
                    String[] itemsBanco = {"Bancolombia", "BBVA", "Banco Agrario"};
                    final List<String> bancoList = new ArrayList<>();
                    bancoList.addAll(Arrays.asList(itemsBanco));
                    spinnerBanco.setAdapter(null);
                    ArrayAdapter<String> bancoArrayAdapter =
                            new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, bancoList);
                    spinnerBanco.setAdapter(bancoArrayAdapter);
                    spinnerBanco.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            textInputNumeroCuenta.setVisibility(View.VISIBLE);
                            edtNumeroCuenta.setText("");
                        }
                    });
                } else if (metodoPagoList.get(position).toString().equals("Otros")) {
                    spinnerBanco.setVisibility(View.VISIBLE);
                    spinnerBanco.setText("");
                    String[] itemsBanco = {"Efecty", "Su Chance", "Baloto"};
                    final List<String> bancoList = new ArrayList<>();
                    bancoList.addAll(Arrays.asList(itemsBanco));
                    spinnerBanco.setAdapter(null);
                    ArrayAdapter<String> bancoArrayAdapter =
                            new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, bancoList);
                    spinnerBanco.setAdapter(bancoArrayAdapter);
                    spinnerBanco.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        }
                    });
                } else {
                    spinnerBanco.setVisibility(View.GONE);
                    textInputNumeroCuenta.setVisibility(View.GONE);
                }
            }
        });
    }

    private void returnToParentActivity() {
        // Obtener intent de la actividad padre
        Intent upIntent = NavUtils.getParentActivityIntent(this);
        upIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Comprobar si DetailActivity no se creó desde CourseActivity
        if (NavUtils.shouldUpRecreateTask(this, upIntent)
                || this.isTaskRoot()) {

            // Construir de nuevo la tarea para ligar ambas actividades
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                TaskStackBuilder.create(this)
                        .addNextIntentWithParentStack(upIntent)
                        .startActivities();
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Terminar con el método correspondiente para Android 5.x
            this.finishAfterTransition();
        }

        //Para versiones anterios a 5.x
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Terminar con el método correspondiente para Android 5.x
            onBackPressed();
        }
    }

    //endregion
}
