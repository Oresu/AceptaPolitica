package com.example.zasha.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Verifica extends AppCompatActivity {
    private final static int CODIGO = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);

        TextView mensaje = (TextView)findViewById(R.id. textView3);
        Bundle bundle = getIntent().getExtras();
        mensaje.setText("Hola "+bundle.getString("NOMBRE")+" ¿Aceptas la política de privacidad?");

        final Button acepto = (Button)findViewById(R.id. button);
        Button rechazo = (Button)findViewById(R.id. button3);
        acepto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarRespuesta();
            }
        });
        rechazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviarRespuesta();
            }
        });
    }

    //Metodo
    public void enviarRespuesta(){

        Intent intent = new Intent(this, AceptaPolitica.class);
        Bundle bundle = new Bundle();
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
