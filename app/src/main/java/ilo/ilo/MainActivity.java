package ilo.ilo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on click listener to login button
        // takes you to login form
        findViewById(R.id.button_main_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                startActivity(intent);
            }
        });

        // on click listener for signup button
        // takes you to signup form
        findViewById(R.id.button_main_signup).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        // on click listener for browse button
        // takes you to browse activity
        findViewById(R.id.button_main_browse).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, BrowseActivity.class);
                startActivity(intent);
            }
        });
    }
}
