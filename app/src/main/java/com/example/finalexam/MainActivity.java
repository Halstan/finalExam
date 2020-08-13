package com.example.finalexam;

import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.finalexam.Class.SQLDB;

public class MainActivity extends AppCompatActivity {

    EditText edtUsername, edtPass;
    Button btnIngresar, btnNewU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SQLDB objBD = new SQLDB(getApplicationContext());
        asignarReferencias();

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cursor = objBD.validarUsuario( edtUsername.getText().toString(), edtPass.getText().toString());

                if(cursor.getCount() > 0){
                    Intent intent = new Intent(getApplicationContext(), Drawer.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void asignarReferencias() {
        edtUsername = findViewById(R.id.txtUsername);
        edtPass = findViewById(R.id.txtContrasena);
        btnIngresar = findViewById(R.id.btnIniciar);
        btnNewU = findViewById(R.id.btnRegistrar);
    }

    public void registrar(View view) {
        Intent intent = new Intent(getApplicationContext(), Registrar.class);
        startActivity(intent);
    }
}