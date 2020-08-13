package com.example.finalexam;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.finalexam.Class.SQLDB;
import com.example.finalexam.Class.User;

public class Registrar extends AppCompatActivity {

    EditText edtId, edtUsername, edtNombre, edtPassword;
    Button btnAdd, btnEdit, btnDelete, btnList, btnFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        References();

        final SQLDB objDB = new SQLDB(getApplicationContext());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objDB.insertUser(
                        edtNombre.getText().toString(),
                        edtUsername.getText().toString(),
                        edtPassword.getText().toString());
                Toast.makeText(Registrar.this, "Registrado Correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objDB.updateUser(Integer.parseInt(edtId.getText().toString()), edtNombre.getText().toString(), edtUsername.getText().toString(), edtPassword.getText().toString());
                Toast.makeText(Registrar.this, "Usuario actualizado correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                objDB.deleteUser(Integer.parseInt(edtId.getText().toString()));
                Toast.makeText(Registrar.this, "Usuario eliminado correctamente", Toast.LENGTH_SHORT).show();
            }
        });

        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                objDB.findUser(user, Integer.parseInt(edtId.getText().toString()));
                edtNombre.setText(user.getNombre());
                edtUsername.setText(user.getUsername());
                edtPassword.setText(user.getPassword());
                Toast.makeText(Registrar.this, "Usuario encontrado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void References(){
        edtId = findViewById(R.id.txtId);
        edtUsername = findViewById(R.id.txtUser);
        edtNombre = findViewById(R.id.txtNombre);
        edtPassword = findViewById(R.id.txtContrasenha);

        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEditar);
        btnDelete = findViewById(R.id.btnEliminar);
        btnFind = findViewById(R.id.btnBuscar);
        btnList = findViewById(R.id.btnListar);

    }

    public void Listar(View view) {
        Intent intent = new Intent(getApplicationContext(), ListUsers.class);
        startActivity(intent);
    }
}