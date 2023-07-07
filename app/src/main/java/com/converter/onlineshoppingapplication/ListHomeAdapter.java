package com.converter.onlineshoppingapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListHomeAdapter extends ArrayAdapter<ListHomeData> {
    public ListHomeAdapter(@NonNull Context context, ArrayList<ListHomeData> dataArrayList) {
        super(context, R.layout.homelist, dataArrayList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        ListHomeData listHomeData = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.homelist, parent, false);
        }
        ImageView listImage = view.findViewById(R.id.listimg);
        TextView listBrand = view.findViewById(R.id.brand);
        TextView listDesc = view.findViewById(R.id.desc);
        TextView listRate = view.findViewById(R.id.rate);


        listImage.setImageResource(listHomeData.img);
        listBrand.setText(listHomeData.brand + "'s");
        listDesc.setText(listHomeData.desc);
        listRate.setText("Rs." + listHomeData.rate);
        return view;
    }
}
