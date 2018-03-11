package com.example.diseno.appsalud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    TextView Nombres, Apellidos, Correo, Genero, Noti;
    String nombres, apellidos, correo, genero, noti;
    Button Salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Nombres = findViewById(R.id.txtNombres);
        Apellidos = findViewById(R.id.txtApellidos);
        Correo = findViewById(R.id.txtCorreo);
        Genero = findViewById(R.id.txtGenero);
        Noti = findViewById(R.id.txtNot);
        Salir = findViewById(R.id.btnSalir);
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        nombres = bundle.getString("Nombres");
        apellidos = bundle.getString("Apellidos");
        correo = bundle.getString("Correo");
        genero = bundle.getString("Genero");
        noti = bundle.getString("Noti");

        Nombres.setText(nombres);
        Apellidos.setText(apellidos);
        Correo.setText(correo);
        Genero.setText(genero);
        Noti.setText(noti);

        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
}
