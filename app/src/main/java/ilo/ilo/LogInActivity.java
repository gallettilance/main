package ilo.ilo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.ExecutionException;

public class LogInActivity extends AppCompatActivity {

    LogInHelper loginHelper;
    EditText mUsername;
    EditText mPassword;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth = FirebaseAuth.getInstance();
        mUsername = findViewById(R.id.edit_login_username);
        mPassword = findViewById(R.id.edit_login_password);


        findViewById(R.id.button_login_login).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                loginHelper = new LogInHelper(mUsername.getText().toString(), mPassword.getText().toString());

                if (loginHelper.getEmail().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter email address", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (loginHelper.getPassword().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(loginHelper.getEmail(), loginHelper.getPassword())
                        .addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent i = new Intent(LogInActivity.this, ViewProfileActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            }
                        });


            }
        });
    }
}
