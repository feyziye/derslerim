package com.example.kullanc.derslerim;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.net.Uri;
import android.widget.ImageView;
public class DetayActivity extends AppCompatActivity {

    private TextView detayText;
    private ImageView detayImage;
    private String[] detayListe;
    private int[] detayImageListe;
    private String[] detayUrlListe;
    private String pozisyonAnahtari = "pozisyonAnahtari";

    private int detayPozisyon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        detayText = (TextView) findViewById(R.id.detayView);
        detayImage = (ImageView) findViewById(R.id.ImageView);
        detayListe = new String[] { "          Dersin web sitesine gitmek için resime tıklayın \n\n\nÇarşamba günleri \nSaat: 13.30\nYer:Emel Doğramacı amfisi","          Dersin web sitesine gitmek için resime tıklayın\n\n\nPerşembe günleri\nSaat 9.30\nYer:b8-103","          Dersin web sitesine gitmek için resime tıklayın\n\n\nÇarşamba günleri\nSaat 9.30\nYer:Emel Doğramacı amfisi","          Dersin web sitesine gitmek için resime tıklayın\n\n\nCuma günleri\nSaat 13.30\nYer:b8-101","          Dersin web sitesine gitmek için resime tıklayın\n\n\nPerşembe günleri\nSaat 13.30\nYer:b8-103"};
        detayImageListe = new int[] {R.drawable.bir, R.drawable.iki, R.drawable.uc, R.drawable.dort, R.drawable.bes};
        detayUrlListe = new String[] {"http://www.bby.hacettepe.edu.tr/akademik/ozgurkulcu/index.asp?d=14.html&dil=tr", "http://www.acikders.net/enrol/index.php?id=128", "http://bby253.blogspot.com.tr/", "http://madran.net", "http://www.bby.hacettepe.edu.tr/bilgisistemi/"};

        detayPozisyon = getIntent().getIntExtra(pozisyonAnahtari, -1);


        if (detayPozisyon == -1) {
            Toast.makeText(DetayActivity.this, "Hata Var!", Toast.LENGTH_LONG).show();
        } else {
            //detayText.setText(detayListe[detayPozisyon]);
            detayText.setText(detayListe[detayPozisyon]);
            detayImage.setImageResource(detayImageListe[detayPozisyon]);
        }


        detayImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (detayPozisyon == -1) {
                    Toast.makeText(DetayActivity.this, "Hata Var!", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(detayUrlListe[detayPozisyon]));
                    startActivity(i);
                }

            }
        });
    }
}