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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

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

    public void viewRaceDetail(View v, Race race)
    {
        /*Obtenemos la Carrera con el id especificado*/
        RaceDAO dao = new RaceDAO(this);
        dao.open();
        Race completeRace = dao.getRaceById(race.getId());
        dao.close();

        RaceFragment raceFrag = new RaceFragment();
        raceFrag.setRace(completeRace);

        FragmentManager fragmentManager = getSupportFragmentManager();  //necesario9 para crear el transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();   //necesario para manipular freagments
        fragmentTransaction.replace(R.id.content_frame, raceFrag);
        fragmentTransaction.addToBackStack("Este es un key inutil");    //necesario para que los fragments tengan retroceso
        fragmentTransaction.commit();
    }

    public void addRace(View v)
    {
        RaceDAO dao = new RaceDAO(this);

        EditText nameE = (EditText)findViewById(R.id.txtRName);
        EditText descripionE = (EditText)findViewById(R.id.txtRDescription);
        EditText distanceE = (EditText)findViewById(R.id.txtRDistance);
        EditText placeE = (EditText)findViewById(R.id.txtRPlace);
        EditText contactPhoneE = (EditText)findViewById(R.id.txtRCPhone);
        EditText contactEmailE = (EditText)findViewById(R.id.txtRCEmail);
        EditText dateE = (EditText)findViewById(R.id.txtRDate);

        String name = nameE.getText().toString();
        String descripion = descripionE.getText().toString();
        String distance = distanceE.getText().toString();;
        String place = placeE.getText().toString();;
        String contactPhone = contactPhoneE.getText().toString();;
        String contactEmail = contactEmailE.getText().toString();;
        String date = dateE.getText().toString();;

        Race race = new Race();
        race.setName(name);
        race.setDescripion(descripion);
        race.setDistance(distance);
        race.setPlace(place);
        race.setContactEmail(contactEmail);
        race.setContactPhone(contactPhone);
        race.setDate(date);

        dao.open();
        Race retRace = dao.insertRace(race);
        dao.close();

        Fragment insertRaceFrag = new RacesListFragment(); //clase a la que iremos
        FragmentManager fragmentManager = getSupportFragmentManager();  //necesario9 para crear el transaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();   //necesario para manipular freagments
        fragmentTransaction.replace(R.id.content_frame, insertRaceFrag);
        fragmentTransaction.commit();

        Toast.makeText(this, "Anhadida a BD la carrera: " + retRace.getId(), Toast.LENGTH_SHORT).show();
    }
}
