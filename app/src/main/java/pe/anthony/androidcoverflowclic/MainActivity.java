package pe.anthony.androidcoverflowclic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import pe.anthony.androidcoverflowclic.Adapter.MovieAdapter;
import pe.anthony.androidcoverflowclic.Common.Common;
import pe.anthony.androidcoverflowclic.Model.Movie;

public class MainActivity extends AppCompatActivity {

    FeatureCoverFlow coverFlow;
    MovieAdapter movieAdapter;
    TextSwitcher mTitle;    //Este tipo de textSwitcher es para las animaciones en android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos la data
        initData();
        movieAdapter = new MovieAdapter(Common.movieList,this);
        mTitle =  findViewById(R.id.mtitle);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
                TextView text = (TextView) inflater.inflate(R.layout.layout_title,null);
                return text;
            }
        });
        coverFlow = findViewById(R.id.coverFlow);
        coverFlow.setAdapter(movieAdapter);
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(Common.movieList.get(position).getTitle());
            }

            @Override
            public void onScrolling() {

            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,MovieDetail.class);
                intent.putExtra("movie_extra",i);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        //Ejemplo no mas
        Movie movie =  new Movie("Captain America vs Iroman",
                "Political interference in the Avengers' activities causes a rift between former allies Captain America and Iron Man.",
                "http://www.disneytouristblog.com/wp-content/uploads/2016/05/captain_america_civil_war.jpg");
        Common.movieList.add(movie);

         movie =  new Movie("Batman vs Superman",
                "Batman v Superman: Dawn of Justice is a 2016 American superhero film featuring the DC Comics characters Batman and Superman. Directed by Zack Snyder and distributed by Warner Bros. Pictures, the film is the second installment in the DC Extended Universe (DCEU) following 2013's Man of Steel. It was written by Chris Terrio and David S. Goyer, and features an ensemble cast that includes Ben Affleck, Henry Cavill, Amy Adams, Jesse Eisenberg, Diane Lane, Laurence Fishburne, Jeremy Irons, Holly Hunter, and Gal Gadot. Batman v Superman: Dawn of Justice is the first live-action film to feature Batman and Superman together, as well as the first live-action cinematic portrayal of Wonder Woman, Aquaman, Flash, and Cyborg. In the film, criminal mastermind Lex Luthor manipulates Batman into a preemptive battle with Superman, whom Luthor is obsessed with defeating",
                 "http://allcalidad.com/wp-content/uploads/2016/07/batman-vs-superman-el-origen-de-la-justicia.jpg");
        Common.movieList.add(movie);
        movie =  new Movie("Wonder Woman",
                "Wonder Woman is a fictional superhero appearing in American comic books published by DC Comics.[2] The character is a founding member of the Justice League, goddess, and Ambassador-at-Large of the Amazonian people. The character first appeared in All Star Comics #8 in October 1941 and first cover-dated on Sensation Comics #1, January 1942. In her homeland, the island nation of Themyscira, her official title is Princess Diana of Themyscira, Daughter of Hippolyta. When blending into the society outside of her homeland, she adopts her civilian identity Diana Prince. The character is also referred to by such epithets as the \"Amazing Amazon\", the \"Spirit of Truth\", \"Themyscira's Champion\", the \"God-killer\", and the \"Goddess of Love and War\".",
                "http://thewisdomdaily.com/wp-content/uploads/2017/06/wonderwoman2.0.jpg");
        Common.movieList.add(movie);
        movie =  new Movie("Spiderman",
                "Spider-Man: Homecoming is a 2017 American superhero film based on the Marvel Comics character Spider-Man, co-produced by Columbia Pictures and Marvel Studios, and distributed by Sony Pictures Releasing. It is the second Spider-Man film reboot and the sixteenth film in the Marvel Cinematic Universe (MCU). ",
                "https://i0.wp.com/media2.slashfilm.com/slashfilm/wp/wp-content/images/spiderman-homecoming-poster-crop.jpg");
        Common.movieList.add(movie);
    }
}