package com.prgm.applicationstate.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prgm.applicationstate.R;


public class Fragment_One extends Fragment {

    public static Fragment_One newInstance(String param1, String param2) {
        Fragment_One fragment = new Fragment_One();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("**ON_CREATE==1 Fragment", "On CREATE");
    }


    @Override
    public void onStart() {
        super.onStart();

        Log.d("**ON_START==1 Fragment", "On START");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("**ON_RESUME==1 Fragment", "On RESUME");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__one, container, false);
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d("**ON_ATTACH==1 Fragment", "On ATTACH");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("**ON_DETACH==1", "On DETACH");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("**ON_ACTIVITY CREATED==1 Fragment", "On ACTIVITY CREATED");
    }



    @Override
    public void onStop() {
        super.onStop();
        Log.d("**ON_STOP==1 Fragment", "On STOP");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("**ON_PAUSE==1 Fragment", "On PAUSE");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("**ON_DESTROY==1 Fragment", "On DESTROY");
    }



}
