package com.example.servicosautonomos.gui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Contratante;
import com.example.servicosautonomos.classesbasicas.ContratanteAdapter;
import com.google.firebase.FirebaseApp;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class EscolherPorCategoria extends AppCompatActivity {
    Button butaoTest;
    ListView listView;
    TextView textView;
    private ArrayList<String> people = new ArrayList<>();



    private  String userID;
    private ArrayList<Contratante> contratantes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_por_categoria);

        this.butaoTest = findViewById(R.id.CategotiaAindaEmDefinicao);

        listView = (ListView) findViewById(R.id.lista);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, people);
        listView.setAdapter(adapter);

        butaoTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseApp.initializeApp(EscolherPorCategoria.this);
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                final DatabaseReference bdRef = database.getReference();
                FirebaseDatabase.getInstance().getReference("contratante").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        contratantes.clear();
                        List<String> keys = new ArrayList<>();
                        for (DataSnapshot key : dataSnapshot.getChildren()){
                            keys.add(key.getKey());
                            Contratante contratante = key.getValue(Contratante.class);
                            contratantes.add(contratante);
                        }
                        ContratanteAdapter adapter = new ContratanteAdapter(EscolherPorCategoria.this, contratantes);
                        listView.setAdapter(adapter);
                        textView = findViewById(R.id.testetetet);
                        Contratante cont = (Contratante) contratantes.get(1);
                        String teste = cont.email;
                        textView.setText(teste);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Contratante cont = contratantes.get(position);

                        //Toast.makeText(MainActivity.this, " " + usu.ID, Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }


}
