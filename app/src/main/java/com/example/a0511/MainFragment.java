package com.example.a0511;


import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment {
    private List<ScannedData> arrayList = new ArrayList<>();
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        Button button=view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
            @Override
            public void onClick(View v){
                MainFragmentDirections.ActionMainFragmentToSecondFragment action =
                        MainFragmentDirections.actionMainFragmentToSecondFragment();
                action.setMessage("\n強度:"+ScannedData.getRssi()+"\n資訊:"+ScannedData.getDeviceByteInfo()+
                                "\n名稱:"+ScannedData.getDeviceName());
                navController.navigate(action);
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.scanneditem, container, false);
    }
}
