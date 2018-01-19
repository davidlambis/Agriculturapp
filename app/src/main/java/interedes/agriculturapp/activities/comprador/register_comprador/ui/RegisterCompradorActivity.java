package interedes.agriculturapp.activities.comprador.register_comprador.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.profile.ProfileActivity;

public class RegisterCompradorActivity extends AppCompatActivity implements RegisterCompradorView {

    //region UI Elements
    @BindView(R.id.ivBackButtonRegisterComprador)
    ImageView ivBackButtonRegisterComprador;
    @BindView(R.id.edtNombres)
    EditText edtNombres;
    @BindView(R.id.edtApellidos)
    EditText edtApellidos;
    @BindView(R.id.edtCedula)
    EditText edtCedula;
    @BindView(R.id.edtContrasena)
    EditText edtContrasena;
    @BindView(R.id.edtConfirmarContrasena)
    EditText edtConfirmarContrasena;
    @BindView(R.id.edtCelular)
    EditText edtCelular;
    @BindView(R.id.spinnerInteresProductos)
    MaterialBetterSpinner spinnerInteresProductos;
    @BindView(R.id.spinnerMetodoPago)
    MaterialBetterSpinner spinnerMetodoPago;
    @BindView(R.id.spinnerBanco)
    MaterialBetterSpinner spinnerBanco;
    @BindView(R.id.edtNumeroCuenta)
    EditText edtNumeroCuenta;
    @BindView(R.id.textInputNumeroCuenta)
    TextInputLayout textInputNumeroCuenta;
    @BindView(R.id.btnRegistrarComprador)
    Button btnRegistrarComprador;
    @BindView(R.id.container)
    FrameLayout container;
    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_comprador);
        ButterKnife.bind(this);
        loadInfo();
    }

    //region Métodos Interfaz
    @Override
    @OnClick(R.id.ivBackButtonRegisterComprador)
    public void navigateToParentActivity() {
        ivBackButtonRegisterComprador.setColorFilter(getResources().getColor(R.color.colorPrimary));
        returnToParentActivity();
    }

    @Override
    public void limpiarCambios() {
        ivBackButtonRegisterComprador.setColorFilter(getResources().getColor(R.color.white));
    }

    @Override
    @OnClick(R.id.btnRegistrarComprador)
    public void registerComprador() {
        //TODO Validación de Campos
        //TODO Registro
        //TODO Muestra Progress Bar
        loadDialogoRegistroExitoso();
    }

    @Override
    public void loadDialogoRegistroExitoso() {
        View dialogo = View.inflate(this, R.layout.dialogo_registro_comprador, null);
        TextView textViewMisCultivos = dialogo.findViewById(R.id.textViewBuscarProductos);
        textViewMisCultivos.setText(getString(R.string.title_buscar_productos));

        final ImageView imageViewBuscarProductos = dialogo.findViewById(R.id.imageViewBuscarProductos);
        imageViewBuscarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewBuscarProductos.setColorFilter(getResources().getColor(R.color.colorPrimary));
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                i.putExtra("isCompradorOProductor", "comprador");
                startActivity(i);
            }
        });

        final ImageView imageViewMiCuenta = dialogo.findViewById(R.id.imageViewMiCuenta);
        imageViewMiCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageViewMiCuenta.setColorFilter(getResources().getColor(R.color.colorPrimary));
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                i.putExtra("isCompradorOProductor", "comprador");
                startActivity(i);
            }
        });


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogo);
        builder.show();
    }

    @Override
    public void loadInfo() {
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
    //endregion

    //region Métodos Generales
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


    //region Ciclo de Vida de Actividad

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
