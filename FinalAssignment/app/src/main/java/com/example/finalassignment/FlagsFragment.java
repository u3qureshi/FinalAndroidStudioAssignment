package com.example.finalassignment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;

public class FlagsFragment extends Fragment {

    private ImageView canada;
    private ImageView china;
    private ImageView mexico;
    private ImageView saudi;
    private ImageView us;

    public FlagsFragment() {
        // Required empty public constructor
    }

    //called initially when the fragment is created, created first.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        canada = getActivity().findViewById(R.id.canadaIV);
        china = getActivity().findViewById(R.id.chinaIV);
        mexico = getActivity().findViewById(R.id.mexicoIV);
        saudi = getActivity().findViewById(R.id.saudiIV);
        us = getActivity().findViewById(R.id.usIV);
    }

    //This is create after the onCreate function is called
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flags, container, false);
    }


}