package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FormCadastroProfissional extends AppCompatActivity {
    private static final String TAG = "TestActivity";


    private static final String NAME_REGEX =
            "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX);

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*" +
                    "@" + "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private static final String DATA_REGEX =
            "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
    private static final Pattern DATA_PATTERN = Pattern.compile(DATA_REGEX);

    Button buttonLogin;
    EditText editTextEnderecoNomeRua, editTextEnderecoNumero, editTextEnderecoBairro, editTextEnderecoCidade, editTextEnderecoEstado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro_profissional);

        this.buttonLogin = findViewById(R.id.buttonFinalizarCadastro);

        //acessando o firebase
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

            EditText editTextNome, editTextTelefone, editTextCpf, editTextDataNascimento, editTextEmail,
                    editTextConfirmarEmail, editTextSenha, editTextConfirmarSenha, editTextDescricao,
                    editTextEnderecoNomeRua, editTextEnderecoNumero, editTextEnderecoBairro,
                    editTextEnderecoCidade, editTextEnderecoEstado;
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

                final String nome = editTextNome.getText().toString().trim();
                final String telefone = editTextTelefone.getText().toString().trim();
                final String cpf = editTextCpf.getText().toString().trim();
                final String dataNascimento = editTextDataNascimento.getText().toString().trim();
                final String email = editTextEmail.getText().toString().trim();
                final String confirmarEmail = editTextConfirmarEmail.getText().toString().trim();
                final String senha = editTextSenha.getText().toString().trim();
                final String confirmarSenha = editTextConfirmarSenha.getText().toString().trim();
                final String descricao = editTextDescricao.getText().toString().trim();

                if (nome.isEmpty()) {
                    editTextNome.setError("Campo obrigatório");
                    editTextNome.requestFocus();
                    return;
                } else if (!NAME_PATTERN.matcher(nome).matches()){
                    editTextNome.setError("O nome só pode conter letras");
                    editTextNome.requestFocus();
                    return;
                } else if (nome.length() < 5){
                    editTextNome.setError("Nome deve ter no mínimo 5 letras");
                    editTextNome.requestFocus();
                    return;
                }

                if (telefone.isEmpty()) {
                    editTextTelefone.setError("Campo obrigatório");
                    editTextTelefone.requestFocus();
                    return;
                } else if (!telefone.matches("9?[6-9][0-9]{3}[0-9]{4}")){
                    editTextTelefone.setError("Número inválido");
                    editTextTelefone.requestFocus();
                    return;
                }

                if (cpf.isEmpty()) {
                    editTextCpf.setError("Campo obrigatório");
                    editTextCpf.requestFocus();
                    return;
                } else if (cpf.length() != 11){
                    editTextCpf.setError("Deve ter 11 números");
                    editTextCpf.requestFocus();
                    return;
                }

                if (dataNascimento.isEmpty()) {
                    editTextDataNascimento.setError("Campo obrigatório");
                    editTextDataNascimento.requestFocus();
                    return;
                } else if (!DATA_PATTERN.matcher(dataNascimento).matches()){
                    editTextDataNascimento.setError("dd/mm/aaaa");
                    editTextDataNascimento.requestFocus();
                    return;
                }

                if (email.isEmpty()) {
                    editTextEmail.setError("Campo obrigatório");
                    editTextEmail.requestFocus();
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    editTextEmail.setError("E-mail inválido");
                    editTextEmail.requestFocus();
                    return;
                }

                if (confirmarEmail.isEmpty()) {
                    editTextConfirmarEmail.setError("Campo obrigatório");
                    editTextConfirmarEmail.requestFocus();
                    return;
                } else if (!confirmarEmail.equals(email)) {
                    editTextConfirmarEmail.setError("E-mail não coincide");
                    editTextConfirmarEmail.requestFocus();
                    return;
                }

                if (senha.isEmpty()) {
                    editTextSenha.setError("Campo obrigatório");
                    editTextSenha.requestFocus();
                    return;
                }

                if (confirmarSenha.isEmpty()) {
                    editTextConfirmarSenha.setError("Campo obrigatório");
                    editTextConfirmarSenha.requestFocus();
                    return;
                } else if (!confirmarSenha.equals(senha)) {
                    editTextConfirmarEmail.setError("Senha não coincide");
                    editTextConfirmarEmail.requestFocus();
                    return;
                }

                if (editTextEnderecoNomeRua.getText().toString().isEmpty()) {
                    editTextEnderecoNomeRua.setError("Campo obrigatório");
                    editTextEnderecoNomeRua.requestFocus();
                    return;
                }

                if (editTextEnderecoNumero.getText().toString().isEmpty()) {
                    editTextEnderecoNumero.setError("Campo obrigatório");
                    editTextEnderecoNumero.requestFocus();
                    return;
                }

                if (editTextEnderecoBairro.getText().toString().isEmpty()) {
                    editTextEnderecoBairro.setError("Campo obrigatório");
                    editTextEnderecoBairro.requestFocus();
                    return;
                }

                if (editTextEnderecoCidade.getText().toString().isEmpty()) {
                    editTextEnderecoCidade.setError("Campo obrigatório");
                    editTextEnderecoCidade.requestFocus();
                    return;
                }

                if (editTextEnderecoEstado.getText().toString().isEmpty()) {
                    editTextEnderecoEstado.setError("Campo obrigatório");
                    editTextEnderecoEstado.requestFocus();
                    return;
                }

                Profissional profi = getIntent().getExtras().getParcelable("Categoria");
                String categoria = profi.categoria;
                Profissional profissional = new Profissional();

                if (checkBox1.isChecked() == true) {
                    profissional.cartaoCredito = true;
                }
                if (checkBox2.isChecked() == true) {
                    profissional.cartaoDebito = true;
                }
                if (checkBox3.isChecked() == true) {
                    profissional.dinheiro = true;
                }

                profissional.categoria = categoria;
                profissional.nome = nome;
                profissional.telefone = telefone;
                profissional.cpf = cpf;
                profissional.dataNasc = dataNascimento;
                profissional.email = email;
                profissional.senha = senha;
                profissional.descricao = descricao;


                Toast.makeText(FormCadastroProfissional.this, "Profissional cadastrado com sucesso.", Toast.LENGTH_LONG).show();

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

        String searchString = estado + ", " + cidade + ", " + bairro + ", " + nomeRua + ", " + numero;

        profissional.endereco = searchString;

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
        intent.putExtra("dados", profissional);
        startActivity(intent);
    }
}
