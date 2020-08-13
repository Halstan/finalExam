package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalexam.Adapter.AdapterUsers;
import com.example.finalexam.Class.SQLDB;

public class ListUsers extends AppCompatActivity {

    RecyclerView recyclerViewVentas;
    AdapterUsers adapterUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        recyclerViewVentas = findViewById( R.id.recycleViewVentas);
        recyclerViewVentas.setLayoutManager( new LinearLayoutManager( this ) );

        SQLDB sqlBD = new SQLDB(getApplicationContext());
        adapterUsers = new AdapterUsers(sqlBD.visualizarUsuarios());

        recyclerViewVentas.setAdapter(adapterUsers);

    }
}