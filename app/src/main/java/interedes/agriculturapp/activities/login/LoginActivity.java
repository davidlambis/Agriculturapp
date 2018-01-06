package interedes.agriculturapp.activities.login;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import interedes.agriculturapp.R;
import interedes.agriculturapp.activities.register_user.RegisterUserActivity;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edtCedula)
    EditText edtCedula;
    @BindView(R.id.edtContrasena)
    EditText edtContrasena;
    @BindView(R.id.fabLogin)
    FloatingActionButton fabLogin;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.textViewRegistrarse)
    TextView textViewRegistrarse;
    @BindView(R.id.container)
    ScrollView container;
    @BindView(R.id.btnLayoutRegistrarse)
    LinearLayout btnLayoutRegistrarse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        animationButton();
    }


    //region On Click Cases
    @OnClick({R.id.fabLogin, R.id.btnLayoutRegistrarse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fabLogin:
                break;
            case R.id.btnLayoutRegistrarse:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    textViewRegistrarse.setTextColor(getColor(R.color.colorPrimary));
                    startActivity(new Intent(this, RegisterUserActivity.class));
                } else {
                    startActivity(new Intent(this, RegisterUserActivity.class));
                }
                break;
        }
    }
    //endregion


    //Region Animations

    private void animationButton() {
        fabLogin.setScaleX(0);
        fabLogin.setScaleY(0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            final Interpolator interpolador = AnimationUtils.loadInterpolator(getBaseContext(),
                    android.R.interpolator.fast_out_slow_in);
            fabLogin.animate()
                    .scaleX(1)
                    .scaleY(1)
                    .setInterpolator(interpolador)
                    .setDuration(600)
                    .setStartDelay(1000)
                    .setListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            fabLogin.animate()
                                    .scaleY(1)
                                    .scaleX(1)
                                    .setInterpolator(interpolador)
                                    .setDuration(600)
                                    .start();

                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {
                        }
                    });
        }
    }
    //endregion
}
