package interedes.agriculturapp.activities.comprador.my_account_comprador;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;

public class MyAccountCompradorActivity extends AppCompatActivity implements MyAccountCompradorView {

    @BindView(R.id.linearLayoutProveedores)
    LinearLayout linearLayoutProveedores;
    @BindView(R.id.linearLayoutPreguntas)
    LinearLayout linearLayoutPreguntas;
    @BindView(R.id.linearLayoutOfertas)
    LinearLayout linearLayoutOfertas;
    @BindView(R.id.linearLayoutComprasRealizadas)
    LinearLayout linearLayoutComprasRealizadas;
    @BindView(R.id.linearLayoutProductosInteres)
    LinearLayout linearLayoutProductosInteres;
    @BindView(R.id.linearLayoutEditarCuenta)
    LinearLayout linearLayoutEditarCuenta;
    @BindView(R.id.imageViewBackButton)
    ImageView imageViewBackButton;
    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account_comprador);
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
    public void limpiarCambios() {
        imageViewBackButton.setColorFilter(getResources().getColor(R.color.white));
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


}
