package com.example.filmapp;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.example.filmapp.fragments.FragmentAbout;
import com.example.filmapp.fragments.FragmentFilm;
import com.example.filmapp.fragments.FragmentFvoriteList;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements FilmAdapter.FilmAdapterEvents {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawerLayout;
    FilmItem filmItem = new FilmItem();
     private BottomNavigationView bottomNavigationView;
     private BottomNavigationView.OnNavigationItemSelectedListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_app)
                .setDrawerLayout(drawer)
                .build();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();
        bottomNavigationView = findViewById(R.id.bottom_nav);
        listener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home_bottom:
                        addFilmFragment();
                        break;
                    case R.id.nav_favorite_bottom:
                        addFavoriteFragment();


                        break;

                }
                return true;
            }
        };
        bottomNavigationView.setOnNavigationItemSelectedListener(listener);



//        navigationView.setNavigationItemSelectedListener(this);
        addFilmFragment();


    }

private void addFilmFragment(){
    FragmentFilm fragmentFilm = new FragmentFilm();
    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,fragmentFilm).commit();

}
private void addFavoriteFragment(){
    FragmentFvoriteList fragmentFvoriteList = new FragmentFvoriteList();
    getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout,fragmentFvoriteList).addToBackStack(null).commit();
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add_friend) {
            String msg = "add friend";
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
            sendIntent.setType("text/plain");
            if (sendIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(sendIntent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void addFragmentAbout(FilmItem filmItem){
        Objects.requireNonNull(getSupportActionBar()).hide();

        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrameLayout, FragmentAbout.newInstance(filmItem)).addToBackStack(null).commit();


    }

    @Override
    public void onFilmClicked(FilmItem filmItem) {
       addFragmentAbout(filmItem);

    }


//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.nav_app:
//                Snackbar.make(findViewById(android.R.id.content), "Страница в разработке", Snackbar.LENGTH_LONG).show();
//                break;
//            case R.id.close_app:
//                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//                DialogInterface.OnClickListener lst = new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which) {
//                            case Dialog.BUTTON_POSITIVE:
//                                finish();
//                                break;
//                            case Dialog.BUTTON_NEGATIVE:
//                                dialog.dismiss();
//                                break;
//
//                        }
//
//                    }
//                };
//                builder.setTitle("Закрытие приложения");
//                builder.setMessage("Вы действительно хотите закрыть приложение?");
//                builder.setIcon(R.drawable.ic_info_black_24dp);
//                builder.setPositiveButton("Yes", lst);
//                builder.setNegativeButton("No", lst);
//                AlertDialog dialog = builder.create();
//                dialog.show();
//        }
//                return true;
//    }
}
