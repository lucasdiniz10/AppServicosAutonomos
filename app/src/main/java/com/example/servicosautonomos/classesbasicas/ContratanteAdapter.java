package com.example.servicosautonomos.classesbasicas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.servicosautonomos.R;

import java.util.List;

public class ContratanteAdapter extends ArrayAdapter<Contratante> {
    public ContratanteAdapter(@NonNull Context context, @NonNull List<Contratante> objects) {
        super(context, 0,objects);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Contratante contratante = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        }
        // Lookup view for data population
        TextView tvNome = (TextView) convertView.findViewById(R.id.textView);
        TextView tvCpf = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvEmail = (TextView) convertView.findViewById(R.id.textView3);
        TextView tvTelefone = (TextView) convertView.findViewById(R.id.textView4);
        TextView tvNacimento = (TextView) convertView.findViewById(R.id.textView6);
        TextView tvSenha = (TextView) convertView.findViewById(R.id.textView7);
        // Populate the data into the template view using the data object
        tvNome.setText(contratante.nome);
        tvCpf.setText(contratante.cpf);
        tvEmail.setText(contratante.email);
        tvTelefone.setText(contratante.telefone);
        tvNacimento.setText(contratante.nascimento);
        tvSenha.setText(contratante.senha);
        // Return the completed view to render on screen
        return convertView;
    }


}
