package com.converter.onlineshoppingapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;


import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ListView listView;

    ImageView icon;
    ArrayList<ListHomeData> dataArrayList = new ArrayList<>();
    ListHomeData listHomeData;
    ImageView cartIcon;
    Drawable drawable;


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        listView = findViewById(R.id.listView);
        icon = findViewById(R.id.icon);
        cartIcon = findViewById(R.id.cartimg);
//        drawable=getResources().getDrawable(R.drawable.greencart);
//        cartIcon.setBackground(drawable);


        int[] imageList = {R.drawable.item1, R.drawable.item3, R.drawable.item5, R.drawable.item7, R.drawable.item9, R.drawable.item11, R.drawable.item13, R.drawable.item17, R.drawable.item19, R.drawable.item2, R.drawable.item4, R.drawable.item6, R.drawable.item8, R.drawable.item10, R.drawable.item12, R.drawable.item14};
        String[] brandName = {"SCOOBOO", "FIEJIT", "H&M", "LAXMIPATI", "NORTHLAND", "BENTGO", "MILTON", "SCOOBOO", "KACO", "SCOOBOO", "MILTON", "H&M", "SCOOBOO", "SCOOBOO", "MILTON", "SCOOBOO", "KACO"};
        String[] description = {"Backpack", "Bottle", "Over-sized T-shirt", "Designer women kurti", "Bottle", "Lunch box", "Lunch box", "Pen holder", "Premium stapler", "Backpack", "Bottle", "Set of mens shirt and shorts", "Pen holder", "Journal", "Lunch box", "Project notebook", "Premium pen"};
        String[] rate = {"695", "250", "2199", "895", "199", "299", "399", "1048", "1280", "1048", "1450", "2580", "1648", "350", "846", "254", "895"};

        ListHomeAdapter listHomeAdapter1 = new ListHomeAdapter(getApplicationContext(), dataArrayList);
        listView.setAdapter(listHomeAdapter1);
        for (int i = 0; i < imageList.length; i++) {
            listHomeData = new ListHomeData(brandName[i], description[i], rate[i], imageList[i]);
            dataArrayList.add(listHomeData);


            icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            });


//            cartIcon=findViewById(R.id.cartimg);
//            drawable=getResources().getDrawable(R.drawable.greencart);
//            cartIcon.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    cartIcon.setBackground(drawable);
//                }
//            });

        }
    }


}