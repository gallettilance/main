package ilo.ilo;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by robin on 3/25/2018.
 */

public class CustomListAdapter extends ArrayAdapter {
    // to reference activity (store what activity ListView is on)
    private final Activity context;
    // to store images
    private final Integer[] imageIDarray;
    //  to store list of module names
    private final String[] nameArray;
    // to store list of info
    private final String[] infoArray;

    public CustomListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam, Integer[] imageIDArrayParam){

        super(context,R.layout.view_modules_listview_row , nameArrayParam);
        this.context=context;
        this.imageIDarray = imageIDArrayParam;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;
    }

    public View getView(int position, View view, ViewGroup parent) {
        //  maps data from above properties to write fields in view_modules_listview_row.xml
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.view_modules_listview_row, null,true);

        //  gets references to objects in the view_modules_listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.text_listview_title);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.text_listview_info);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.image_listview_row);

        //  sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);
        imageView.setImageResource(imageIDarray[position]);

        return rowView;

    }

}


