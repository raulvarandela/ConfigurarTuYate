package com.rvmarra17.configurartuyate.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rvmarra17.configurartuyate.R;

public class BautizaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bautiza);


        final Button BT_CANCELAR = this.findViewById(R.id.btCancelar);
        final Button BT_GUARDAR = this.findViewById(R.id.btGuardar);

        BT_CANCELAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancela();
            }
        });

        BT_GUARDAR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }


        });
    }

    private void cancela() {
        this.setResult(Activity.RESULT_CANCELED); //lo mismo que pulsar atrás; es el 0; el -1 es el okay
        this.finish();
    }

    private void guardar() {

        final EditText ED_NOMBRE = this.findViewById(R.id.edNombre);
        Intent datosRetorno = new Intent();
        Bundle datos = new Bundle();
                datosRetorno.putExtras(datos);
        datos.putString("nombre", ED_NOMBRE.getText().toString());
        this.setResult(RESULT_OK, datosRetorno);
        this.finish();
    }
}