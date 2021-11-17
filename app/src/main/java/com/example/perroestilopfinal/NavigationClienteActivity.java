package com.example.perroestilopfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.perroestilopfinal.ui.carrito.CarritoFragment;
import com.example.perroestilopfinal.ui.cuentaCliente.CuentaClienteFragment;
import com.example.perroestilopfinal.ui.homeCliente.HomeClienteFragment;
import com.example.perroestilopfinal.ui.kitsCliente.KitsClienteFragment;
import com.example.perroestilopfinal.ui.tienda.TiendaClienteFragment;

public class NavigationClienteActivity extends AppCompatActivity {

    com.etebarian.meowbottomnavigation.MeowBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_cliente);
        bottomNavigation=findViewById(R.id.nav_view);

        bottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.ic_baseline_storefront_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3,R.drawable.ic_baseline_shopping_cart_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.ic_baseline_developer_board_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(5,R.drawable.ic_baseline_account_circle_24));

        bottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment=null;
                switch (item.getId()){
                    case 1:
                        fragment=new HomeClienteFragment();
                        break;

                    case 2:
                        fragment=new TiendaClienteFragment();
                        break;

                    case 3:
                        fragment=new CarritoFragment();
                        break;
                    case 4:
                        fragment=new KitsClienteFragment();
                        break;
                    case 5:
                        fragment=new CuentaClienteFragment();
                        break;
                }
                loadFragment(fragment);
            }
        });

        //Set notification count
        bottomNavigation.setCount(3,"0");

        bottomNavigation.show(1,true);

        bottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Display toast
              //  Toast.makeText(getApplicationContext(),"Clic en "+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });

        bottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
             //   Toast.makeText(getApplicationContext(),"RESELECCION en "+item.getId(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        //Remplazdo de fregamene
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.nav_host_fragment_activity_navigacion_cliente,fragment)
                .commit();

    }
}