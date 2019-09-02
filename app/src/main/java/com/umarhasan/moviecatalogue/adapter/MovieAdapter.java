package com.umarhasan.moviecatalogue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.umarhasan.moviecatalogue.R;
import com.umarhasan.moviecatalogue.model.Movie;
import com.wssholmes.stark.circular_score.CircularScoreView;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context){
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private TextView txtTitle;
        private TextView txtScore;
        private TextView txtYear;
        private TextView txtDesc;
        private ImageView imgPhoto;
        private int intScore;
        private CircularScoreView pbScore;
        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.txt_title);
            txtDesc = view.findViewById(R.id.txt_desc);
            txtScore = view.findViewById(R.id.txt_score);
            txtYear = view.findViewById(R.id.txt_year);
            imgPhoto = view.findViewById(R.id.img_photo);
            pbScore = view.findViewById(R.id.ccv_score);
        }
        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtDesc.setText(movie.getDesc());
            txtScore.setText(movie.getScore());
            txtYear.setText(movie.getYear());
            imgPhoto.setImageResource(movie.getImgIndex());
            intScore = Integer.parseInt(movie.getScore());
            pbScore.setScore(intScore);
        }
    }
}
