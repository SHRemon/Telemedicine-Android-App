package com.remon.digicure;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MedicineFragment extends Fragment {

   public MedicineFragment(){

   }
   TextView textmarquee;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_medicine, container, false);

        textmarquee = view.findViewById(R.id.marqueez);
        textmarquee.setSelected(true);

        return view;
    }
}