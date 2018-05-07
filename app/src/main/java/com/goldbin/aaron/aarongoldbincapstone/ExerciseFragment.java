package com.goldbin.aaron.aarongoldbincapstone;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.goldbin.aaron.aarongoldbincapstone.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExerciseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "exerciseName";
    private static final String ARG_PARAM2 = "sets";

    // TODO: Rename and change types of parameters
    private String mExerciseName;
    private String mSets;


    private OnFragmentInteractionListener mListener;

    public ExerciseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param exerciseName the exercise name
     * @param sets         the sets
     * @return A new instance of fragment ExerciseFragment.
     */
// TODO: Rename and change types and number of parameters
    public static ExerciseFragment newInstance(String exerciseName, String sets) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, exerciseName);
        args.putString(ARG_PARAM2, sets);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mExerciseName = getArguments().getString(ARG_PARAM1);
            mSets = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        // wire up widgets
        TextView mLblExerciseName = (TextView) view.findViewById(R.id.lblExerciseName);
        TextView mLblSets = (TextView) view.findViewById(R.id.lblExerciseSets);
        EditText mExerciseName = (EditText) view.findViewById(R.id.inputExerciseName);
        EditText mExerciseSets = (EditText) view.findViewById(R.id.inputExerciseSets);
        Button mAdd = (Button) view.findViewById(R.id.btnAddExercise);
        Button mCancel = (Button) view.findViewById(R.id.btnCancelExercise);
        Switch mRepsSame = (Switch) view.findViewById(R.id.switchReps);
        Switch mWeightsSame = (Switch) view.findViewById(R.id.switchWeight);

        if (savedInstanceState != null) {
            // pull any info from the bundle
        }

//        mTextView = (TextView) view.findViewById(R.id.txtDisplay);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
