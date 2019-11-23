package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
            CheckBox checkBox1, checkBox2, checkBox3;

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
                this.checkBox1 = findViewById(R.id.checkBoxCartaoDeCredito);
                this.checkBox2 = findViewById(R.id.checkBoxCartaoDeDebito);
                this.checkBox3 = findViewById(R.id.checkBoxDinheiro);



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



                Profissional profi = getIntent().getExtras().getParcelable("Categoria");
                String categoria =  profi.categoria;
                Profissional profissional = new Profissional();

                if(checkBox1.isChecked() == true){
                    profissional.cartaoCredito = true;
                }
                if(checkBox2.isChecked() == true){
                    profissional.cartaoDebito = true;
                }
                if(checkBox3.isChecked() == true){
                    profissional.dinheiro = true;
                }

                profissional.categoria = categoria;
                profissional.nome = nome;
                profissional.telefone = telefone;
                profissional.cpf = cpf;
                profissional.dataNasc = dataNascimento;
                profissional.email = email;
                profissional.senha = senha;
                profissional.descricao = senha;


                Toast.makeText(FormCadastroProfissional.this,"Profissional cadastrado com sucesso.",Toast.LENGTH_LONG).show();
                editTextNome.setText("");
                editTextTelefone.setText("");
                editTextCpf.setText("");
                editTextDataNascimento.setText("");
                editTextEmail.setText("");
                editTextSenha.setText("");

                /*Intent intent = new Intent(FormCadastroProfissional.this, PerfilProfissional.class);
                startActivity(intent);*/


                geoLocate(profissional);

            }
        });
    }
    private void geoLocate(Profissional profissional){
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

            profissional.latitude = address.getLatitude();
            profissional.longitude = address.getLongitude();

            enviarAoBanco(profissional);

        }
    }

    private void enviarAoBanco(Profissional profissional){

        FirebaseApp.initializeApp(FormCadastroProfissional.this);
        FirebaseDatabase bd = FirebaseDatabase.getInstance();
        final DatabaseReference bdRef = bd.getReference();

        bdRef.child("profissional").push().setValue(profissional);

        Intent intent = new Intent(FormCadastroProfissional.this, PerfilProfissional.class);
    }
}
