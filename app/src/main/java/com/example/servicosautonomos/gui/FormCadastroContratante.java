package com.example.servicosautonomos.gui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Contratante;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
<<<<<<< HEAD
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
=======

>>>>>>> master
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormCadastroContratante extends AppCompatActivity implements View.OnClickListener {

<<<<<<< HEAD
    EditText editTextNome, editTextTelefone, editTextCpf, editTextDataNascimento,
            editTextEmail, editTextConfirmarEmail, editTextSenha, editTextConfirmarSenha;
=======
    private static final String TAG = "Contratante";
>>>>>>> master
    Button buttonLogin;
    private FirebaseAuth firebaseAuth;
    private AwesomeValidation awesomeValidation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro_contratante);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        //initializing firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //acessando o firebase para listar
        FirebaseApp.initializeApp(FormCadastroContratante.this);
        /*
        FirebaseDatabase bd = FirebaseDatabase.getInstance();
        final DatabaseReference bdRef = bd.getReference();
        FirebaseDatabase.getInstance().getReference("usuarios"); {
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

        initView();
    }

    private void initView() {

        this.editTextNome = findViewById(R.id.editTextNome);
        this.editTextTelefone = findViewById(R.id.editTextTelefone);
        this.editTextCpf = findViewById(R.id.editTextCpf);
        this.editTextDataNascimento = findViewById(R.id.editTextDataNascimento);
        this.editTextEmail = findViewById(R.id.editTextEmail);
        this.editTextConfirmarEmail = findViewById(R.id.editTextConfirmarEmail);
        this.editTextSenha = findViewById(R.id.editTextSenha);
        this.editTextConfirmarSenha = findViewById(R.id.editTextConfirmarSenha);
        this.buttonLogin = findViewById(R.id.buttonFinalizarCadastro);

        buttonLogin.setOnClickListener(this);

        addValidationToViews();
    }

    private void addValidationToViews() {

        final String nome = editTextNome.getText().toString();
        final String telefone = editTextTelefone.getText().toString();
        final String cpf = editTextCpf.getText().toString();
        final String email = editTextEmail.getText().toString();
        final String confirmarEmail = editTextConfirmarEmail.getText().toString();

        if(TextUtils.isEmpty(nome)){
            awesomeValidation.addValidation(this, R.id.editTextNome, RegexTemplate.NOT_EMPTY, R.string.err_nome);
            return;
        }

        {
            awesomeValidation.addValidation(this, R.id.editTextNome, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.err_nome2);
        }

        if(TextUtils.isEmpty(telefone)){
            awesomeValidation.addValidation(this, R.id.editTextTelefone, "^[+]?[0-9]{10,13}$", R.string.err_telefone);
            return;
        }

        if(TextUtils.isEmpty(cpf)) {


        }

        if(TextUtils.isEmpty(email)){

        }

        if(!TextUtils.equals(email,confirmarEmail)){

        }

        awesomeValidation.addValidation(this, R.id.editTextDataNascimento, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.err_data);

        awesomeValidation.addValidation(this, R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.err_email);
        awesomeValidation.addValidation(this, R.id.editTextConfirmarEmail, Patterns.EMAIL_ADDRESS, R.string.err_email);

        /*String regexPassword = ".{8,}";
        awesomeValidation.addValidation(this, R.id.etPassword, regexPassword, R.string.invalid_password);
        awesomeValidation.addValidation(this, R.id.etConfirmPassword, R.id.etPassword, R.string.invalid_confirm_password);

        awesomeValidation.addValidation(this, R.id.etAge, Range.closed(12, 60), R.string.invalid_age);*/
    }

    private void submitForm() {
        // Validate the form...
        if (awesomeValidation.validate()) {
            // Here, we are sure that form is successfully validated. So, do your stuffs now...

            FirebaseDatabase bd = FirebaseDatabase.getInstance();
            final DatabaseReference bdRef = bd.getReference();
            FirebaseDatabase.getInstance().getReference("usuarios");

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

            editTextNome.setText("");
            editTextTelefone.setText("");
            editTextCpf.setText("");
            editTextDataNascimento.setText("");
            editTextEmail.setText("");
            editTextSenha.setText("");

            firebaseAuth.createUserWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    //checking if success
                                    if (task.isSuccessful()) {
                                        //display some message here
                                        Toast.makeText(FormCadastroContratante.this, "Contratante cadastrado com sucesso.", Toast.LENGTH_LONG).show();
                                    } else {
                                        //display some message here
                                        Toast.makeText(FormCadastroContratante.this, "Erro", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

            Intent intent = new Intent(FormCadastroContratante.this, PerfilContratante.class);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        if (view == buttonLogin) {
            submitForm();
        }
    }


}

    /*
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            EditText editTextNome, editTextTelefone, editTextCpf, editTextDataNascimento, editTextEmail, editTextConfirmarEmail, editTextSenha, editTextConfirmarSenha;

            @Override
            public void onClick(View v) {

                onStart();

                this.editTextNome = findViewById(R.id.editTextNome);
                this.editTextTelefone = findViewById(R.id.editTextTelefone);
                this.editTextCpf = findViewById(R.id.editTextCpf);
                this.editTextDataNascimento = findViewById(R.id.editTextDataNascimento);
                this.editTextEmail = findViewById(R.id.editTextEmail);
                this.editTextConfirmarEmail = findViewById(R.id.editTextConfirmarEmail);
                this.editTextSenha = findViewById(R.id.editTextSenha);
                this.editTextConfirmarSenha = findViewById(R.id.editTextConfirmarSenha);

                //adding validation to edittexts
                awesomeValidation.addValidation(this, R.id.editTextNome, RegexTemplate.NOT_EMPTY, R.string.err_nome);
                //awesomeValidation.addValidation(this, R.id.editTextTelefone, "^[2-9]{2}[0-9]{8}$", R.string.err_telefone);

                //awesomeValidation.addValidation(this, R.id.editTextDataNascimento, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateerror);
                //awesomeValidation.addValidation(this, R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);


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

                Intent intent = new Intent(FormCadastroContratante.this, ListaDeServicos.class);
                startActivity(intent);
            }
        });
    }
}
*/
