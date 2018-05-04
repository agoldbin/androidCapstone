package com.goldbin.aaron.aarongoldbincapstone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Array adapter to format listview for exercises
 *
 * @author agoldbin
 */
public class WorkoutArrayAdapter extends ArrayAdapter<Workout> {
    // Declare arrayList of items (workouts)
    private ArrayList<Workout> workouts;

    public WorkoutArrayAdapter(@NonNull Context context, int resource, ArrayList<Workout> workouts) {
        super(context, resource, workouts);
        this.workouts = workouts;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        // Check to see if view is null.  If so, we have to inflate the view
        // "inflate" means to render or show the view
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.workout_detail, null);
        }

         /*
             Recall that the variable position is sent in as an argument to this method

             The variable simply refers to the position of the current object on the list.
             The ArrayAdapter iterate through the list we sent it

             versionObject refers to the current PlatformVersion object
          */
        Workout workout = workouts.get(position);

        // TODO modify to fit vars from Workout class
        if (workout != null) {
            /*
            //obtain a reference to widgets in the defined layout "wire up the widgets from detail_line"
            // note:  view.  which ties it to detail_line
            TextView mEx1  = (TextView) view.findViewById(R.id.contactName);
            TextView mEmail = (TextView) view.findViewById(R.id.contactEmail);
            TextView mPhone = (TextView) view.findViewById(R.id.contactPhone);

            if (mEx1 != null) {
                String name =  workout.getContactLast() + ", " + workout.getContactFirst();
                mEx1.setText(name);
            }
            if (mEmail != null) {
                mEmail.setText(workout.getContactEmail());
            }
            if (mPhone != null) {
                mPhone.setText(workout.getContactPhone());
            }
            */
        }

        // the view (my custom detail_line with loaded data) returned to our Activity
        return view;
    }
}
