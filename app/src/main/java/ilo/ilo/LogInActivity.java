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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        mUsername = findViewById(R.id.edit_login_username);
        mPassword = findViewById(R.id.edit_login_password);


        findViewById(R.id.button_login_login).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mAuth = new LogInHelper(mUsername.getText().toString(), mPassword.getText().toString());

                if(mAuth.isAuthenticated()){
                    Intent i = new Intent(LogInActivity.this, ViewProfileActivity.class);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
