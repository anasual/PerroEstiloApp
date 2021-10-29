package com.example.perroestilopfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.perroestilopfinal.usuario.usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class CrearCuenta extends AppCompatActivity {

    EditText nombre,apellido,email,celular,contrasenia,confContrasenia;
    Button registrarme;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //Kevin

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        nombre = findViewById(R.id.edtCCNombre);
        apellido = findViewById(R.id.edtCCApellido);
        email = findViewById(R.id.edtCCEmail);
        celular = findViewById(R.id.edtCCTelefono);
        contrasenia = findViewById(R.id.edtCCCPassword);
        confContrasenia = findViewById(R.id.edtCCPassword);
        iniciaFirebase();

        registrarme = findViewById(R.id.btnCCRegistrarme);
        registrarme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valida();
            }
        });
    }
    public void iniciaFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    public void valida(){
        //
        String name = nombre.getText().toString();
        String lname = apellido.getText().toString();
        String correo = email.getText().toString();
        String psw = contrasenia.getText().toString();
        String confirma = confContrasenia.getText().toString();
        String telefono = celular.getText().toString();
        if (name.equals("")){
            nombre.setError("Campo obligatorio");
        }else if(lname.equals("")){
            apellido.setError("Campo obligatorio");
        }else if(correo.equals("")){
            email.setError("Campo obligatorio");
        }else if(confirma.equals("")){
            confContrasenia.setError("Campo obligatorio");
        }else if(telefono.equals("")){
            celular.setError("Campo obligatorio");
        }else if(psw.equals("")){
            contrasenia.setError("Campo obligatorio");
        }else if(!confirma.equals(psw)){
            confContrasenia.setError("Las contraseñas no coinciden");
        }else{
            usuario user = new usuario();
            user.setUid(UUID.randomUUID().toString());
            user.setNombre(name);
            user.setApellido(lname);
            user.setCorreo(correo);
            user.setContrasenia(psw);
            user.setCelular(telefono);
            databaseReference.child("Usuarios").child(user.getUid()).setValue(user);
            Toast.makeText(this,"Agregado",Toast.LENGTH_LONG).show();
            limpiar();
        }
    }
    public void limpiar(){
        nombre.setText("");
        apellido.setText("");
        email.setText("");
        contrasenia.setText("");
        confContrasenia.setText("");
        celular.setText("");
    }
}