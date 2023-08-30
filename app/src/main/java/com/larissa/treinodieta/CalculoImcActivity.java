package com.larissa.treinodieta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculoImcActivity extends AppCompatActivity {
    TextView resultado;
    Button calcularImc;
    EditText editPeso;
    EditText editAltura;
    Button limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);
        editPeso = findViewById(R.id.editTextPeso);
        editAltura = findViewById(R.id.editTextAltura);
        resultado = findViewById(R.id.textViewImc);
        calcularImc = findViewById(R.id.calcular);
        limpar = findViewById(R.id.limpar);

        calcularImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
        limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
    }

    private void calcular(){
        float peso = Float.parseFloat(editPeso.getText().toString());
        float altura = Float.parseFloat(editAltura.getText().toString());
        float res = peso / (altura * altura);
        String result = Float.toString(res);

        String info;
        if (res < 18.5){
            info = "Muito a baixo do normal";
        } else if (res < 24.9) {
            info = "Normal";
        } else if (res <29.9) {
            info = "Sobrepeso";
        }else {
            info = "Obesidade";
        }
        resultado.setText("IMC: " + String.format("%.2f", res ) + " " + info);

    }
    private void limpar(){
        editPeso.setText("");
        editAltura.setText("");
        resultado.setText("");

    }
}
