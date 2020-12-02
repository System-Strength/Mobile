package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.airbnb.lottie.LottieAnimationView;

public class LicenseActivity extends AppCompatActivity {
    LinearLayout linearlicensevoltaraoprincipal;
    Button btnlicensa;
    LottieAnimationView licenseanimacaovoltaraoprincipal, animationinfo;
    ConstraintLayout contenderanimationinfo, contenderallinformation;
    String cpfrecebidoprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        linearlicensevoltaraoprincipal = findViewById(R.id.linearlicensevoltaraoprincipal);
        licenseanimacaovoltaraoprincipal = findViewById(R.id.licenseanimacaovoltaraoprincipal);
        contenderanimationinfo = findViewById(R.id.contenderanimationinfo);
        contenderallinformation = findViewById(R.id.contenderallinformation);
        animationinfo = findViewById(R.id.animationinfo);
        btnlicensa = findViewById(R.id.btnlicensa);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidoprincipal = bundle.getString("cpfusu");

        //  Set time to show information
        contenderanimationinfo.setVisibility(View.VISIBLE);
        contenderallinformation.setVisibility(View.GONE);
        animationinfo.setSpeed(2);
        new Handler().postDelayed(()-> {
            contenderanimationinfo.setVisibility(View.GONE);
            contenderallinformation.setVisibility(View.VISIBLE);
        },1900);

        //  When click here will go to come back to PrincipalActivity
        linearlicensevoltaraoprincipal.setOnClickListener(v -> {
            licenseanimacaovoltaraoprincipal.playAnimation();
            new Handler().postDelayed(()-> {
                Intent voltaraoprincipal = new Intent(LicenseActivity.this,PrincipalActivity.class);
                voltaraoprincipal.putExtra("cpfusu", cpfrecebidoprincipal);
                startActivity(voltaraoprincipal);
            },600);
        });
    }

    @Override
    public void onBackPressed() {
        Intent voltaraoprincipal = new Intent(LicenseActivity.this,PrincipalActivity.class);
        voltaraoprincipal.putExtra("cpfusu", cpfrecebidoprincipal);
        startActivity(voltaraoprincipal);
    }
}