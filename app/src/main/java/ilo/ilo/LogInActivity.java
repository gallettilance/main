package ilo.ilo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class LogInActivity extends AppCompatActivity {

    LogInHelper mAuth;
    EditText mUsername;
    EditText mPassword;
    HttpGETRequest test = new HttpGETRequest();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mUsername = findViewById(R.id.edit_login_username);
        mPassword = findViewById(R.id.edit_login_password);

        // here is where
        // you add your checking functions
        // and move from loginActivity to my profile

        findViewById(R.id.button_login_login).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mAuth = new LogInHelper(mUsername.getText().toString(), mPassword.getText().toString());

                if(!mAuth.isValidUser()){
                    Toast.makeText(getApplicationContext(),"User does not exist",Toast.LENGTH_SHORT).show();
                }

                else if(!mAuth.isValidPassword()){

                    Toast.makeText(getApplicationContext(),"Invalid Password",Toast.LENGTH_SHORT).show();

                } else{

                    //TODO make call to database to login in user
                    Intent i = new Intent(LogInActivity.this, ViewProfileActivity.class);

                }
            }
        });
    }
}
