package ilo.ilo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LogInActivity extends AppCompatActivity {
    LogInHelper mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        // here is where
        // you add your checking functions
        // and move from loginActivity to my profile
        findViewById(R.id.button_login_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = new LogInHelper("wow@wow.com", "123");
                mAuth.isValidEmail();
                mAuth.isValidPassword();
                //TODO make call to database to login in user
                Intent i = new Intent(LogInActivity.this, ViewProfileActivity.class);
            }
        });

    }

}
