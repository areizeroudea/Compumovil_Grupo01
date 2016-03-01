package co.edu.udea.compumovil.gr01.lab1ui;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

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
    private Spinner spinHobbies;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        establecerReferencias();
        spinHobbies.setOnItemClickListener(R.id.spinner);

    }

    public void establecerReferencias(){
        editNombres = (EditText) findViewById(R.id.editText);
        editApellidos = (EditText) findViewById(R.id.editText2);
        mDateDisplay = (TextView) findViewById(R.id.dateDisplay);
        btnMostrar = (Button) findViewById(R.id.button);
        txtInformacion = (TextView) findViewById(R.id.textView3);
        radioHombre = (RadioButton) findViewById(R.id.radio_hombre);
        radioMujer = (RadioButton) findViewById(R.id.radio_mujer);
        spinHobbies = (Spinner) findViewById(R.id.spinner);
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

    public void mostrarInformacion(View v){
        String Nombres = editNombres.getText().toString();
        String Apellidos = editApellidos.getText().toString();
        String Fecha = mDateDisplay.getText().toString();
        txtInformacion.setText("Nombres: "+Nombres + System.getProperty("line.separator")+
                               "Apellidos: "+Apellidos+ System.getProperty("line.separator")+
                               "Sexo: "+sexo+System.getProperty("line.separator")+
                               "Fecha: "+Fecha);
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
