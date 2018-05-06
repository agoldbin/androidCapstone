package com.goldbin.aaron.aarongoldbincapstone.persistence.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.goldbin.aaron.aarongoldbincapstone.R;
import com.goldbin.aaron.aarongoldbincapstone.persistence.db.entity.Exercise;

import java.util.ArrayList;

/**
 * Array adapter to format listview for exercises
 *
 * @author agoldbin
 */
public class ExerciseArrayAdapter extends ArrayAdapter<Exercise> {
    // Declare arrayList of items (exercise)
    private ArrayList<Exercise> exercises;

    public ExerciseArrayAdapter(@NonNull Context context, int resource, ArrayList<Exercise> exercises) {
        super(context, resource, exercises);
        this.exercises = exercises;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        // Check to see if view is null.  If so, we have to inflate the view
        // "inflate" means to render or show the view
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.exercise_detail, null);
        }

         /*
             Recall that the variable position is sent in as an argument to this method

             The variable simply refers to the position of the current object on the list.
             The ArrayAdapter iterate through the list we sent it

             versionObject refers to the current PlatformVersion object
          */
        Exercise exercise = exercises.get(position);

        // TODO modify to fit vars from Exercise class
        // TODO if not all rep, sets, weights same, display each on its own line
        if (exercise != null) {
            //obtain a reference to widgets in the defined layout "wire up the widgets from detail_line"
            // note:  view.  which ties it to detail_line
            /*
            TextView mEx1  = (TextView) view.findViewById(R.id.contactName);
            TextView mEmail = (TextView) view.findViewById(R.id.contactEmail);
            TextView mPhone = (TextView) view.findViewById(R.id.contactPhone);

            if (mEx1 != null) {
                String name =  exercise.getContactLast() + ", " + exercise.getContactFirst();
                mEx1.setText(name);
            }
            if (mEmail != null) {
                mEmail.setText(exercise.getContactEmail());
            }
            if (mPhone != null) {
                mPhone.setText(exercise.getContactPhone());
            }
        */
        }

        // the view (my custom detail_line with loaded data) returned to our Activity
        return view;
    }
}
