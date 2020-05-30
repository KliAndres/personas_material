package com.example.persona_material;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptador_Persona extends RecyclerView.Adapter<Adaptador_Persona.PersonaViewHolder>{
    private ArrayList<Persona> personas;
    private OnPersonaClickListener clickListener;

    public Adaptador_Persona(ArrayList<Persona>personas, OnPersonaClickListener clickListener){
        this.personas = personas;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona, parent,false);
        return new PersonaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        final Persona p=personas.get(position);
        holder.foto.setImageResource(p.getFoto());
        holder.cedula.setText(p.getCedula());
        holder.nombre.setText(p.getNombre());
        holder.apellido.setText(p.getApellido());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.OnPersonaClick(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView cedula;
        private TextView nombre;
        private TextView apellido;
        private View v;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            v=itemView;
            foto =v.findViewById(R.id.imgFoto);
            cedula=v.findViewById(R.id.lblCedula);
            nombre=v.findViewById(R.id.lblNombre);
            apellido=v.findViewById(R.id.lblApellido);
        }
    }
    public interface OnPersonaClickListener{
        void OnPersonaClick(Persona p);
    }
}
