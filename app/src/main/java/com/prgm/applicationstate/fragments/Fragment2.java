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


public class Fragment2 extends Fragment {

    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("**ON_CREATE VIEW==2 Fragment", "On CREATE VIEW");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("**ON_CREATE==2 Fragment", "On CREATE");
    }


    @Override
    public void onStart() {
        super.onStart();

        Log.d("**ON_START==2 Fragment", "On START");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("**ON_RESUME==2 Fragment", "On RESUME");
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d("**ON_ATTACH==2 Fragment", "On ATTACH");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("**ON_DETACH==2", "On DETACH");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("**ON_ACTIVITY CREATED==2 Fragment", "On ACTIVITY CREATED");
    }



    @Override
    public void onStop() {
        super.onStop();
        Log.d("**ON_STOP==2 Fragment", "On STOP");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("**ON_PAUSE==2 Fragment", "On PAUSE");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("**ON_DESTROY==2 Fragment", "On DESTROY");
    }



}
