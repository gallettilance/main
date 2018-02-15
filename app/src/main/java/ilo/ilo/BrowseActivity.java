package ilo.ilo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        // on click listener for leader_board button
        // takes you to leader_board form
        findViewById(R.id.button_browse_leader_board).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BrowseActivity.this, LeaderBoardActivity.class);
                startActivity(intent);
            }
        });

        // on click listener for user_search button
        // takes you to user_search form
        findViewById(R.id.button_browse_user_search).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(BrowseActivity.this, UserSearchActivity.class);
                startActivity(intent);
            }
        });

        // on click listener for view_modules button
        // takes you to view_modules activity
        findViewById(R.id.button_browse_view_programs).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent=new Intent(BrowseActivity.this, ViewModulesActivity.class);
                startActivity(intent);
            }
        });




    }
}
