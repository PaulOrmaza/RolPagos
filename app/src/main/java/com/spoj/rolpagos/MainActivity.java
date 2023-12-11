package com.spoj.rolpagos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre, txtEmpresa, txtHijos, txtCargo, txtExtras;
    private Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialización de los EditText y el botón
        txtNombre = findViewById(R.id.txtnombre);
        txtEmpresa = findViewById(R.id.txtempresa);
        txtHijos = findViewById(R.id.txthijos);
        txtCargo = findViewById(R.id.txtcargo);
        txtExtras = findViewById(R.id.txtextras);

        btnCalcular = findViewById(R.id.btncalcular);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados por el usuario
                String nombre = txtNombre.getText().toString();
                String empresa = txtEmpresa.getText().toString();
                String hijos = txtHijos.getText().toString();
                String cargo = txtCargo.getText().toString();
                String extras = txtExtras.getText().toString();

                // Pasar los datos a la siguiente actividad (CalculoRol)
                Intent intent = new Intent(MainActivity.this, CalculoRol.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("empresa", empresa);
                intent.putExtra("hijos", hijos);
                intent.putExtra("cargo", cargo);
                intent.putExtra("extras", extras);
                startActivity(intent);
            }
        });
    }
}

