package com.example.tareacalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNumero1 = findViewById(R.id.editTextNumero1);
        EditText editTextNumero2 = findViewById(R.id.editTextNumero2);

        Button btnSumar = findViewById(R.id.btnSumar);
        Button btnRestar = findViewById(R.id.btnRestar);
        Button btnMultiplicar = findViewById(R.id.btnMultiplicar);
        Button btnDividir = findViewById(R.id.btnDividir);

        btnSumar.setOnClickListener(v -> realizarOperacion("sumar", editTextNumero1, editTextNumero2));
        btnRestar.setOnClickListener(v -> realizarOperacion("restar", editTextNumero1, editTextNumero2));
        btnMultiplicar.setOnClickListener(v -> realizarOperacion("multiplicar", editTextNumero1, editTextNumero2));
        btnDividir.setOnClickListener(v -> realizarOperacion("dividir", editTextNumero1, editTextNumero2));
    }

    private void realizarOperacion(String operacion, EditText editTextNumero1, EditText editTextNumero2) {
        String input1 = editTextNumero1.getText().toString();
        String input2 = editTextNumero2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese ambos números", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            OperacionesMatematicas op = new OperacionesMatematicas(num1, num2);

            double resultado = 0;
            switch (operacion) {
                case "sumar": resultado = op.sumar(); break;
                case "restar": resultado = op.restar(); break;
                case "multiplicar": resultado = op.multiplicar(); break;
                case "dividir": resultado = op.dividir(); break;
            }

            Intent intent = new Intent(this, ResultadoActivity.class);
            intent.putExtra("resultado", resultado);
            startActivity(intent);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Ingrese números válidos", Toast.LENGTH_SHORT).show();
        } catch (ArithmeticException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}