package com.converter.onlineshoppingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class Accinfo extends AppCompatActivity {
    ListView listView;
    TextView back, back2;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_accinfo);
        listView = findViewById(R.id.lv);

        int imglist[] = {R.drawable.profile, R.drawable.phone, R.drawable.email, R.drawable.address, R.drawable.dob};
        String namelist[] = {"Name", "Mobile", "Email", "Address", "D.O.B"};
        String nameitem[] = {"username", "+91-8602510654", "sample1@gmail.com", "Indore", "13-09-2003"};


        ListAdapter listAdapter1 = new ListAdapter(getApplicationContext(), dataArrayList);
        listView.setAdapter(listAdapter1);
        for (int i = 0; i < imglist.length; i++) {
            listData = new ListData(namelist[i], nameitem[i], imglist[i]);
            dataArrayList.add(listData);
            back = (TextView) findViewById(R.id.back);
            back2 = (TextView) findViewById(R.id.back2);
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            back2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
        }
    }

}