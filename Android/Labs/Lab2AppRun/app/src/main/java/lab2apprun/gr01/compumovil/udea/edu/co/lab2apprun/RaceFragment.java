package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RaceFragment extends Fragment {

    private Race race;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_race, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        if(null == race)
        {
            return;
        }
        TextView rName = (TextView) getActivity().findViewById(R.id.txvNameText);
        TextView rDesc = (TextView) getActivity().findViewById(R.id.txvDescText);
        TextView rDistance = (TextView) getActivity().findViewById(R.id.txvDistText);
        TextView rPlace = (TextView) getActivity().findViewById(R.id.txvPlaceText);
        TextView rDate = (TextView) getActivity().findViewById(R.id.txvDateText);
        TextView rPhone = (TextView) getActivity().findViewById(R.id.txvCPhoneText);
        TextView rEmail = (TextView) getActivity().findViewById(R.id.txvCEmailText);

        rName.setText("\t" + race.getName());
        rDesc.setText("\t" + race.getDescripion());
        rDistance.setText("\t" + race.getDistance());
        rPlace.setText("\t" + race.getPlace());
        rDate.setText("\t" + race.getDate());
        rPhone.setText("\t" + race.getContactPhone());
        rEmail.setText("\t" + race.getContactEmail());
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
