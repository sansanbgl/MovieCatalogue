package com.umarhasan.moviecatalogue;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.umarhasan.moviecatalogue.adapter.MovieAdapter;
import com.umarhasan.moviecatalogue.model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataTitle;
    private String[] dataDesc;
    private String[] dataYear;
    private String[] dataScore;
    private TypedArray dataImg;
    private MovieAdapter movieAdapter;
    private ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movieAdapter = new MovieAdapter(this);

        prepare();
        addItem();

        ListView listView = findViewById(R.id.lv_movies);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movie = movieArrayList.get(i);
                Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailActivity.class);
                moveWithObjectIntent.putExtra(DetailActivity.EXTRA_MOVIE, movie);
                startActivity(moveWithObjectIntent);
            }
        });
        listView.setAdapter(movieAdapter);
    }

    private void addItem() {
        movieArrayList = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {

            Movie movie = new Movie();
            movie.setImgIndex(dataImg.getResourceId(i, -1));
            movie.setTitle(dataTitle[i]);
            movie.setDesc(dataDesc[i]);
            movie.setYear(dataYear[i]);
            movie.setYear(dataYear[i]);
            movie.setScore(dataScore[i]);
            movieArrayList.add(movie);
        }
        movieAdapter.setMovies(movieArrayList);
    }

    private void prepare() {
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataDesc = getResources().getStringArray(R.array.data_desc);
        dataYear = getResources().getStringArray(R.array.data_year);
        dataImg = getResources().obtainTypedArray(R.array.data_img);
        dataScore = getResources().getStringArray(R.array.data_score);
    }
}
