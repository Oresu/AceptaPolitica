package com.example.zasha.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Verifica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);

        TextView mensaje = (TextView)findViewById(R.id. textView3);
        final Bundle bundle = getIntent().getExtras();
        mensaje.setText("Hola "+bundle.getString("NOMBRE")+" ¿Aceptas la política de privacidad?");

        Button acepto = (Button)findViewById(R.id. button);
        Button rechazo = (Button)findViewById(R.id. button3);

        acepto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent acepto= new Intent();
                //En este if compruebo si el dato enviado en "EDAD" es menor de 18 y si es asi devuelvo el mensaje con restricciones
                if (Integer.parseInt(bundle.getString("EDAD")) < 18){
                    acepto.putExtra("code", "Política Aceptada CON RESTRICCIONES");
                    setResult(RESULT_OK, acepto);
                    finish();
                }else{
                acepto.putExtra("code", "Política Aceptada");
                setResult(RESULT_OK, acepto);}
                finish();
            }
        });
        rechazo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent rechazo= new Intent();
                rechazo.putExtra("code", "Política NO Aceptada");
                setResult(RESULT_OK, rechazo);
                finish();
            }
        });

    }




}
