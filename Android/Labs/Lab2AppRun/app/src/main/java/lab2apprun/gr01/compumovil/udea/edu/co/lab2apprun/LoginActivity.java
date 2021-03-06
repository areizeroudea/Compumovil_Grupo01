package lab2apprun.gr01.compumovil.udea.edu.co.lab2apprun;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{
    // UI references.
    private EditText passwordView;
    private EditText userView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userView = (EditText) findViewById(R.id.txtUser);
        passwordView = (EditText) findViewById(R.id.txtPassword);

        Button siginBtn = (Button) findViewById(R.id.btnSignIn);
        siginBtn.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                doLogin();
            }
        });

        Button regBtn = (Button) findViewById(R.id.btnRegister);
        regBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showRegisterView();
            }
        });
    }

    private void showRegisterView()
    {
        Intent intent = new Intent(this, RegisterActivity.class);
        this.startActivity(intent);
    }

    private void doLogin()
    {
        if(validateLogin())
        {
            Intent intent = new Intent(this, RaceActivity.class);
            this.startActivity(intent);
        }
    }

    private boolean validateLogin()
    {
        String pass = passwordView.getText().toString();
        String usr = userView.getText().toString();

        ProfileDAO dao = new ProfileDAO(this);
        dao.open();
        Profile profile = dao.getProfileByUserName(usr);
        dao.close();


        return true;
    }
}

