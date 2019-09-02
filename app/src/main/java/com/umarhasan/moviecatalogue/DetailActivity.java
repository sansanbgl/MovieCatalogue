package com.umarhasan.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.umarhasan.moviecatalogue.model.Movie;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_MOVIE;
private ImageView imgPhoto;
    private TextView txtTitle;
    private TextView txtDesc;
    private TextView txtYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        imgPhoto = findViewById(R.id.img_photo);
        txtTitle = findViewById(R.id.txt_title);
        txtDesc = findViewById(R.id.txt_desc);
        txtYear = findViewById(R.id.txt_year);
        imgPhoto.setImageResource(movie.getImgIndex());
        txtTitle.setText(movie.getTitle());
        txtDesc.setText(movie.getDesc());
        txtYear.setText(movie.getYear());
    }
}
