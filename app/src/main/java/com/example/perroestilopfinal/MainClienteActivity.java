package com.example.perroestilopfinal;

import android.os.Bundle;

import com.example.perroestilopfinal.databinding.ActivityMainClienteBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.perroestilopfinal.databinding.ActivityMainClienteBinding;

public class MainClienteActivity extends AppCompatActivity {

    private ActivityMainClienteBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainClienteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_inicio_cliente, R.id.navigation_tienda_cliente, R.id.navigation_carrito_cliente,
                R.id.navigation_kits_cliente,R.id.navigation_cuenta_cliente)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main2);
     //   NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    }

}