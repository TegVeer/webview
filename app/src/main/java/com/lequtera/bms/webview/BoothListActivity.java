package com.lequtera.bms.webview;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BoothListActivity extends AppCompatActivity {
    private String[] boothNames = {"Booth1", "Booth2", "Booth3", "Booth4", "Booth5", "Booth6", "Booth7", "Booth8", "Booth9", "Booth10", "Booth11"};
    private String[] boothCoordinates = {"geo:19.076,72.8777?z=21","geo:19.076,72.8777","geo:19.076,72.8777","geo:19.076,72.8777","geo:19.076,72.8777","geo:19.076,72.8777","geo:19.076,72.8777","geo:19.076,72.8777","geo:19.076,72.8777","geo:19.076,72.8777","geo:19.076,72.8777"};
    private int[] boothImages={R.drawable.booth,R.drawable.booth,R.drawable.booth,R.drawable.booth,R.drawable.booth,R.drawable.booth,R.drawable.booth,R.drawable.booth,R.drawable.booth,R.drawable.booth,R.drawable.booth};
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booth_list);
        listView = (ListView)findViewById(R.id.boothListView);
        final CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CustomDialogue customDialogue = new CustomDialogue();
            Bundle bundle = new Bundle();
            bundle.putString("Name",boothNames[position]);
            bundle.putString("Location",boothCoordinates[position]);
            customDialogue.setArguments(bundle);
            customDialogue.show((BoothListActivity.this).getSupportFragmentManager(),"Custom Dialogue");

            }
        });
    }
    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return boothNames.length;
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
        public View getView(final int position, View convertView, ViewGroup parent) {
            if(position == 0){
                convertView = getLayoutInflater().inflate(R.layout.select_booth_layout,null);
            }else {

                convertView = getLayoutInflater().inflate(R.layout.custom_list_layout, null);
                TextView boothName = (TextView) convertView.findViewById(R.id.customListBoothName);
                TextView boothCapacity = (TextView) convertView.findViewById(R.id.customListBoothCapacityTextView);
                TextView boothFacility = (TextView) convertView.findViewById(R.id.customListBoothFacilitiesText);
                ImageView boothImage = (ImageView) convertView.findViewById(R.id.customListBoothImage);
                boothName.setText(boothNames[position-1]);
                //TODO //retreve capacity data and inflate in boothCapacity var
                //TODO //retreve facility data and inflate in boothFacility var
                //TODO //retreve facility data and inflate in boothImage Click listener
                boothImage.setImageResource(boothImages[position-1]);
//            boothImage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent=null, chooser=null;
//                    intent.setData(Uri.parse(boothCoordingate[position]));
//                    chooser = Intent.createChooser(intent,"Launch Maps");
//                    startActivity(chooser);
//                }
//            });
            }

            return convertView;
        }

    }
}
