package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Contratante;
import com.google.firebase.FirebaseApp;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormCadastroContratante extends AppCompatActivity {

    private static final String TAG = "Contratante";
    Button buttonLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro_contratante);

        this.buttonLogin = findViewById(R.id.buttonFinalizarCadastro);

        //acessando o firebase para listar
        FirebaseApp.initializeApp(FormCadastroContratante.this);
        FirebaseDatabase bd = FirebaseDatabase.getInstance();
        final DatabaseReference bdRef = bd.getReference();
        FirebaseDatabase.getInstance().getReference("usuarios"); /*{
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

            EditText editTextNome, editTextTelefone, editTextCpf, editTextDataNascimento, editTextEndereco,
                    editTextEmail, editTextConfirmarEmail, editTextSenha, editTextConfirmarSenha;

            @Override
            public void onClick(View v) {

                onStart();

                this.editTextNome = findViewById(R.id.editTextNome);
                this.editTextTelefone = findViewById(R.id.editTextTelefone);
                this.editTextCpf = findViewById(R.id.editTextCpf);
                this.editTextDataNascimento = findViewById(R.id.editTextDataNascimento);
                this.editTextEndereco = findViewById(R.id.editTextEndereco);
                this.editTextEmail = findViewById(R.id.editTextEmail);
                this.editTextConfirmarEmail = findViewById(R.id.editTextConfirmarEmail);
                this.editTextSenha = findViewById(R.id.editTextSenha);
                this.editTextConfirmarSenha = findViewById(R.id.editTextConfirmarSenha);

                final String nome = editTextNome.getText().toString();
                final String telefone = editTextTelefone.getText().toString();
                final String cpf = editTextCpf.getText().toString();
                final String dataNascimento = editTextDataNascimento.getText().toString();
                final String email = editTextEmail.getText().toString();
                final String confirmarEmail = editTextConfirmarEmail.getText().toString();
                final String senha = editTextSenha.getText().toString();
                final String confirmarSenha = editTextConfirmarSenha.getText().toString();


                Contratante contratante = new Contratante();

                contratante.nome = nome;
                contratante.telefone = telefone;
                contratante.cpf = cpf;
                contratante.nascimento = dataNascimento;
                contratante.email = email;
                contratante.senha = senha;

                bdRef.child("contratante").push().setValue(contratante);

                Toast.makeText(FormCadastroContratante.this,"Contratante cadastrado com sucesso.",Toast.LENGTH_LONG).show();
                editTextNome.setText("");
                editTextTelefone.setText("");
                editTextCpf.setText("");
                editTextDataNascimento.setText("");
                editTextEmail.setText("");
                editTextSenha.setText("");

                Intent intent = new Intent(FormCadastroContratante.this, PerfilContratante.class);
                intent.putExtra("perfil", contratante);
                startActivity(intent);
            }
        });
    }
}
