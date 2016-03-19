package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;

import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class RaceActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    Fragment raceFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);

        if(savedInstanceState == null)
        {
            raceFragment = new RacesListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();  //necesario para crear el transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();   //necesario para manipular freagments

            fragmentTransaction.add(R.id.content_frame, raceFragment);
            fragmentTransaction.commit();   //indicamos los cambios
        }

        /*Aniadimos las acciones para el menu lateral (NavigationView)*/
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.nav_races)
        {
            raceFragment = new RacesListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();  //necesario9 para crear el transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();   //necesario para manipular freagments

            fragmentTransaction.add(R.id.content_frame, raceFragment);
            fragmentTransaction.commit();   //indicamos los cambios
        }
        else if(id == R.id.nav_profile)
        {
            Log.d("RaceActivity", "Perfil de usuario");
        }
        else if(id == R.id.nav_about)
        {
            Log.d("RaceActivity", "Acerca de");
        }

        /*Ocultamos el menu*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void goToCreateRace(View v)
    {
        Fragment insertRaceFrag = new RaceInsertFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();  //necesario9 para crear el transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();   //necesario para manipular freagments
        fragmentTransaction.replace(R.id.content_frame, insertRaceFrag);
        fragmentTransaction.addToBackStack("Este es un key inutil");    //necesario para que los fragments tengan retroceso
        fragmentTransaction.commit();
    }
}
