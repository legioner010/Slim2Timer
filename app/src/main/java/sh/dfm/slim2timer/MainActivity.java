package sh.dfm.slim2timer;



import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListner {

    //private final static String FRAGMENT_ID = "f75916bd-b544-4f5e-b4ca-6ac9e6f2c5e9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        //находим фрагмент
//        WorkoutDetailFragment frag = (WorkoutDetailFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.detali_frag);
//
//        frag.setWorkout(0);

    }

    @Override
    public void itemClicked(long id) {
        View fragmentcontainter = findViewById(R.id.fragment_container);
        if(fragmentcontainter !=null){
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            details.setWorkout(id);
            ft.replace(R.id.fragment_container, details);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        }else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int) id);
            startActivity(intent);
        }



    }
}
