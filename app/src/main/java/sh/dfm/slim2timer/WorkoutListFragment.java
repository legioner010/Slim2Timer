package sh.dfm.slim2timer;

/**
 * Created by dbeletskiy on 05.12.2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WorkoutListFragment  extends ListFragment{

    private WorkoutListListner listner;

    public static interface WorkoutListListner {
        void itemClicked(long id);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listner =(WorkoutListListner) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String[] names = new String[Workout.workouts.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = Workout.workouts[i].getName();
        }
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(inflater.getContext(),
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //super.onListItemClick(l, v, position, id);
        listner.itemClicked(id);
    }
}
