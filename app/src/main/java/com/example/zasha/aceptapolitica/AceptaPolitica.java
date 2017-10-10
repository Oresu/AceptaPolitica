package com.example.zasha.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AceptaPolitica extends AppCompatActivity {

    public static final int CODIGO = 0;

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

        EditText etEdad = (EditText)findViewById(R.id.etEdad);
        String edad = etEdad.getText().toString();

        Intent intent = new Intent(this, Verifica.class);//Actividad de destino
        Bundle bundle = new Bundle();//Paquete de datos a enviar

        bundle.putString("NOMBRE", nombre);
        bundle.putString("EDAD", edad);
        intent.putExtras(bundle);//Recojo todos los datos en el paquete bundle

        startActivityForResult(intent, CODIGO);// Ejecuto el activity (intent) Verifica
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == 0){
            TextView textResultado = (TextView)findViewById(R.id.textView4);
            textResultado.setText(data.getExtras().getString("code"));
        }
    }


    //METODO PARA SALIR DE LA APLICACION
    public void salir(View view){
        finish();
    }
}
