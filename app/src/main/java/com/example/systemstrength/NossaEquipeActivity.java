package com.example.systemstrength;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class NossaEquipeActivity extends AppCompatActivity {
    LinearLayout linearbtnvoltarnossaequipe;
    /**                                Instagram                                  **/ /**             GitHub                                                                        **/  /**                                      Twitter                                                 **/
    CardView cardviewinstadanilo, cardViewinstakaua, cardViewinstamatheus, cardViewinstapedro, cardviewbtngithubdanilo, cardviewbtngithubkaua, cardviewbtngithubmatheus, cardviewbtngithubpedro, cardviewbtntwitterdanilo, cardviewbtntwitterkaua, cardviewbtntwittermatheus, cardviewbtntwitterpedro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nossa_equipe);
        linearbtnvoltarnossaequipe = findViewById(R.id.linearbtnvoltarnossaequipe);
        /**                              Instagram                              **/
        cardviewinstadanilo = findViewById(R.id.cardviewinstadanilo);
        cardViewinstakaua = findViewById(R.id.cardViewinstakaua);
        cardViewinstamatheus = findViewById(R.id.cardViewinstamatheus);
        cardViewinstapedro = findViewById(R.id.cardViewinstapedro);
        /**                             GitHub                                  **/
        cardviewbtngithubdanilo = findViewById(R.id.cardviewbtngithubdanilo);
        cardviewbtngithubkaua = findViewById(R.id.cardviewbtngithubkaua);
        cardviewbtngithubmatheus = findViewById(R.id.cardviewbtngithubmatheus);
        cardviewbtngithubpedro = findViewById(R.id.cardviewbtngithubpedro);
        /**                             Twitter                                 **/
        cardviewbtntwitterdanilo = findViewById(R.id.cardviewbtntwitterdanilo);
        cardviewbtntwitterkaua = findViewById(R.id.cardviewbtntwitterkaua);
        cardviewbtntwittermatheus = findViewById(R.id.cardviewbtntwittermatheus);
        cardviewbtntwitterpedro = findViewById(R.id.cardviewbtntwitterpedro);

        //  When is clicked in this Linear Activity is finish
        linearbtnvoltarnossaequipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //  When is clicked in this cadview go to Instagram Page of Danilo
        cardviewinstadanilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri insta = Uri.parse("https://www.instagram.com/systemstrength/");
                Intent instaintent = new Intent(Intent.ACTION_VIEW, insta);
                startActivity(instaintent);
            }
        });

        //  When is clicked in this cadview go to Instagram Page of Kauã
        cardViewinstakaua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri insta = Uri.parse("https://www.instagram.com/ka_vitorio/");
                Intent instaintent = new Intent(Intent.ACTION_VIEW, insta);
                startActivity(instaintent);
            }
        });

        //  When is clicked in this cadview go to Instagram Page of Matheus
        cardViewinstamatheus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri insta = Uri.parse("https://www.instagram.com/matheusssleite/");
                Intent instaintent = new Intent(Intent.ACTION_VIEW, insta);
                startActivity(instaintent);
            }
        });

        //  When is clicked in this cadview go to Instagram Page of Pedro
        cardViewinstapedro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri insta = Uri.parse("https://www.instagram.com/pedrohmmf03/");
                Intent instaintent = new Intent(Intent.ACTION_VIEW, insta);
                startActivity(instaintent);
            }
        });

        //  When is clicked in this cadview go to GitHub Page of Danilo
        cardviewbtngithubdanilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri git = Uri.parse("https://github.com/daniloosi");
                Intent gitintent = new Intent(Intent.ACTION_VIEW, git);
                startActivity(gitintent);
            }
        });

        //  When is clicked in this cadview go to GitHub Page of Kauã
        cardviewbtngithubkaua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri git = Uri.parse("https://github.com/Kauavitorio");
                Intent gitintent = new Intent(Intent.ACTION_VIEW, git);
                startActivity(gitintent);
            }
        });

        //  When is clicked in this cadview go to GitHub Page of Matheus
        cardviewbtngithubmatheus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri git = Uri.parse("https://github.com/Theus03");
                Intent gitintent = new Intent(Intent.ACTION_VIEW, git);
                startActivity(gitintent);
            }
        });

        //  When is clicked in this cadview go to GitHub Page of Pedro
        cardviewbtngithubpedro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Uri git = Uri.parse("https://github.com/pedrohmmf");
                Intent gitintent = new Intent(Intent.ACTION_VIEW, git);
                startActivity(gitintent);
            }
        });

        //  When is clicked in this cadview go to Twitter Page of Danilo (under development)
        cardviewbtntwitterdanilo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //  When is clicked in this cadview go to Twitter Page of Kauã
        cardviewbtntwitterkaua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri twitter = Uri.parse("https://twitter.com/kauavitorioofc");
                Intent gitintent = new Intent(Intent.ACTION_VIEW, twitter);
                startActivity(gitintent);
            }
        });

        //  When is clicked in this cadview go to Twitter Page of Matheus (under development)
        cardviewbtntwittermatheus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //  When is clicked in this cadview go to Twitter Page of Pedro (under development)
        cardviewbtntwitterpedro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}