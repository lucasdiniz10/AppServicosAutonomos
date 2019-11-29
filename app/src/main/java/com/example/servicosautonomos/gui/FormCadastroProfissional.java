package com.example.servicosautonomos.gui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.servicosautonomos.R;
import com.example.servicosautonomos.classesbasicas.Profissional;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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

    private static final int CAMERA_REQUEST = 0;
    private final int PICK_IMAGE = 1;

    private Uri filePath;
    private StorageReference mStorageRef;


    Button buttonLogin, buttonAbrirCamera;
    ImageView imageViewFotoProfissional;

    EditText editTextEnderecoNomeRua, editTextEnderecoNumero, editTextEnderecoBairro, editTextEnderecoCidade, editTextEnderecoEstado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro_profissional);

        this.buttonLogin = findViewById(R.id.buttonAddContato);
        this.buttonAbrirCamera = findViewById(R.id.buttonAbrirCamera);
        this.imageViewFotoProfissional = findViewById(R.id.imageViewFotoProfissional);

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

        buttonAbrirCamera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                selectImage();
            }
        });


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
                }
                /*
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
                 */

                if (cpf.isEmpty()) {
                    editTextCpf.setError("Campo obrigatório");
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
                } else if (!EMAIL_PATTERN.matcher(email).matches()){
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
                } else if (senha.length() < 6 ) {
                    editTextSenha.setError("Senha deve ter no mínimo 6 caracteres");
                    editTextSenha.requestFocus();
                    return;
                }

                if (confirmarSenha.isEmpty()) {
                    editTextConfirmarSenha.setError("Campo obrigatório");
                    editTextConfirmarSenha.requestFocus();
                    return;
                } else if (!confirmarSenha.equals(senha)) {
                    editTextConfirmarSenha.setError("Senha não coincide");
                    editTextConfirmarSenha.requestFocus();
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

                Toast.makeText(FormCadastroProfissional.this, "Profissional cadastrado com sucesso.", Toast.LENGTH_LONG).show();

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

                /*Intent intent = new Intent(FormCadastroProfissional.this, PerfilProfissional.class);
                startActivity(intent);*/


                geoLocate(profissional);

            }
        });
    }

    private void escolherImagemDaCamera() {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 0);
    }

    private void escolherImagemDaGaleria() {
        try {
            Intent intent = new Intent(Intent.ACTION_PICK,
                    MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            intent.setType("image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("scale", true);
            intent.putExtra("outputX", 256);
            intent.putExtra("outputY", 256);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("return-data", true);
            startActivityForResult(intent, 1);
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void selectImage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(FormCadastroProfissional.this);
        builder.setTitle("Obter imagem");
        final CharSequence[] items = {"Tirar Foto", "Escolher da Galeria", "Cancelar"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = Utility.checkPermission(FormCadastroProfissional.this);

                switch (item) {
                    case 0:
                        escolherImagemDaCamera();
                        break;
                    case 1:
                        escolherImagemDaGaleria();
                        break;
                    case 2:
                        dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        filePath = data.getData();
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap mphoto = (Bitmap) data.getExtras().get("data");
            getCroppedBitmap(mphoto);
            imageViewFotoProfissional.setImageBitmap(mphoto);
        }

        else if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            if (requestCode == 1) {
                final Bundle extras = data.getExtras();
                if (extras != null) {
                    //Get image
                    Bitmap newProfilePic = extras.getParcelable("data");
                    getCroppedBitmap(newProfilePic);
                    imageViewFotoProfissional.setImageBitmap(newProfilePic);
                }
            }
        }

    }

    public Bitmap getCroppedBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        //Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
        //return _bmp;
        return output;
    }

    private void uploadImage() {

        if (filePath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();

            StorageReference ref = mStorageRef.child("images/" + UUID.randomUUID().toString());
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(FormCadastroProfissional.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(FormCadastroProfissional.this, "Failed " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded " + (int) progress + "%");
                        }
                    });
        }
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

        Intent intent = new Intent(FormCadastroProfissional.this, EditarPerfilProfissional.class);
        intent.putExtra("dados", profissional);
        startActivity(intent);
    }
}
