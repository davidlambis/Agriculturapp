package interedes.agriculturapp.activities.productor.asistencia_tecnica_productor;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.productor.asistencia_tecnica_productor.fragments.PlagasFragment;

public class AsistenciaTecnicaProductorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistencia_tecnica_productor);
        loadFragment();

    }

    private void loadFragment() {
        Fragment fm = new PlagasFragment();
        this.setDefaultFragment(fm);

        /*
        Button btnCargarOtroFragmento = findViewById(R.id.btnCargarOtroFragmento);
        btnCargarOtroFragmento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AsistenciaTecnicaProductorActivity.this, "Carga Otro Fragmento", Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    // This method is used to set the default fragment that will be shown.
    private void setDefaultFragment(Fragment defaultFragment) {
        this.replaceFragment(defaultFragment);
    }

    // Replace current Fragment with the destination Fragment.
    public void replaceFragment(Fragment destFragment) {
        // First get FragmentManager object.
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        // Begin Fragment transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(R.id.recyclerViewFragment, destFragment);

        // Commit the Fragment replace action.
        fragmentTransaction.commit();
    }
}
