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

public class ListAdapter extends ArrayAdapter<ListData> {

    public ListAdapter(@NonNull Context context, ArrayList<ListData> dataArrayList) {
        super(context, R.layout.acc_list, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListData listData = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.acc_list, parent, false);

        }
        ImageView img = view.findViewById(R.id.img);
        TextView name = view.findViewById(R.id.data);
        TextView name_data = view.findViewById(R.id.data_item);

        img.setImageResource(listData.imgid);
        name.setText(listData.data);
        name_data.setText(listData.data_ans);
        return view;
    }
}
