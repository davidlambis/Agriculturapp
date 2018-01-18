package interedes.agriculturapp.activities.register_user;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.comprador.RegisterCompradorActivity;
import interedes.agriculturapp.activities.productor.RegisterProductorActivity;

public class RegisterUserActivity extends AppCompatActivity implements RegisterUserView {


    @BindView(R.id.imageViewBackButton)
    ImageView imageViewBackButton;
    @BindView(R.id.imageViewProductor)
    ImageView imageViewProductor;
    @BindView(R.id.linearLayoutProductor)
    LinearLayout linearLayoutProductor;
    @BindView(R.id.imageViewComprador)
    ImageView imageViewComprador;
    @BindView(R.id.linearLayoutComprador)
    LinearLayout linearLayoutComprador;
    @BindView(R.id.textViewAyudaRegistro)
    TextView textViewAyudaRegistro;
    @BindView(R.id.linearLayoutAyudaRegistro)
    LinearLayout linearLayoutAyudaRegistro;
    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        ButterKnife.bind(this);

    }

    //region Métodos Interfaz
    @Override
    @OnClick(R.id.linearLayoutProductor)
    public void navigateToRegistrarProductor() {
        imageViewProductor.setColorFilter(getResources().getColor(R.color.colorPrimary));
        startActivity(new Intent(this, RegisterProductorActivity.class));
    }

    @Override
    @OnClick(R.id.linearLayoutComprador)
    public void navigateToRegistrarComprador() {
        imageViewComprador.setColorFilter(getResources().getColor(R.color.colorPrimary));
        startActivity(new Intent(this, RegisterCompradorActivity.class));
    }

    @Override
    @OnClick(R.id.linearLayoutAyudaRegistro)
    public void navigateToAyudaRegistro() {
        textViewAyudaRegistro.setTextColor(getResources().getColor(R.color.colorPrimary));
        Snackbar.make(container, "Go to Ayuda Registro", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    @OnClick(R.id.imageViewBackButton)
    public void navigateToParentActivity() {
        imageViewBackButton.setColorFilter(getResources().getColor(R.color.colorPrimary));
        returnToParentActivity();
    }

    @Override
    public void limpiarCambios() {
        imageViewProductor.setColorFilter(getResources().getColor(R.color.white));
        imageViewComprador.setColorFilter(getResources().getColor(R.color.white));
        textViewAyudaRegistro.setTextColor(getResources().getColor(R.color.white));
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
