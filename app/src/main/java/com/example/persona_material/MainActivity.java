package com.example.persona_material;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adaptador_Persona.OnPersonaClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView lstPersona;
        FloatingActionButton fab;
        ArrayList<Persona> personas;
        LinearLayoutManager llm;
        Adaptador_Persona adapter;

        lstPersona = findViewById(R.id.lstPersonas);
        personas = Datos.obtener();
        llm = new LinearLayoutManager(this);
        adapter = new Adaptador_Persona(personas, this);

        llm.setOrientation(RecyclerView.VERTICAL);
        lstPersona.setLayoutManager(llm);
        lstPersona.setAdapter(adapter);

        fab = findViewById(R.id.btnAgregar);


    }
    public void agregar(View v){
        Intent intend;
        intend=new Intent(MainActivity.this, AgregarPersona.class);
        startActivity(intend);
        finish();
    }

    @Override
    public void OnPersonaClick(Persona p) {
        Intent intent;
        Bundle bundle;
        bundle=new Bundle();
        bundle.putString("cedula", p.getCedula());
        bundle.putString("nombre", p.getNombre());
        bundle.putString("apellido", p.getApellido());
        bundle.putInt("foto", p.getFoto());

        intent = new Intent(MainActivity.this, DetallePersona.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);
        finish();
    }
}
