package ilo.ilo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class SignUpActivity extends AppCompatActivity {

    SignUpHelper mForm;
    EditText mFirstName, mLastName, mUsername;
    EditText mEmail;
    EditText mPassword, mConfirmPassword;
    EditText mDateOfBirth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirstName = findViewById(R.id.edit_signup_first);
        mLastName = findViewById(R.id.edit_signup_last);
        mUsername = findViewById(R.id.edit_signup_username);
        mEmail = findViewById(R.id.edit_signup_email);
        mPassword = findViewById(R.id.edit_signup_password);
        mConfirmPassword = findViewById(R.id.edit_signup_confirm);
        mDateOfBirth = findViewById(R.id.edit_signup_date);
        findViewById(R.id.button_signup_register).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                mForm = new SignUpHelper(mEmail.getText().toString(), mUsername.getText().toString(), mPassword.getText().toString(),
                                        mConfirmPassword.getText().toString(), mDateOfBirth.getText().toString(), mFirstName.getText().toString(), mLastName.getText().toString());

                if(mForm.register()){

                    Intent i = new Intent(SignUpActivity.this, ViewProfileActivity.class);
                    startActivity(i);

                } else{

                    //TODO Highlight parts of form that aren't working and or user already exist

                }
            }
        });
    }
}
