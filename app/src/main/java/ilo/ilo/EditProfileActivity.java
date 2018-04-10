package ilo.ilo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EditProfileActivity extends AppCompatActivity {

    TextView mFullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_view_edit);

        mFullname = findViewById(R.id.text_edit_input_name);

    }
}
