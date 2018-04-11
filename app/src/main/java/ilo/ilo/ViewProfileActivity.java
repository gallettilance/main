package ilo.ilo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class ViewProfileActivity extends AppCompatActivity {

// onClicks, isEditable(boolean) corresponding with onclick
    TextView mFullname;

    String FullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view);

        Intent intent = getIntent();
        try {
            FullName = intent.getExtras().getString("Name");
        } catch(Exception e){
            FullName = "John Smith";
        }

        mFullname = findViewById(R.id.text_full_name);
        mFullname.setText(FullName);

        findViewById(R.id.button_view_edit_icon).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent editProfileIntent = new Intent(ViewProfileActivity.this, EditProfileActivity.class);
                startActivity(editProfileIntent);
                //              }
            }
        });

        findViewById(R.id.button_explore_progress).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent editProfileIntent = new Intent(ViewProfileActivity.this, ViewModulesActivity.class);
                startActivity(editProfileIntent);
                //              }
            }
        });


    }
}