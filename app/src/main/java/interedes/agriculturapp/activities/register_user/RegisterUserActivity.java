package interedes.agriculturapp.activities.register_user;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.comprador.RegisterCompradorActivity;
import interedes.agriculturapp.activities.productor.RegisterProductorActivity;

public class RegisterUserActivity extends AppCompatActivity {

    //UI Elements
    @BindView(R.id.btnLayoutProductor)
    LinearLayout btnLayoutProductor;
    @BindView(R.id.btnLayoutComprador)
    LinearLayout btnLayoutComprador;

    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.imageViewBackButton)
    ImageView imageViewBackButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        ButterKnife.bind(this);

    }


    //region ON CLICK
    @OnClick({R.id.btnLayoutProductor, R.id.btnLayoutComprador, R.id.imageViewBackButton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLayoutProductor:
                startActivity(new Intent(this, RegisterProductorActivity.class));
                break;
            case R.id.btnLayoutComprador:
                startActivity(new Intent(this, RegisterCompradorActivity.class));
                break;
            case R.id.imageViewBackButton:
                returnToParentActivity();
                break;
        }
    }
    //endregion

    //region METHODS
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
