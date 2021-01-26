package com.example.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class movieAdapter extends BaseAdapter {
    Context context;
    List<movieModel> movieModels;

    public movieAdapter(Context context, List<movieModel> movieModels) {
        this.context = context;
        this.movieModels = movieModels;
    }

    @Override
    public int getCount() {
        return movieModels.size();
    }

    @Override
    public Object getItem(int position) {
        return movieModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row= LayoutInflater.from(context).inflate(R.layout.movielayout,null,false);

        TextView txtMovieName=row.findViewById(R.id.moviename);
        TextView txtMovieDate=row.findViewById(R.id.moviedate);
        ImageView movieImage=row.findViewById(R.id.movieImage);

        final String imgURL  = "https://www.google.com/images/srpr/logo11w.png";
        txtMovieName.setText(movieModels.get(position).getMovieName());
        txtMovieDate.setText(movieModels.get(position).getMovieDate());
        Glide.with(context).asBitmap().load(movieModels.get(position).movieThumb).into(movieImage);




        return row;
    }
}
