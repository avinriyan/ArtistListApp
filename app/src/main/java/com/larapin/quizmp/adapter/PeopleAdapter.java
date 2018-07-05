package com.larapin.quizmp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.larapin.quizmp.R;
import com.larapin.quizmp.model.People;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Avin on 06/06/2018.
 *
 */

public class PeopleAdapter extends ArrayAdapter<People> {
    public PeopleAdapter(@NonNull Context context,
                            int resource,
                            @NonNull List<People> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.people_items, parent, false
            );
        }


        People people = getItem(position);

        TextView tvNama = (TextView) convertView.findViewById(R.id.tv_name);
        tvNama.setText("Name: "+people.getName());

        TextView tvNim = (TextView)convertView.findViewById(R.id.tv_img);
        tvNim.setText("Id: "+people.getId());

        TextView tvPop = (TextView)convertView.findViewById(R.id.tv_pop);
        tvPop.setText("Popularity: "+people.getPopularity());

        ImageView imageView = (ImageView)convertView.findViewById(R.id.img_people);
        Picasso.get()
                .load("https://image.tmdb.org/t/p/original"+people.getPoto())
                .resize(200, 200)
                .centerCrop()
                .into(imageView);


        return convertView;
    }
}
