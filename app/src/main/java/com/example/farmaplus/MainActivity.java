package com.example.farmaplus;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        drawerLayout.addDrawerListener(this);

        View header = navigationView.getHeaderView(0);
        header.findViewById(R.id.header_title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, getString(R.string.title_click),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int title;
        switch (menuItem.getItemId()) {
            case R.id.nav_inicio:
                title = R.string.nav_inicio;
                Fragment inicio = InicioFragment.newInstance(getString(title));
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.home_content, inicio)
                        .commit();
                break;
            case R.id.nav_favoritas:
                title = R.string.nav_favoritas;
                Fragment favoritas = FavoritasFragment.newInstance(getString(title));
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.home_content, favoritas)
                        .commit();
                break;
            case R.id.nav_cercanas:
                title = R.string.nav_cercanas;
                Fragment cercanas = CercanasFragment.newInstance(getString(title));
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.home_content, cercanas)
                        .commit();
                break;
            case R.id.nav_buscador:
                title = R.string.nav_buscador;
                Fragment buscador = BuscadorFragment.newInstance(getString(title));
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.home_content, buscador)
                        .commit();
                break;
            case R.id.nav_acercade:
                title = R.string.nav_acercade;
                Fragment acercaDe = AcercaDeFragment.newInstance(getString(title));
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.home_content, acercaDe)
                        .commit();
                break;
            default:
                throw new IllegalArgumentException("menu option not implemented!!");
        }

        setTitle(getString(title));
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {
        //cambio en la posición del drawer
    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        //el drawer se ha abierto completamente
        Toast.makeText(this, getString(R.string.navigation_drawer_open),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDrawerClosed(@NonNull View view) {
        //el drawer se ha cerrado completamente
    }

    @Override
    public void onDrawerStateChanged(int i) {
        //cambio de estado, puede ser STATE_IDLE, STATE_DRAGGING or STATE_SETTLING
    }

}
