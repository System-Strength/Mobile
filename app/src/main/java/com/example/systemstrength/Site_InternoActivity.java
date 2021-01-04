package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Site_InternoActivity extends AppCompatActivity {
    WebView view_website;
    String cpfrecebidodaprincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site__interno);
        view_website = findViewById(R.id.view_website);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cpfrecebidodaprincipal = bundle.getString("cpfusu");

        view_website.loadUrl("https://www.kauavitorio.com");
        view_website.getSettings().setJavaScriptEnabled(true);
        view_website.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        Intent voltar_contato = new Intent(Site_InternoActivity.this,ContatoActivity.class);
        voltar_contato.putExtra("cpfusu", cpfrecebidodaprincipal);
        startActivity(voltar_contato);
        finish();
    }
}