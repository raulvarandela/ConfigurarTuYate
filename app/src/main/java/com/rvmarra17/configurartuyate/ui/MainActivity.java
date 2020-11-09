package com.rvmarra17.configurartuyate.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rvmarra17.configurartuyate.R;
import com.rvmarra17.configurartuyate.core.yate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button configura = this.findViewById(R.id.configura);
        final Button acercaDe = this.findViewById(R.id.btAcercaDe);

        configura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.configuracion();
            }
        });

        final Button bautizar = this.findViewById(R.id.bautiza);

        bautizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bautizaActivity();
            }
        });

        acercaDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //mirar lo de las landas
                MainActivity.this.acercaDe();
            }
        });


        this.miyate = new yate();
        this.actualiza();

    }


    private void acercaDe() {
        this.startActivity(new Intent(this, AcercaDeActivity.class));
    }

    private void bautizar() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        final EditText nombre = new EditText(this); //repasar

        dlg.setMessage("Nombre del yate "); //el "enunciado"
        dlg.setView(nombre);//aún no se
        nombre.setText(miyate.getNombre());//tampoco se

        dlg.setPositiveButton("Okey", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                miyate.setNombre(nombre.getText().toString()); //con esto recupero el nombre
                actualiza();
            }
        });

        dlg.create().show();
    }

    private void configuracion() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        dlg.setMultiChoiceItems(
                new String[]{
                        "velas",
                        "motor",
                        "lancha motora",
                        "calefacción",
                        "radar"
                },
                miyate.getOpciones(),
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                        if (which == 0) miyate.setVelas(isChecked);
                        if (which == 1) miyate.setMotor(isChecked);
                        if (which == 2) miyate.setLancha(isChecked);
                        if (which == 3) miyate.setCalefaccion(isChecked);
                        if (which == 4) miyate.setRadar(isChecked);

                    }
                }
        );

        dlg.setPositiveButton("Finalizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.actualiza();
            }
        });
        dlg.create().show();
    }

    private void configutadorActivity() {

    }

    private void bautizaActivity() {
        this.startActivityForResult(new Intent(this, BautizaActivity.class), REQ_BAUTIZA);
    }

    private yate miyate;

    private void actualiza() {
        final TextView texto = this.findViewById(R.id.texto);
        texto.setText(miyate.toString());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode== Activity.RESULT_OK){
            switch (requestCode){
                case REQ_BAUTIZA:
                    if (data != null){
                        this.miyate.setNombre(data.getStringExtra("name"));
                        this.actualiza();
                    }else{
                        Toast.makeText(this, "error: no hay datos", Toast.LENGTH_LONG);
                    }
                    break;
            }
        }
    }

    public static final int REQ_BAUTIZA = 101;
}

