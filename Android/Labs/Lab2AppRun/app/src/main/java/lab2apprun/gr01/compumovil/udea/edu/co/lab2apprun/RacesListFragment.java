package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;


import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RacesListFragment extends Fragment implements AdapterView.OnItemClickListener
{
    ListView listView;
    RacesListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_races_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        //Indicamos el DAO para races
        RaceDAO dao = new RaceDAO(getActivity());
        Log.d("RaceListFragment", "Dao Creado");

        super.onActivityCreated(savedInstanceState);
        /*Creamos el adapter para los items*/
        dao.open();
        //dao.insertRace(new Race(0, "CarreraTest", "2015", "Desc", "23KM", "Lugar", "15353", "sdf@email.com"));
        List<Race> races = dao.getAllRaces();
        dao.close();

        /*Establecemos el adaptador de items*/
        //ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.colors, android.R.layout.simple_list_item_1);
        adapter = new RacesListAdapter(getActivity(), races);
        listView =(ListView) getActivity().findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Race item = adapter.getRace(position);
        //Toast.makeText(getActivity(), "Item: " + item.getId() + " - " + item.getName(), Toast.LENGTH_SHORT).show();

        RaceActivity rAct = (RaceActivity) getActivity();
        //rAct.goToCreateRace(view);
        rAct.viewRaceDetail(view, item);
    }
}
