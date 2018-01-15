package interedes.agriculturapp.activities.comprador.mercado_comprador;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;

public class MercadoCompradorActivity extends AppCompatActivity {

    @BindView(R.id.imageViewBackButton)
    ImageView imageViewBackButton;
    @BindView(R.id.recyclerViewProductosMercado)
    RecyclerView recyclerViewProductosMercado;
    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado_comprador);
        ButterKnife.bind(this);
    }

    //region On Click
    @OnClick(R.id.imageViewBackButton)
    public void onViewClicked() {


    }
    //endregion
}
