package com.example.zasha.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AceptaPolitica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acepta_politica);

        // Añado el boton oyente buscandolo por su ID
        Button botonV = (Button)findViewById(R.id. button2);
        // Añado el evento onClick sobre el boton Verificar
        botonV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Y al ser pulsado ejecutara el metodo abrirVerifica()
                abrirVerifica();
            }
        });
    }

    // Metodo abrirVerifica

    public void abrirVerifica(){
        EditText etNombre = (EditText)findViewById(R.id. editText2);//Llamo al campo de texto
        String nombre = etNombre.getText().toString();//Capturo el texto introducido en una variable

        Intent intent = new Intent(this, Verifica.class);
        Bundle bundle = new Bundle();

        bundle.putString("NOMBRE", nombre);
        intent.putExtras(bundle);
        startActivity(intent);// Ejecuto el activity (intent) Verifica
    }
}
