package sg.edu.rp.c346.id22021538.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import sg.edu.rp.c346.id22043300.mymovies.DBHelper;
import sg.edu.rp.c346.id22043300.mymovies.R;
import sg.edu.rp.c346.id22043300.mymovies.ShowMovies;

public class MainActivity extends AppCompatActivity {

    private Button btn_ins, btn_sl;
    private EditText etMovieTitle, etGenre, etYear;
    private Spinner spinner;
    private String rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                rating = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        btn_ins.setOnClickListener(v -> insertMovie());

        btn_sl.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ShowMovies.class)));
    }

    private void initializeViews() {
        setContentView(R.layout.activity_main);
        btn_ins = findViewById(R.id.btn_ins);
        etMovieTitle = findViewById(R.id.et_mt);
        etGenre = findViewById(R.id.et_genre);
        etYear = findViewById(R.id.et_y);
        btn_sl = findViewById(R.id.btn_sl);
        spinner = findViewById(R.id.spinner);
    }

    private void insertMovie() {
        String title = etMovieTitle.getText().toString();
        String genre = etGenre.getText().toString();
        int finalYear = Integer.parseInt(etYear.getText().toString());

        DBHelper db = new DBHelper(MainActivity.this);
        db.insertTask(title, genre, finalYear, rating);

        Toast.makeText(this, "Movie insert successful", Toast.LENGTH_SHORT).show();
    }
}