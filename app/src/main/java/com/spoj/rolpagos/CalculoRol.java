package com.spoj.rolpagos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculoRol extends AppCompatActivity {

    private TextView txtResultado;
    private Button btnVolver, btnSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_rol);

        txtResultado = findViewById(R.id.txtresultados);
        btnVolver = findViewById(R.id.btnvolver);
        btnSalir = findViewById(R.id.btnsalir);

        // Obtener los datos enviados desde MainActivity
        Intent intent = getIntent();
        if (intent != null) {
            String nombre = intent.getStringExtra("nombre");
            String empresa = intent.getStringExtra("empresa");
            int hijos = Integer.parseInt(intent.getStringExtra("hijos"));
            String cargo = intent.getStringExtra("cargo");
            double extras = Double.parseDouble(intent.getStringExtra("extras"));

            double sueldoFijo = calcularSueldoFijo(cargo);
            double subsidioHijos = sueldoFijo * hijos * 0.02;
            double antiguedadEmpresa = sueldoFijo * Integer.parseInt(empresa) * 0.08;
            double horasExtra = sueldoFijo * (extras / 24); // Suponiendo 24 días trabajados al mes

            double ingresos = sueldoFijo + subsidioHijos + antiguedadEmpresa + horasExtra;
            double egresos = sueldoFijo * 0.0891; // Suponiendo 8.91% para el seguro social
            double totalMes = ingresos - egresos;

            // Mostrar los resultados en el TextView
            String resultado = "Nombre: " + nombre + "\n" +
                    "Cargo: " + cargo + "\n\n" +
                    "Ingresos:\n" +
                    "Sueldo Fijo: $" + sueldoFijo + "\n" +
                    "Subsidio por Hijos: $" + subsidioHijos + "\n" +
                    "Antigüedad en la Empresa: $" + antiguedadEmpresa + "\n" +
                    "Horas Extras: $" + horasExtra + "\n\n" +
                    "Egresos:\n" +
                    "Seguro Social: $" + egresos + "\n\n" +
                    "Total a recibir: $" + totalMes;

            txtResultado.setText(resultado);

            btnVolver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });

            btnSalir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finishAffinity();
                }
            });
        }
    }

    private double calcularSueldoFijo(String cargo) {
        switch (cargo) {
            case "programador junior":
                return 680;
            case "semi senior":
                return 980;
            case "senior":
                return 1200;
            default:
                return 0;
        }
    }
}

