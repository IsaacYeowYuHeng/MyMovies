package sg.edu.rp.c346.id22021538.mymovies;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Movie> {

    private Context parent_context;
    private int layout_id;
    private ArrayList<Movie> movieList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);

        this.parent_context = context;
        this.layout_id = resource;
        this.movieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent_context);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView title = rowView.findViewById(R.id.textViewTitle);
        TextView year = rowView.findViewById(R.id.textViewYear);
        ImageView rating = rowView.findViewById(R.id.imageView);
        TextView genre = rowView.findViewById(R.id.textViewName);

        Movie movie = movieList.get(position);

        title.setText(movie.getTitle());
        year.setText(String.valueOf(movie.getYear()));

        switch (movie.getRating()) {
            case "G":
                rating.setImageResource(R.drawable.rating_g);
                break;
            case "PG":
                rating.setImageResource(R.drawable.rating_pg);
                break;
            case "PG13":
                rating.setImageResource(R.drawable.rating_pg13);
                break;
            case "M18":
                rating.setImageResource(R.drawable.rating_m18);
                break;
            case "R21":
                rating.setImageResource(R.drawable.rating_r21);
                break;
            case "NC16":
                rating.setImageResource(R.drawable.rating_nc16);
                break;
        }

        genre.setText(movie.getGenre());

        return rowView;
    }
}