package com.example.kullanc.derslerim;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ListView anaListeObje;

    private String[] dersListesi;

    private String pozisyonAnahtari = "pozisyonAnahtari";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anaListeObje = (ListView) findViewById(R.id.anaListe);


        dersListesi = new String[] { "Belge Yönetimi","Bilgi Kaynaklarının Tanımlanması","Bilgi Kullanımı","İleri Programlama","Sistem Analizi"};


        ArrayAdapter<String> basitAdaptor = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id
                .text1, dersListesi);


        anaListeObje.setAdapter(basitAdaptor);


        anaListeObje.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetayActivity.class);
                intent.putExtra(pozisyonAnahtari, position);
                startActivity(intent);

                // Toast.makeText(MainActivity.this, listeElemanlari[position], Toast.LENGTH_SHORT).show();
            }
        });



    }
}