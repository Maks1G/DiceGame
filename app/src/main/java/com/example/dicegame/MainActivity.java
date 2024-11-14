package com.example.dicegame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int liczba_rzutow = 0;
    private int Wynik = 0;
    private Button Rzut;
    private Button Reset;
    private TextView kostka1;
    private TextView kostka2;
    private TextView kostka3;
    private TextView kostka4;
    private TextView kostka5;
    private TextView liczba_r;
    private TextView wynik;
    private TextView WynikGry;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        Rzut = findViewById(R.id.Rzut);
        Reset = findViewById(R.id.Reset);
        kostka1 = findViewById(R.id.kostka1);
        kostka2 = findViewById(R.id.kostka2);
        kostka3 = findViewById(R.id.kostka3);
        kostka4 = findViewById(R.id.kostka4);
        kostka5 = findViewById(R.id.kostka5);
        wynik = findViewById(R.id.Wynik);
        WynikGry = findViewById(R.id.wynikGry);
        liczba_r = findViewById(R.id.liczbaRzutow);
        random = new Random();


        Rzut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liczba_rzutow++;
                liczba_r.setText("Liczba rzutów: " + liczba_rzutow);


                kostka1.setText(String.valueOf(random.nextInt(6) + 1));
                kostka2.setText(String.valueOf(random.nextInt(6) + 1));
                kostka3.setText(String.valueOf(random.nextInt(6) + 1));
                kostka4.setText(String.valueOf(random.nextInt(6) + 1));
                kostka5.setText(String.valueOf(random.nextInt(6) + 1));


                int wartosc1 = Integer.parseInt(String.valueOf(kostka1.getText()));
                int wartosc2 = Integer.parseInt(String.valueOf(kostka2.getText()));
                int wartosc3 = Integer.parseInt(String.valueOf(kostka3.getText()));
                int wartosc4 = Integer.parseInt(String.valueOf(kostka4.getText()));
                int wartosc5 = Integer.parseInt(String.valueOf(kostka5.getText()));

                Wynik = wartosc1 + wartosc2 + wartosc3 + wartosc4 + wartosc5;
                wynik.setText("Wynik tego losowania: " + Wynik);
                Wynik = 0;


                int[] values = {wartosc1, wartosc2, wartosc3, wartosc4, wartosc5};
                for (int i = 1; i <= 6; i++) {
                    int count = 0;
                    for (int value : values) {
                        if (value == i) {
                            count++;
                        }
                    }
                    if (count > 1) {
                        Wynik = Wynik + i * count;
                    }
                }
                WynikGry.setText("Wynik gry: " + Wynik);
            }
        });


        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liczba_rzutow = 0;
                Wynik = 0;
                liczba_r.setText("Liczba rzutów: " + liczba_rzutow);
                wynik.setText("Wynik tego losowania: " + Wynik);
                WynikGry.setText("Wynik gry: " + Wynik);
                kostka1.setText("?");
                kostka2.setText("?");
                kostka3.setText("?");
                kostka4.setText("?");
                kostka5.setText("?");
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
