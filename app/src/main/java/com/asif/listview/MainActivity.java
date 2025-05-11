package com.asif.listview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    ArrayList<HashMap <String, String>> arrayList = new ArrayList<>();
    HashMap <String, String> hashMap;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.listView);


        hashMap = new HashMap<>();
        hashMap.put("Name", "Asif Al Rumel");
        hashMap.put("Mobile" , "01783724739");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Name", "Bill Gates");
        hashMap.put("Mobile" , "93898958939");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Name", "Elon Mask");
        hashMap.put("Mobile" , "77747847");
        arrayList.add(hashMap);






        MyAdapter myAdapter = new MyAdapter();
        myListView.setAdapter(myAdapter);
    } // on create bundle end


    // =================================================================================================

    private class MyAdapter extends BaseAdapter {

        LayoutInflater layoutInflater;


        @Override
        public int getCount() {
            return arrayList.size(); // joto dibo toto bar ghotbe item..
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            ViewGroup ViewGroup = null;
            View myView = layoutInflater.inflate(R.layout.item, ViewGroup, false);

            ImageView imageView = myView.findViewById(R.id.imageView);
            TextView tvName = myView.findViewById(R.id.tvName);
            TextView tvMobile = myView.findViewById(R.id.tvMobile);




            HashMap <String, String> hashMap = arrayList.get(position);

            tvName.setText(hashMap.get("Name"));
            tvMobile.setText(hashMap.get("Mobile"));




            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Hello\nitem number "+position, Toast.LENGTH_SHORT).show();
                }
            });



            return myView;


        }
    }

    // =================================================================================================

}