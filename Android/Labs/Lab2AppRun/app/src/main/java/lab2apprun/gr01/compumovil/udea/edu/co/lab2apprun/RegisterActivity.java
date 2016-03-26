package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void createProfile(View view)
    {
        EditText usrE = (EditText) findViewById(R.id.txtUsrReg);
        EditText passE = (EditText) findViewById(R.id.txtPasswordReg);
        EditText emailE = (EditText) findViewById(R.id.txtEmailReg);

        String usr = usrE.getText().toString();
        String pass = passE.getText().toString();
        String email = emailE.getText().toString();

        Profile profile = new Profile();
        profile.setUserName(usr);
        profile.setPassword(pass);
        profile.setEmail(email);

        ProfileDAO dao = new ProfileDAO(this);
        dao.open();
        dao.insertProfile(profile);
        dao.close();

        Intent intent = new Intent(this, LoginActivity.class);
        this.startActivity(intent);
    }
}
