package com.example.thinkanumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView kocka1,kocka2;
    Button egyKocka, ketKocka, reset, dobas;
    TextView lista;
    String szoveg = "";
    Boolean egyKockaE = false;
    public AlertDialog.Builder alertBuilder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        kocka1 = findViewById(R.id.img_kocka1);
        kocka2 = findViewById(R.id.img_kocka2);
        egyKocka = findViewById(R.id.btn_egyKocka);
        ketKocka = findViewById(R.id.btn_ketKocka);
        reset = findViewById(R.id.btn_reset);
        dobas = findViewById(R.id.btn_dobas);
        lista = findViewById(R.id.txt_Lista);
        alertBuilder = new AlertDialog.Builder(this);
        CreateAlertDialog();
    }
    private void CreateAlertDialog() {
        alertBuilder.setMessage("Biztosan törölni szeretné?");
        alertBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                closeContextMenu();
            }
        });
        alertBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                szoveg = "";
                lista.setText(szoveg);
                closeContextMenu();
            }
        });
        alertBuilder.setCancelable(false);
    }

    public void egyKockaClick(View view) {
        kocka2.setVisibility(View.GONE);
        egyKockaE = true;
    }

    public void ketKockaClick(View view) {
        kocka2.setVisibility(View.VISIBLE);
        egyKockaE = false;
    }

    public void dobasClick(View view) {
        if (egyKockaE) {
            Random rnd = new Random();
            Integer i = rnd.nextInt(6) + 1;
            if (i == 1) {
                kocka1.setImageResource(R.drawable.kocka1);
            }
            if (i == 2) {
                kocka1.setImageResource(R.drawable.kocka2);
            }
            if (i == 3) {
                kocka1.setImageResource(R.drawable.kocka3);
            }
            if (i == 4) {
                kocka1.setImageResource(R.drawable.kocka4);
            }
            if (i == 5) {
                kocka1.setImageResource(R.drawable.kocka5);
            }
            if (i == 6) {
                kocka1.setImageResource(R.drawable.kocka6);
            }
            String aktualisSzam = String.valueOf(i);
            szoveg = szoveg + "\n" + aktualisSzam;
            lista.setText(szoveg);
        }else {
            Random rnd = new Random();
            Integer a = rnd.nextInt(6) + 1;
            Integer b = rnd.nextInt(6 ) + 1;
            if (a == 1) {
                kocka1.setImageResource(R.drawable.kocka1);
            }
            if (a == 2) {
                kocka1.setImageResource(R.drawable.kocka2);
            }
            if (a == 3) {
                kocka1.setImageResource(R.drawable.kocka3);
            }
            if (a == 4) {
                kocka1.setImageResource(R.drawable.kocka4);
            }
            if (a == 5) {
                kocka1.setImageResource(R.drawable.kocka5);
            }
            if (a == 6) {
                kocka1.setImageResource(R.drawable.kocka6);
            }
            if (b == 1) {
                kocka2.setImageResource(R.drawable.kocka1);
            }
            if (b == 2) {
                kocka2.setImageResource(R.drawable.kocka2);
            }
            if (b == 3) {
                kocka2.setImageResource(R.drawable.kocka3);
            }
            if (b == 4) {
                kocka2.setImageResource(R.drawable.kocka4);
            }
            if (b == 5) {
                kocka2.setImageResource(R.drawable.kocka5);
            }
            if (b == 6) {
                kocka2.setImageResource(R.drawable.kocka6);
            }
            Integer i = a+b;
            String aktualisSzam = String.valueOf(i) + " (" + String.valueOf(a) + " + " + String.valueOf(b) + ")";
            szoveg = szoveg + "\n" + aktualisSzam;
            lista.setText(szoveg);
            lista.setMovementMethod(new ScrollingMovementMethod());
        }
    }

    public void resetClick(View view) {
        alertBuilder.show();
    }

}