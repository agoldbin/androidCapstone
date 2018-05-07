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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SetFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SetFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_REP = "rep";
    private static final String ARG_WEIGHT = "weight";
    private static final String ARG_REP_LIST = "repList";
    private static final String ARG_WEIGHT_LIST = "weightList";
    private static final String ARG_ITERATE = "iterate";

    // TODO: Rename and change types of parameters
    private ArrayList<Integer> mRepList;
    private ArrayList<Integer> mWeightList;
    private int mRep;
    private int mWeight;
    private int i;

    private OnFragmentInteractionListener mListener;

    public SetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mRepList List of reps
     * @param mWeightList List of weights
     * @return A new instance of fragment SetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SetFragment newInstance(ArrayList<Integer> mRepList
            , ArrayList<Integer> mWeightList, int i) {
        SetFragment fragment = new SetFragment();
        Bundle args = new Bundle();
        args.putIntegerArrayList(ARG_REP_LIST, mRepList);
        args.putIntegerArrayList(ARG_WEIGHT_LIST, mWeightList);
        args.putInt(ARG_ITERATE, i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mRepList = getArguments().getIntegerArrayList(ARG_REP_LIST);
            mWeightList = getArguments().getIntegerArrayList(ARG_WEIGHT_LIST);
            i = getArguments().getInt(ARG_ITERATE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_set, container, false);
        // wire up widgets
        Button mAdd = (Button) view.findViewById(R.id.btnAddSet);
        Button mCancel = (Button) view.findViewById(R.id.btnCancelSet);
        TextView mLblRep = (TextView) view.findViewById(R.id.lblExerciseSets);
        TextView mLblWeight = (TextView) view.findViewById(R.id.lblExerciseWeights);
        EditText mRep = (EditText) view.findViewById(R.id.inputExerciseReps);
        EditText mWeight = (EditText) view.findViewById(R.id.inputExerciseWeight);

        if (savedInstanceState != null) {
            // pull any info from the bundle
            i = savedInstanceState.getInt(ARG_ITERATE);
            mRepList = savedInstanceState.getIntegerArrayList(ARG_REP_LIST);
            mWeightList = savedInstanceState.getIntegerArrayList(ARG_WEIGHT);
            mRep.setText(mRepList.get(i));
            mWeight.setText(mWeightList.get(i));
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
