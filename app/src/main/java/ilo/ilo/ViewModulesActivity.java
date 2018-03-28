package ilo.ilo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
//

public class ViewModulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_modules);

        CustomListAdapter list = new CustomListAdapter(this, nameArray, infoArray, imageArray);
        listView = (ListView) findViewById(R.id.list_view_modules);
        listView.setAdapter(list);
    }

    ListView listView;
    String[] nameArray = {"Module 1", "Module2", "Module3"};
    String[] infoArray = {"Description of first module", "Description of second module","Description of third module"};
    Integer[] imageArray = {R.drawable.badge2,R.drawable.badge2,R.drawable.badge2};
}
