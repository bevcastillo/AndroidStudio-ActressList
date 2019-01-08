package com.example.beverly.actresslist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    //properties
    EditText txtsearch;
    ListView lv;

    //adapter
    //ArrayAdapter<Names> adapter;
    Adapter adapter;
    Names[] list={
            new Names(R.drawable.andrea,"Andrea Brillantes"),
            new Names(R.drawable.angellocsin,"Angel Locsin"),
            new Names(R.drawable.anne,"Anne Curtis"),
            new Names(R.drawable.barbie,"Barbie Imperial"),
            new Names(R.drawable.beaalonzo,"Bea Alonzo"),
            new Names(R.drawable.cristinereyes,"Cristine Reyes"),
            new Names(R.drawable.ella,"Ella Cruz"),
            new Names(R.drawable.janella,"Janella Salvador"),
            new Names(R.drawable.julia,"Julia Barreto"),
            new Names(R.drawable.juliamontes,"Julia Montes"),
            new Names(R.drawable.kim,"Kim Chiu"),
            new Names(R.drawable.loisa,"Loisa Andalia"),
            new Names(R.drawable.marianrivera,"Marian Rivera"),
            new Names(R.drawable.maris,"Maris Racal"),
            new Names(R.drawable.nadine,"Nadine Lustre"),
    };


    ArrayList<Names> findlist = new ArrayList<Names>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //retreive the resources data, put them on the array
        //list = this.getResources().getStringArray(R.array.names);

        //instantiate
        this.txtsearch = (EditText) this.findViewById(R.id.editTextSearch);
        this.lv = (ListView) this.findViewById(R.id.listview1);

        adapter = new Adapter(this,findlist);
        //attach the adatper to the listview
        //this.lv = (ListView) this.findViewById(R.id.listview1);
        //adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);

        //attach the adapter to the listview
        this.lv.setAdapter(adapter);

        this.txtsearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                findlist.clear();

                //using regex = regular expression
                String s1 = s.toString();
                Pattern pattern = Pattern.compile(s1);

                for(int i = 0; i < list.length; i++){
                    Matcher match = pattern.matcher(list[i].getName());
                    if(match.find()){
                        findlist.add(list[i]);
                    }
                }
                //update the adapter
                adapter.notifyDataSetChanged();

            }});

    }

}
