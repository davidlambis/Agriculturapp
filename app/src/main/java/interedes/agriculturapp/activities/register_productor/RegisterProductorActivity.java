package interedes.agriculturapp.activities.register_productor;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_productor);
        ButterKnife.bind(this);
    }


    //region On Click
    @OnClick({R.id.ivBackButtonRegisterComprador, R.id.imageViewLocalizarFinca, R.id.btnRegistrarProductor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivBackButtonRegisterComprador:
                returnToParentActivity();
                break;
            case R.id.imageViewLocalizarFinca:
                break;
            case R.id.btnRegistrarProductor:
                break;
        }
    }
    //endregion


    //region Methods
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
