package com.example.diseno.appsalud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class Main2Activity extends AppCompatActivity {
    EditText Nombres, Apellidos, Correo;
    RadioButton Fem, Masc;
    CheckBox Noti;
    Button Enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Nombres = findViewById(R.id.txtNombres);
        Apellidos = findViewById(R.id.txtApellidos);
        Correo = findViewById(R.id.txtEmail);
        Fem = findViewById(R.id.radioFem);
        Masc = findViewById(R.id.radioMasc);
        Noti = findViewById(R.id.checkNoti);
        Enviar = findViewById(R.id.btnEnviar);

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombres, apellidos, correo, genero, noti;
                nombres = Nombres.getText().toString();
                apellidos = Apellidos.getText().toString();
                correo = Correo.getText().toString();
                genero = "Indeterminado";
                noti = "No";

                if(nombres.isEmpty()){
                    Nombres.setError("Escriba sus nombres");
                    Nombres.requestFocus();
                }

                else if(apellidos.isEmpty()){
                    Apellidos.setError("Escriba sus apellidos");
                    Apellidos.requestFocus();
                }

                else if(correo.isEmpty()){
                    Correo.setError("Escriba un email");
                    Correo.requestFocus();
                }

                else {
                    if(Fem.isChecked()) {
                        genero = "Femenino";
                    }
                    if(Masc.isChecked()) {
                        genero = "Masculino";
                    }
                    if(Noti.isChecked()) {
                        noti = "Si";
                    }
                    Intent enviar = new Intent(Main2Activity.this, Main3Activity.class);
                    enviar.putExtra("Nombres", nombres);
                    enviar.putExtra("Apellidos", apellidos);
                    enviar.putExtra("Correo", correo);
                    enviar.putExtra("Genero", genero);
                    enviar.putExtra("Noti", noti);
                    startActivity(enviar);
                }
            }
        });
    }
}
