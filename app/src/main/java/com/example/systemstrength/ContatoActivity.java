package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class ContatoActivity extends AppCompatActivity {
    LinearLayout headercontato, linearvoltaraoprincipal, lineartelefone, linearemail, linearaddress, linearsite;
    ConstraintLayout cardinfotelefones, cardinfoemail;
    LottieAnimationView fecharinfophones, fecharinfoemail;
    TextView txtphonesystem, txtphonekaua, txtphonedanilo , txtphonematheus, txtphonpedro, txtemailsystem, txtemailkaua, txtemaildanilo, txtemailmatheus, txtemailpedro;
    String cpfrecebidodaprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);
        headercontato = findViewById(R.id.headercontato);
        linearvoltaraoprincipal = findViewById(R.id.linearvoltaraoprincipal);
        cardinfotelefones = findViewById(R.id.cardinfotelefones);
        cardinfoemail = findViewById(R.id.cardinfoemail);
        lineartelefone = findViewById(R.id.lineartelefone);
        linearemail = findViewById(R.id.linearemail);
        linearaddress = findViewById(R.id.linearaddress);
        linearsite = findViewById(R.id.linearsite);
        fecharinfophones = findViewById(R.id.fecharinfophones);
        fecharinfoemail = findViewById(R.id.fecharinfoemail);
        txtphonesystem = findViewById(R.id.txtphonesystem);
        txtphonekaua = findViewById(R.id.txtphonekaua);
        txtphonedanilo = findViewById(R.id.txtphonedanilo);
        txtphonematheus = findViewById(R.id.txtphonematheus);
        txtphonpedro = findViewById(R.id.txtphonpedro);
        txtemailsystem = findViewById(R.id.txtemailsystem);
        txtemailkaua = findViewById(R.id.txtemailkaua);
        txtemaildanilo = findViewById(R.id.txtemaildanilo);
        txtemailmatheus = findViewById(R.id.txtemailmatheus);
        txtemailpedro = findViewById(R.id.txtemailpedro);

        //  Get some information
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidodaprincipal = bundle.getString("cpfusu");

        //  When click here will show some msg em try to go website
        linearsite.setOnClickListener(v -> Toast.makeText(this, "Site em manutenção!!", Toast.LENGTH_SHORT).show());

        //  When click here will open info menu phones
        lineartelefone.setOnClickListener(v -> {
            if (cardinfotelefones.getVisibility() == View.VISIBLE){
                headercontato.setVisibility(View.VISIBLE);
                cardinfotelefones.setVisibility(View.GONE);
                cardinfoemail.setVisibility(View.GONE);
            }else {
                headercontato.setVisibility(View.GONE);
                cardinfotelefones.setVisibility(View.VISIBLE);
            }
        });

        //  When click here will call for System Strength
        txtphonesystem.setOnClickListener(v -> {
            Uri number = Uri.parse("tel:380394002");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
        });

        //  When click here will call for Kauã
        txtphonekaua.setOnClickListener(v -> {
            Uri number = Uri.parse("tel:998022004");
            Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
            startActivity(callIntent);
        });

        //  When click here will close info menu phones
        fecharinfophones.setOnClickListener(v -> {
            headercontato.setVisibility(View.VISIBLE);
            cardinfotelefones.setVisibility(View.GONE);
        });

        //  When click here will open info menu email
        linearemail.setOnClickListener(v -> {
            if (cardinfoemail.getVisibility() == View.VISIBLE){
                headercontato.setVisibility(View.VISIBLE);
                cardinfotelefones.setVisibility(View.GONE);
                cardinfoemail.setVisibility(View.GONE);
            }else {
                headercontato.setVisibility(View.GONE);
                cardinfotelefones.setVisibility(View.GONE);
                cardinfoemail.setVisibility(View.VISIBLE);
            }
        });

        //  When click here will close info menu email
        fecharinfoemail.setOnClickListener(v -> {
            headercontato.setVisibility(View.VISIBLE);
            cardinfoemail.setVisibility(View.GONE);
        });

        linearaddress.setOnClickListener(v -> {
            Intent irparamapa = new Intent(ContatoActivity.this,MapsActivity.class);
            startActivity(irparamapa);
        });

        //  When click here will go back to Principal Activity
        linearvoltaraoprincipal.setOnClickListener(v -> {
            Intent voltaraoprincipal = new Intent(ContatoActivity.this,PrincipalActivity.class);
            voltaraoprincipal.putExtra("cpfusu", cpfrecebidodaprincipal);
            startActivity(voltaraoprincipal);
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        if (cardinfotelefones.getVisibility() == View.VISIBLE || cardinfoemail.getVisibility() == View.VISIBLE){
            headercontato.setVisibility(View.VISIBLE);
            cardinfotelefones.setVisibility(View.GONE);
            cardinfoemail.setVisibility(View.GONE);
        }else {
            Intent voltaraoprincipal = new Intent(ContatoActivity.this,PrincipalActivity.class);
            voltaraoprincipal.putExtra("cpfusu", cpfrecebidodaprincipal);
            startActivity(voltaraoprincipal);
            finish();
        }
    }
}