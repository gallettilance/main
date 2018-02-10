package ilo.ilo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {
    SignUpHelper mForm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewById(R.id.button_signup_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //populate form with info from layout
                mForm = new SignUpHelper("test@wow.com", "first", "notsafe", "ooowrong", "12/31/13", "Bill", "Little");
                if(mForm.validateForm()){
                    //TODO Make database call with proper user information, get back authkey and load Viewprofile
                    Intent i = new Intent(SignUpActivity.this, ViewProfileActivity.class);
                    startActivity(i);
                }
               else{
                    //TODO Highlight parts of form that aren't working and or user already exist
                }
            }
        });
    }
}
