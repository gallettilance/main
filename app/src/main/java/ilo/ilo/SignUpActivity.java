package ilo.ilo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.ExecutionException;

public class SignUpActivity extends AppCompatActivity {

    SignUpHelper mForm;
    EditText mFirstName, mLastName, mUsername;
    EditText mEmail;
    EditText mPassword, mConfirmPassword;
    EditText mDateOfBirth;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
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

                mAuth.createUserWithEmailAndPassword(mForm.getEmail(), mForm.getPassword()).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(SignUpActivity.this, ViewProfileActivity.class);
                            startActivity(i);
                        }
                    }
                });
            }
        });
    }
}
