package com.example.a0511;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class SecondFragment extends Fragment {


    private static final String TAG="SecondFragment";
    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        if(getArguments() !=null){
           // SecondFragmentArgs args=SecondFragmentArgs.fromBundle(getArguments());
            //String message =args.getMessage();
            //Log.i(TAG,"onViewCreated:"+message);
            TextView argText = getView().findViewById(R.id.textView33);

            SecondFragmentArgs args = SecondFragmentArgs.fromBundle(getArguments());
            String message = args.getMessage();
            argText.setText(message);
        }

    }
}
