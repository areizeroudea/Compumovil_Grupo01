package co.edu.udea.compumovil.gr01.lab1ui;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
<<<<<<< HEAD
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
=======
import android.widget.Button;
>>>>>>> 31a1cab604d58f252ef18384750f2ba6668dc196
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import java.util.StringTokenizer;

public class MailActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener
{
    private TextView mDateDisplay;
    private int mYear;
    private int mMonth;
    private int mDay;
    private EditText editNombres;
    private EditText editApellidos;
    private Button btnMostrar;
    private TextView txtInformacion;
    private RadioButton radioHombre;
    private RadioButton radioMujer;
<<<<<<< HEAD
    private Spinner spinner;
    private AutoCompleteTextView autoPais;
=======
    private Spinner spinHobbies;
>>>>>>> 31a1cab604d58f252ef18384750f2ba6668dc196




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        establecerReferencias();
<<<<<<< HEAD

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.hobbies_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

// Get a reference to the AutoCompleteTextView in the layout
        autoPais = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
// Get the string array
        String[] countries = getResources().getStringArray(R.array.countries);
// Create the adapter and set it to the AutoCompleteTextView
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        autoPais.setAdapter(adapter2);
        autoPais.setThreshold(1);

=======
        spinHobbies.setOnItemClickListener(R.id.spinner);

>>>>>>> 31a1cab604d58f252ef18384750f2ba6668dc196
    }

    public void establecerReferencias(){
        editNombres = (EditText) findViewById(R.id.editText);
        editApellidos = (EditText) findViewById(R.id.editText2);
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        btnMostrar = (Button) findViewById(R.id.button);
        txtInformacion = (TextView) findViewById(R.id.textView3);
        radioHombre = (RadioButton) findViewById(R.id.radio_hombre);
        radioMujer = (RadioButton) findViewById(R.id.radio_mujer);
<<<<<<< HEAD
        spinner = (Spinner) findViewById(R.id.spinner);
=======
        spinHobbies = (Spinner) findViewById(R.id.spinner);
>>>>>>> 31a1cab604d58f252ef18384750f2ba6668dc196
    }
    private String sexo;
    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_hombre:
                if (checked)
                    sexo="Masculino";
                    break;
            case R.id.radio_mujer:
                if (checked)
                    sexo="Femenino";
                    break;
        }
    }

<<<<<<< HEAD

    String hobbie;
=======
>>>>>>> 31a1cab604d58f252ef18384750f2ba6668dc196
    public void mostrarInformacion(View v){
        String Nombres = editNombres.getText().toString();
        String Apellidos = editApellidos.getText().toString();
        String Fecha = mDateDisplay.getText().toString();
<<<<<<< HEAD
        hobbie = spinner.getSelectedItem().toString();
        String pais = autoPais.getText().toString();
        String favorito;
        if(((CheckBox) findViewById(R.id.checkBox)).isChecked()){
            favorito = getString(R.string.txtFavoritoSi);
        }else{
            favorito=getString(R.string.txtFavoritoNo);
        }
        txtInformacion.setText("Nombres: "+Nombres + System.getProperty("line.separator")+
                               "Apellidos: "+Apellidos+ System.getProperty("line.separator")+
                               "Sexo: "+sexo+System.getProperty("line.separator")+
                               "Fecha: "+Fecha+System.getProperty("line.separator")+
                               "Hobbie: "+hobbie+System.getProperty("line.separator")+
                               "Favorito: "+favorito+System.getProperty("line.separator")+
                               "Pais: "+pais);
=======
        txtInformacion.setText("Nombres: "+Nombres + System.getProperty("line.separator")+
                               "Apellidos: "+Apellidos+ System.getProperty("line.separator")+
                               "Sexo: "+sexo+System.getProperty("line.separator")+
                               "Fecha: "+Fecha);
>>>>>>> 31a1cab604d58f252ef18384750f2ba6668dc196
    }

    /*Identificamos cuando se hace click sobre algun elemento*/
    public void onClick(View v)
    {
        switch (v.getId())
        {
            //para el caso en que hagan click sobre el texto de fecha
            case R.id.dateDisplay:
                DialogFragment datePickerFragment = new DatePickerFragment();
                Log.v("MailActivity", "Se abrira el dialog de fecha?");
                datePickerFragment.show(getFragmentManager(), "datePicker");
                break;
        }
    }

    //metodo implementado debido a OnDateSetListener para que el picker de fecha (DatePickerFragment) realice una accion cuando se setee la fecha
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Log.v("MailActivity", "Setiando la fecha");
        mYear = year;
        mMonth = monthOfYear + 1;
        String month = "" + mMonth;
        if (mMonth < 10) {
            month = "0" + mMonth;
        }
        mDay = dayOfMonth;
        String day = "" + (mDay);
        if (mDay < 10) {
            day = "0" + (mDay);
        }
        mDateDisplay.setText("" + mYear + "-" + month + "-" + day);
    }







}
