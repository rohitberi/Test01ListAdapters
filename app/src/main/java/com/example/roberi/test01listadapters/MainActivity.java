package com.example.roberi.test01listadapters;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    ListView l;
//    String[] counter = {"1","2","3","4","5","6","7"};
//    String[] days = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};

    String[] memeTitles;
    String[] memeDescriptions;
    int[] images = {R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4, R.drawable.icon5, R.drawable.icon6, R.drawable.icon7, R.drawable.icon8, R.drawable.icon9, R.drawable.icon10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = (ListView) findViewById(R.id.ListView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.customlistview,);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.customlistview,R.id.textView,days);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.customlistview02,R.id.textView3,days);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,days);

        Resources res = getResources();
        memeTitles = res.getStringArray(R.array.title);
        memeDescriptions = res.getStringArray(R.array.description);

        customListAdapter adapter = new customListAdapter(this, images, memeTitles, memeDescriptions);
        l.setAdapter(adapter);
//        l.setAdapter(adapter);

    }
}

class customListAdapter extends ArrayAdapter<String>
{
    Context context;
    int[] images;
    String[] titles;
    String[] description;

    public customListAdapter(Context c, int[] imgs, String[] titles, String[] description) {
        super(c,R.layout.customlistview02,R.id.textView2,titles);
        this.context = c;
        this.images = imgs;
        this.titles = titles;
        this.description = description;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.customlistview02, parent, false);


        ImageView myImage = (ImageView)  row.findViewById(R.id.imageView2);
        TextView myTitle = (TextView) row.findViewById(R.id.textView2);
        TextView myDescription = (TextView) row.findViewById(R.id.textView3);

//        myImage.setBackgroundResource(images[position]);
        myImage.setImageResource(images[position]);
        myTitle.setText(titles[position]);
        myDescription.setText(description[position]);


//        return super.getView(position, convertView, parent);
        return row;
    }

    @Override
    public String getItem(int position) {
        return super.getItem(position);
    }
}