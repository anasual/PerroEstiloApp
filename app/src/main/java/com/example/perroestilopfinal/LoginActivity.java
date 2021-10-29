package com.example.perroestilopfinal;

import androidx.appcompat.app.AppCompatActivity;
import com.example.perroestilopfinal.usuario.usuario;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    EditText correo,contrasenia;
    Button iniciarSesion;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo = findViewById(R.id.edtLcorreo);
        contrasenia = findViewById(R.id.edtLpassword);
        iniciarSesion = findViewById(R.id.btnLIniciar);

        iniciaFirebase();
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
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
        if (correo.getText().toString().equals("") || contrasenia.getText().toString().equals("")){
            Toast.makeText(this,"Complete los campos",Toast.LENGTH_LONG).show();
        }else{

        }
    }

}