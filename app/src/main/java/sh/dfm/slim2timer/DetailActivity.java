package sh.dfm.slim2timer;

/**
 * Created by dbeletskiy on 05.12.2016.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ะต on 03.12.2016.
 */
public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_WORKOUT_ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);
        WorkoutDetailFragment workoutDetailFragment =(WorkoutDetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.detail_frag);

        int workoutId= (int) getIntent().getIntExtra(EXTRA_WORKOUT_ID, 0);
        workoutDetailFragment.setWorkout(workoutId);
    }
}
