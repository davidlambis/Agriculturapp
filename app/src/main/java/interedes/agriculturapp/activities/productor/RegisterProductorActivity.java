package interedes.agriculturapp.activities.productor;

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

import com.twinkle94.monthyearpicker.picker.YearMonthPickerDialog;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;

public class RegisterProductorActivity extends AppCompatActivity {

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
    @BindView(R.id.edtNombreFinca)
    EditText edtNombreFinca;
    @BindView(R.id.edtLocalizacionFinca)
    EditText edtLocalizacionFinca;
    @BindView(R.id.imageViewLocalizarFinca)
    ImageView imageViewLocalizarFinca;
    @BindView(R.id.btnRegistrarProductor)
    Button btnRegistrarProductor;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.spinnerMetodoPago)
    MaterialBetterSpinner spinnerMetodoPago;
    @BindView(R.id.spinnerBanco)
    MaterialBetterSpinner spinnerBanco;
    @BindView(R.id.textInputNumeroCuenta)
    TextInputLayout textInputNumeroCuenta;
    @BindView(R.id.edtNumeroCuenta)
    EditText edtNumeroCuenta;
    @BindView(R.id.spinnerTipoProducto)
    MaterialBetterSpinner spinnerTipoProducto;
    @BindView(R.id.edtMesSiembra)
    EditText edtMesSiembra;
    @BindView(R.id.edtMesCosecha)
    EditText edtMesCosecha;

    //Variables Globales
    private boolean is_mes_cultivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_productor);
        ButterKnife.bind(this);
        loadCoordenadas();
        loadInfo();
    }


    //region On Click
    @OnClick({R.id.ivBackButtonRegisterComprador, R.id.imageViewLocalizarFinca, R.id.btnRegistrarProductor, R.id.edtMesSiembra, R.id.edtMesCosecha})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivBackButtonRegisterComprador:
                returnToParentActivity();
                break;
            case R.id.imageViewLocalizarFinca:
                break;
            case R.id.btnRegistrarProductor:
                break;
            case R.id.edtMesSiembra:
                is_mes_cultivo = true;
                loadMeses();
                break;
            case R.id.edtMesCosecha:
                is_mes_cultivo = false;
                loadMeses();
                break;
            default:
                break;
        }
    }
    //endregion


    //region Methods
    private void loadCoordenadas() {
        edtLocalizacionFinca.setText("75.921231, -4.23132");
    }

    private void loadInfo() {
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

        //Spinner Tipo Producto
        String[] itemsTipoProducto = {"Aguacate", "Cacao", "Fríjol"};
        final List<String> tipoProductoList = new ArrayList<>();
        tipoProductoList.addAll(Arrays.asList(itemsTipoProducto));
        spinnerTipoProducto.setAdapter(null);
        ArrayAdapter<String> tipoProductoArrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tipoProductoList);
        spinnerTipoProducto.setAdapter(tipoProductoArrayAdapter);
    }

    private void loadMeses() {
        YearMonthPickerDialog yearMonthPickerDialog = new YearMonthPickerDialog(this, new YearMonthPickerDialog.OnDateSetListener() {
            @Override
            public void onYearMonthSet(int year, int month) {
                /*Locale locale = getResources().getConfiguration().locale;
                Locale.setDefault(locale);*/
                Locale spanish = new Locale("es", "ES");
                Locale.setDefault(spanish);
                Calendar calendar = Calendar.getInstance(spanish);
                calendar.set(Calendar.YEAR, year);
                //month = Integer.parseInt(calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault()));
                calendar.set(Calendar.MONTH, month);


                SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");

                if (is_mes_cultivo) {
                    edtMesSiembra.setText(dateFormat.format(calendar.getTime()));
                } else {
                    edtMesCosecha.setText(dateFormat.format(calendar.getTime()));
                }
            }
        });

        yearMonthPickerDialog.show();
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
