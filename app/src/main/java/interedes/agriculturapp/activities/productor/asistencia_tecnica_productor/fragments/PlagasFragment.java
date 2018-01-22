package interedes.agriculturapp.activities.productor.asistencia_tecnica_productor.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.productor.asistencia_tecnica_productor.AsistenciaTecnicaProductorActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlagasFragment extends Fragment {


    @BindView(R.id.btnCargarOtroFragmento)
    Button btnCargarOtroFragmento;
    Unbinder unbinder;

    public PlagasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plagas, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btnCargarOtroFragmento)
    public void onViewClicked() {
        Fragment newFragment = new ProductoPlagasFragment();
        ((AsistenciaTecnicaProductorActivity) getActivity()).replaceFragment(newFragment);
    }
}
