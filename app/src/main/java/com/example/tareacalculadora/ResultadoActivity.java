package com.example.tareacalculadora;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultadoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        double resultado = getIntent().getDoubleExtra("resultado", 0);
        TextView textResultado = findViewById(R.id.textResultado);
        textResultado.setText("Resultado: " + resultado);
    }
}