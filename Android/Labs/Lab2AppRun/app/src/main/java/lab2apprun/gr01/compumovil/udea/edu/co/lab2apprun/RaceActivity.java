package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RaceActivity extends AppCompatActivity {

    Fragment raceFragment;
    String[] navOptions;
    private DrawerLayout drawerLayout;
    private ListView drawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race);

        /*Asignando el menu de navigation list*/
        navOptions = new String[]{"Carreras", "Perfil", "Acerca de"};
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);

        /*
        if(savedInstanceState == null)
        {
            raceFragment = new RacesListFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();  //necesario9 para crear el transaction
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();   //necesario para manipular freagments

            fragmentTransaction.add(R.id.drawer_layout, raceFragment);
            fragmentTransaction.commit();   //indicamos los cambios
        }
        */
    }
}
