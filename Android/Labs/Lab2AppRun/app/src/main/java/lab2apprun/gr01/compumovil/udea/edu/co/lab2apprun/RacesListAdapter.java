package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by areizero on 18/03/2016.
 */
public class RacesListAdapter extends ArrayAdapter<Race>
{
    private final Context context;
    private final List<Race> values;

    public RacesListAdapter(Context context, List<Race> values)
    {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_races_list, parent, false);
        TextView itemName = (TextView) itemView.findViewById(R.id.itemName);
        TextView itemDate = (TextView) itemView.findViewById(R.id.itemDate);
        TextView itemDistance = (TextView) itemView.findViewById(R.id.itemDistance);
        TextView itemPlace = (TextView) itemView.findViewById(R.id.itemPlace);

        Race race = values.get(position);
        itemName.setText("Carrera: " + race.getName().toString());
        itemDate.setText("Fecha: " + race.getDate().toString());
        itemDistance.setText("Distancia: " + race.getDistance().toString());
        itemPlace.setText("Lugar: " + race.getPlace().toString());

        return itemView;
    }
}
