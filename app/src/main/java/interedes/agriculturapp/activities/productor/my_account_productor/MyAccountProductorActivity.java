package interedes.agriculturapp.activities.productor.my_account_productor;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.productor.asistencia_tecnica_productor.AsistenciaTecnicaProductorActivity;
import interedes.agriculturapp.activities.productor.mis_clientes_productor.MisClientesProductorActivity;
import interedes.agriculturapp.activities.productor.mis_cultivos_productor.MisCultivosProductorActivity;
import interedes.agriculturapp.activities.productor.mis_ofertas_productor.MisOfertasProductorActivity;
import interedes.agriculturapp.activities.productor.mis_preguntas_productor.MisPreguntasProductorActivity;
import interedes.agriculturapp.activities.productor.mis_ventas_productor.MisVentasProductorActivity;

public class MyAccountProductorActivity extends AppCompatActivity implements MyAccountProductorView {

    @BindView(R.id.imageViewBackButton)
    ImageView imageViewBackButton;
    @BindView(R.id.btnAgregarProducto)
    Button btnAgregarProducto;
    @BindView(R.id.imageViewCultivos)
    ImageView imageViewCultivos;
    @BindView(R.id.textViewCultivos)
    TextView textViewCultivos;
    @BindView(R.id.linearLayoutMisCultivos)
    LinearLayout linearLayoutMisCultivos;
    @BindView(R.id.imageViewPreguntas)
    ImageView imageViewPreguntas;
    @BindView(R.id.textViewPreguntas)
    TextView textViewPreguntas;
    @BindView(R.id.linearLayoutPreguntas)
    LinearLayout linearLayoutPreguntas;
    @BindView(R.id.imageViewOfertas)
    ImageView imageViewOfertas;
    @BindView(R.id.textViewOfertas)
    TextView textViewOfertas;
    @BindView(R.id.linearLayoutOfertas)
    LinearLayout linearLayoutOfertas;
    @BindView(R.id.imageViewVentas)
    ImageView imageViewVentas;
    @BindView(R.id.textViewVentas)
    TextView textViewVentas;
    @BindView(R.id.linearLayoutVentasRealizadas)
    LinearLayout linearLayoutVentasRealizadas;
    @BindView(R.id.imageViewClientes)
    ImageView imageViewClientes;
    @BindView(R.id.textViewClientes)
    TextView textViewClientes;
    @BindView(R.id.linearLayoutClientes)
    LinearLayout linearLayoutClientes;
    @BindView(R.id.imageViewPlagas)
    ImageView imageViewPlagas;
    @BindView(R.id.textViewPlagas)
    TextView textViewPlagas;
    @BindView(R.id.linearLayoutPlagas)
    LinearLayout linearLayoutPlagas;
    @BindView(R.id.imageViewEnfermedades)
    ImageView imageViewEnfermedades;
    @BindView(R.id.textViewEnfermedades)
    TextView textViewEnfermedades;
    @BindView(R.id.linearLayoutEnfermedades)
    LinearLayout linearLayoutEnfermedades;
    @BindView(R.id.imageViewInsumos)
    ImageView imageViewInsumos;
    @BindView(R.id.textViewInsumos)
    TextView textViewInsumos;
    @BindView(R.id.linearLayoutInsumos)
    LinearLayout linearLayoutInsumos;
    @BindView(R.id.imageViewPreguntasFrecuentes)
    ImageView imageViewPreguntasFrecuentes;
    @BindView(R.id.textViewPreguntasFrecuentes)
    TextView textViewPreguntasFrecuentes;
    @BindView(R.id.linearLayoutPreguntasFrecuentes)
    LinearLayout linearLayoutPreguntasFrecuentes;
    @BindView(R.id.imageViewBusqueda)
    ImageView imageViewBusqueda;
    @BindView(R.id.textViewBusqueda)
    TextView textViewBusqueda;
    @BindView(R.id.linearLayoutBusqueda)
    LinearLayout linearLayoutBusqueda;
    @BindView(R.id.imageViewTotal)
    ImageView imageViewTotal;
    @BindView(R.id.textViewTotal)
    TextView textViewTotal;
    @BindView(R.id.linearLayoutTotal)
    LinearLayout linearLayoutTotal;
    @BindView(R.id.imageViewClientesContabilidad)
    ImageView imageViewClientesContabilidad;
    @BindView(R.id.textViewClientesContabilidad)
    TextView textViewClientesContabilidad;
    @BindView(R.id.linearLayoutClientesContabilidad)
    LinearLayout linearLayoutClientesContabilidad;
    @BindView(R.id.imageViewEditarCuenta)
    ImageView imageViewEditarCuenta;
    @BindView(R.id.textViewEditarCuenta)
    TextView textViewEditarCuenta;
    @BindView(R.id.linearLayoutEditarCuenta)
    LinearLayout linearLayoutEditarCuenta;
    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_productor);
        ButterKnife.bind(this);
    }


    //region Métodos Interfaz
    @Override
    @OnClick(R.id.imageViewBackButton)
    public void navigateToParentActivity() {
        imageViewBackButton.setColorFilter(getResources().getColor(R.color.colorPrimary));
        returnToParentActivity();
    }

    @Override
    public void navigateToAgregarProducto() {
        //TODO
    }

    @Override
    @OnClick(R.id.linearLayoutMisCultivos)
    public void navigateToMisCultivos() {
        imageViewCultivos.setColorFilter(getResources().getColor(R.color.colorPrimary));
        textViewCultivos.setTextColor(getResources().getColor(R.color.colorPrimary));
        Intent i = new Intent(this, MisCultivosProductorActivity.class);
        startActivity(i);
    }

    @Override
    @OnClick(R.id.linearLayoutPreguntas)
    public void navigateToPreguntas() {
        imageViewPreguntas.setColorFilter(getResources().getColor(R.color.colorPrimary));
        textViewPreguntas.setTextColor(getResources().getColor(R.color.colorPrimary));
        Intent i = new Intent(this, MisPreguntasProductorActivity.class);
        startActivity(i);
    }

    @Override
    @OnClick(R.id.linearLayoutOfertas)
    public void navigateToOfertas() {
        imageViewOfertas.setColorFilter(getResources().getColor(R.color.colorPrimary));
        textViewOfertas.setTextColor(getResources().getColor(R.color.colorPrimary));
        Intent i = new Intent(this, MisOfertasProductorActivity.class);
        startActivity(i);
    }

    @Override
    @OnClick(R.id.linearLayoutVentasRealizadas)
    public void navigateToVentas() {
        imageViewVentas.setColorFilter(getResources().getColor(R.color.colorPrimary));
        textViewVentas.setTextColor(getResources().getColor(R.color.colorPrimary));
        Intent i = new Intent(this, MisVentasProductorActivity.class);
        startActivity(i);
    }

    @Override
    @OnClick(R.id.linearLayoutClientes)
    public void navigateToClientes() {
        imageViewClientes.setColorFilter(getResources().getColor(R.color.colorPrimary));
        textViewClientes.setTextColor(getResources().getColor(R.color.colorPrimary));
        Intent i = new Intent(this, MisClientesProductorActivity.class);
        startActivity(i);
    }

    @Override
    @OnClick(R.id.linearLayoutPlagas)
    public void navigateToPlagas() {
        imageViewPlagas.setColorFilter(getResources().getColor(R.color.colorPrimary));
        textViewPlagas.setTextColor(getResources().getColor(R.color.colorPrimary));
        Intent i = new Intent(this, AsistenciaTecnicaProductorActivity.class);
        startActivity(i);
    }

    @Override
    public void navigateToEnfermedades() {

    }

    @Override
    public void navigateToInsumos() {

    }

    @Override
    public void navigateToPreguntasFrecuentes() {

    }

    @Override
    public void navigateToBusqueda() {

    }

    @Override
    public void navigateToTotal() {

    }

    @Override
    public void navigateToEditarCuenta() {

    }

    @Override
    public void limpiarCambios() {
        imageViewBackButton.setColorFilter(getResources().getColor(R.color.white));
        imageViewVentas.setColorFilter(getResources().getColor(R.color.white));
        textViewVentas.setTextColor(getResources().getColor(R.color.white));
        imageViewCultivos.setColorFilter(getResources().getColor(R.color.white));
        textViewCultivos.setTextColor(getResources().getColor(R.color.white));
        imageViewPreguntas.setColorFilter(getResources().getColor(R.color.white));
        textViewPreguntas.setTextColor(getResources().getColor(R.color.white));
        imageViewOfertas.setColorFilter(getResources().getColor(R.color.white));
        textViewOfertas.setTextColor(getResources().getColor(R.color.white));
        imageViewClientes.setColorFilter(getResources().getColor(R.color.white));
        textViewClientes.setTextColor(getResources().getColor(R.color.white));
        imageViewPlagas.setColorFilter(getResources().getColor(R.color.white));
        textViewPlagas.setTextColor(getResources().getColor(R.color.white));
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
