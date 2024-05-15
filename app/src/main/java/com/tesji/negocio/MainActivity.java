package com.tesji.negocio;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.tesji.negocio.model.tda;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText txCantidad;
    private Spinner spCliente;
    private Spinner spPago;
    private TextView tvImprimir;
    String [] opCliente = {
            "-- SELECCIONE TIPO DE CLIENTE --",
            "Cliente General",
            "Cliente Afiliado",
    };
    String [] opPago = {
            "-- SELECCIONE TIPO DE CLIENTE --",
            "Pago Contado",
            "Pago Plazos",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txCantidad = findViewById(R.id.cantidad);
        spCliente = findViewById(R.id.spinnerCliente);
        spPago = findViewById(R.id.spinnerPago);
        tvImprimir = findViewById(R.id.textViewImprimir);

        ArrayAdapter<String> adapCliente = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opCliente);
        spCliente.setAdapter(adapCliente);
        ArrayAdapter<String> adapPago = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opPago);
        spPago.setAdapter(adapPago);

        spCliente.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spPago.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(txCantidad.getText().toString().trim().length() == 0){
                    txCantidad.setText(null);
                    txCantidad.requestFocus();
                }else {

                    tda resultado;
                    resultado = new tda();

                    resultado.setCantidad(Integer.parseInt(txCantidad.getText().toString()));
                    resultado.setCliente(spCliente.getSelectedItemPosition());
                    resultado.setDescuento(spPago.getSelectedItemPosition());
                    tvImprimir.setText(resultado.mostrarInfo());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}