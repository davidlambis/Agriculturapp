package interedes.agriculturapp.activities.productor.asistencia_tecnica_productor.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import interedes.agriculturapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductoPlagasFragment extends Fragment {


    public ProductoPlagasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_producto_plagas, container, false);
    }

}
