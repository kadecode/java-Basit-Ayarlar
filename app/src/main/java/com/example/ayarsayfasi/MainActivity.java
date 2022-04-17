package com.example.ayarsayfasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView Cikti;
    private Button buttonGecis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Cikti = findViewById(R.id.Cikti);
        buttonGecis = findViewById(R.id.buttonGecis);

        buttonGecis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,AyarlaActivity2.class));
                finish();
            }
        });

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String ka = sp.getString("kullaniciAdi","Veri yok");
        boolean bildirim = sp.getBoolean("bildirim",false);
        boolean profilGuvenlik = sp.getBoolean("profilGuvenlik",false);
        String yedekSikligi = sp.getString("yedekSikligi","1");

        Cikti.setText("Kullanıcı adı : "+ka+"\n"+"Bildirim İzni : "+bildirim+"\n"
                +"Yedekleme Sıklı : "+yedekSikligi+"\n"+"Profil Güvenliği : "+profilGuvenlik);
    }
} 