package com.example.nutrilife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView txtResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        txtResultado = findViewById(R.id.txtResultado);

        btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();

        String nome = intent.getStringExtra("nome");
        Double peso = intent.getDoubleExtra("peso", 0);
        Double altura = intent.getDoubleExtra("altura", 0);

        Double imc = peso / Math.pow(altura, 2);

        String saida = String.format(" Olá, %s.\n Seu IMC é: %.1f", nome, imc);

        if(imc > 40){
            saida+= "\n Classificação: Obesidade Grau 3" + "\n Abaixo estão os riscos associados ao seu resultado: Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC.";
        }
        else if(imc >=35 && imc <=40){
            saida+= "\n Classificação: Obesidade Grau 2" + "\n Abaixo estão os riscos associados ao seu resultado: Apneia do sono, falta de ar.";
        }
        else if(imc >=30 && imc <=34.9){
            saida+= "\n Classificação: Obesidade Grau 1" + "\n Abaixo estão os riscos associados ao seu resultado: Diabetes, angina, infarto, aterosclerose.";
        }
        else if(imc >=25 && imc <=29.9){
            saida+= "\n Classificação: Acima do Peso" + "\n Abaixo estão os riscos associados ao seu resultado: Fadiga, má circulação, varizes.";
        }
        else if(imc >=18.5 && imc <=24.9){
            saida += "\n Classificação: Peso Normal" + "\n Abaixo estão os riscos associados ao seu resultado: Menor risco de doenças cardíacas e vasculares.";
        }
        else if(imc >=17 && imc <=18.4){
            saida += "\n Classificação: Abaixo do Peso" + "\n Abaixo estão os riscos associados ao seu resultado: Fadiga, stress, ansiedade";
        }
        else if(imc <= 16.9){
            saida += "\n Classificação: Muito Abaixo do Peso" + "\n Abaixo estão os riscos associados ao seu resultado: Queda de cabelo, infertilidade, ausência menstrual";
        }
        txtResultado.setText(saida);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
    }

}