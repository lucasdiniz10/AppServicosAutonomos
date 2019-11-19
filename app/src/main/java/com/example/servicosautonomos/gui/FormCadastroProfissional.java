package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.AparelhosEletronicos;
import com.example.servicosautonomos.classesbasicas.Contratante;
import com.example.servicosautonomos.classesbasicas.Profissional;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FormCadastroProfissional extends AppCompatActivity {
    private static final String TAG = "TestActivity";
    Button buttonLogin;
    EditText editTextEnderecoNomeRua, editTextEnderecoNumero, editTextEnderecoBairro, editTextEnderecoCidade, editTextEnderecoEstado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro_profissional);

        this.buttonLogin = findViewById(R.id.buttonFinalizarCadastro);

        //acessando o firebase para listar
        FirebaseApp.initializeApp(FormCadastroProfissional.this);
        FirebaseDatabase bd = FirebaseDatabase.getInstance();
        final DatabaseReference bdRef = bd.getReference();
        FirebaseDatabase.getInstance().getReference("profissional"); /*{
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    usuarios = new ArrayList<>();
                    //listView.setAdapter(null);
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Usuario usu = snapshot.getValue(Usuario.class);
                        usu.ID = snapshot.getKey();
                        usuarios.add(usu);
                    }
                    UsuarioAdapter adapter = new UsuarioAdapter(MainActivity.this, usuarios);
                    listView.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
        */

        buttonLogin.setOnClickListener(new View.OnClickListener() {

            EditText editTextNome, editTextTelefone, editTextCpf, editTextDataNascimento, editTextEmail, editTextConfirmarEmail, editTextSenha, editTextConfirmarSenha,
            editTextDescricao, editTextEnderecoNomeRua, editTextEnderecoNumero, editTextEnderecoBairro, editTextEnderecoCidade, editTextEnderecoEstado;

            @Override
            public void onClick(View v) {

                this.editTextNome = findViewById(R.id.editTextNome);
                this.editTextTelefone = findViewById(R.id.editTextTelefone);
                this.editTextCpf = findViewById(R.id.editTextCpf);
                this.editTextDataNascimento = findViewById(R.id.editTextDataNascimento);
                this.editTextEmail = findViewById(R.id.editTextEmail);
                this.editTextConfirmarEmail = findViewById(R.id.editTextConfirmarEmail);
                this.editTextSenha = findViewById(R.id.editTextSenha);
                this.editTextConfirmarSenha = findViewById(R.id.editTextConfirmarSenha);
                this.editTextDescricao = findViewById(R.id.editTextDescricao);
                this.editTextEnderecoNomeRua = findViewById(R.id.editTextEnderecoNomeRua);
                this.editTextEnderecoNumero = findViewById(R.id.editTextEnderecoNumero);
                this.editTextEnderecoBairro = findViewById(R.id.editTextEnderecoBairro);
                this.editTextEnderecoCidade = findViewById(R.id.editTextEnderecoCidade);
                this.editTextEnderecoEstado = findViewById(R.id.editTextEnderecoEstado);


                final String nome = editTextNome.getText().toString();
                final String telefone = editTextTelefone.getText().toString();
                final String cpf = editTextCpf.getText().toString();
                final String dataNascimento = editTextDataNascimento.getText().toString();
                final String email = editTextEmail.getText().toString();
                final String confirmarEmail = editTextConfirmarEmail.getText().toString();
                final String senha = editTextSenha.getText().toString();
                final String confirmarSenha = editTextConfirmarSenha.getText().toString();
                final String descricao = editTextDescricao.getText().toString();
                final String nomeRua = editTextEnderecoNomeRua.getText().toString();
                final String numero = editTextEnderecoNumero.getText().toString();
                final String bairro = editTextEnderecoBairro.getText().toString();
                final String cidade = editTextEnderecoCidade.getText().toString();
                final String estado = editTextEnderecoEstado.getText().toString();

                Profissional profissional = new Profissional();

                profissional.nome = nome;
                profissional.telefone = telefone;
                profissional.cpf = cpf;
                profissional.dataNasc = dataNascimento;
                profissional.email = email;
                profissional.senha = senha;
                profissional.descricao = senha;
                profissional.endereco = estado + ", " + cidade + ", " + bairro + ", " + nomeRua + ", " + numero;

                bdRef.child("profissional").push().setValue(profissional);

                Toast.makeText(FormCadastroProfissional.this,"Profissional cadastrado com sucesso.",Toast.LENGTH_LONG).show();
                editTextNome.setText("");
                editTextTelefone.setText("");
                editTextCpf.setText("");
                editTextDataNascimento.setText("");
                editTextEmail.setText("");
                editTextSenha.setText("");

                /*Intent intent = new Intent(FormCadastroProfissional.this, PerfilProfissional.class);
                startActivity(intent);*/

                AparelhosEletronicos aparelhosEletronicos = getIntent().getExtras().getParcelable("condiçao da classe");
                int hahah = aparelhosEletronicos.condicao;

                if (hahah == 1){
                    geoLocate();
                }
            }
        });
    }
    private void geoLocate(){
        FirebaseApp.initializeApp(FormCadastroProfissional.this);
        FirebaseDatabase bd = FirebaseDatabase.getInstance();
        final DatabaseReference bdRef = bd.getReference();
        Log.d(TAG, "geoLocate: geoLocating");
        this.editTextEnderecoNomeRua = findViewById(R.id.editTextEnderecoNomeRua);
        this.editTextEnderecoNumero = findViewById(R.id.editTextEnderecoNumero);
        this.editTextEnderecoBairro = findViewById(R.id.editTextEnderecoBairro);
        this.editTextEnderecoCidade = findViewById(R.id.editTextEnderecoCidade);
        this.editTextEnderecoEstado = findViewById(R.id.editTextEnderecoEstado);

        final String nomeRua = editTextEnderecoNomeRua.getText().toString();
        final String numero = editTextEnderecoNumero.getText().toString();
        final String bairro = editTextEnderecoBairro.getText().toString();
        final String cidade = editTextEnderecoCidade.getText().toString();
        final String estado = editTextEnderecoEstado.getText().toString();

        String searchString = estado + ", " + cidade + ", " + bairro + ", " + nomeRua + ", " + numero;;

        Geocoder geocoder = new Geocoder(FormCadastroProfissional.this);
        List<Address> list = new ArrayList<>();
        try {
            list = geocoder.getFromLocationName(searchString, 1);
        }catch (IOException e){
            Log.e(TAG, "geoLocate: IOException: " + e.getMessage());
        }

        if(list.size() > 0){
            Address address = list.get(0);
            Log.d(TAG, "geoLocate: found a location: " + address.toString());

            AparelhosEletronicos aparelhosEletronicos = new AparelhosEletronicos();

            aparelhosEletronicos.condicao = 1;
            aparelhosEletronicos.latitude = address.getLatitude();
            aparelhosEletronicos.longitude = address.getLongitude();

            bdRef.child("aparelhosEletronicos").push().setValue(aparelhosEletronicos);

            Intent intent = new Intent(FormCadastroProfissional.this, PerfilProfissional.class);
            startActivity(intent);


        }
    }
}
