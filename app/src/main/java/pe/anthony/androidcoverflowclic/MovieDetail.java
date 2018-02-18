package pe.anthony.androidcoverflowclic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import pe.anthony.androidcoverflowclic.Common.Common;
import pe.anthony.androidcoverflowclic.Model.Movie;

public class MovieDetail extends AppCompatActivity {

    KenBurnsView movie_image;
    TextView movie_title,movie_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        movie_image = findViewById(R.id.movie_image);
        movie_title = findViewById(R.id.movie_title);
        movie_summary = findViewById(R.id.movie_summary);

        if(getIntent()!= null){
            int movie_index = getIntent().getIntExtra("movie_extra",10);
            if(movie_index != 10){
                loadMovieDetail(movie_index);
            }
        }
    }

    private void loadMovieDetail(int movie_index) {
        Movie movie = Common.movieList.get(movie_index);

        //carga la imagen
        Picasso.with(getBaseContext()).load(movie.getUrl()).into(movie_image);//getBaseContext es de este contexto
        movie_title.setText(movie.getTitle());
        movie_summary.setText(movie.getSumary());
    }
}
