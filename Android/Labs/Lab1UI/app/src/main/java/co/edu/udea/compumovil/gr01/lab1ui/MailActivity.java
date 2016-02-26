package co.edu.udea.compumovil.gr01.lab1ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MailActivity extends AppCompatActivity {

    private EditText mDateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);

        mDateDisplay = (EditText) findViewById(R.id.dateDisplay);
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.timeButton:
                DialogFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.show(getFragmentManager(), "timePicker");
                break;

            case R.id.dateButton:
                DialogFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.show(getFragmentManager(), "datePicker");
                break;
        }

    }
}
