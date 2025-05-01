package com.remon.digicure;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {

    MainDashboard mainActivity;
    public HomeFragment() {

    }

    BottomNavigationView bottomNavigationView;
    ImageView Moon, Sun;
    LinearLayout Medilinear;
    Button appo_1, appo_2, appo_3;
    LinearLayout  Proflinear;
    LinearLayout videoConfLinear;

    TextView seeAll;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mainActivity = (MainDashboard) getActivity();

        Moon = view.findViewById(R.id.moonPic);
        Sun = view.findViewById(R.id.sunPic);

        Medilinear = view.findViewById(R.id.medicine_top_id);
        Proflinear = view.findViewById(R.id.profile_top_id);
        videoConfLinear = view.findViewById(R.id.video_top_id);
        seeAll = view.findViewById(R.id.see_all_Text);

        appo_1 = view.findViewById(R.id.appointmentTop_Button_1);
        appo_2 = view.findViewById(R.id.appointmentTop_Button_2);
        appo_3 = view.findViewById(R.id.appointmentTop_Button_3);

        //appointment Buttons Work

        appo_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VideoConference.class));
            }
        });

        appo_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VideoConference.class));
            }
        });

        appo_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), VideoConference.class));
            }
        });

    //Night Mood.....................................................................
        Moon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Moon.setVisibility(View.GONE);
                    Sun.setVisibility(View.VISIBLE);

            }
        });

       Sun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                Moon.setVisibility(View.VISIBLE);
                Sun.setVisibility(View.GONE);
            }
        });
     //............................................................................................


        //bottom Nav find

        Proflinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment profile = new ProfileFragment();
                FragmentTransaction dg = getActivity().getSupportFragmentManager().beginTransaction();
                dg.replace(R.id.Const_Main_Dash,profile).commit();
            }
        });

        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment doctors = new DoctorFragment();
                FragmentTransaction doc = getActivity().getSupportFragmentManager().beginTransaction();
                doc.replace(R.id.Const_Main_Dash,doctors).commit();

            }
        });

        Medilinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment medicine = new MedicineFragment();
                FragmentTransaction md = getActivity().getSupportFragmentManager().beginTransaction();
                md.replace(R.id.Const_Main_Dash,medicine).commit();
            }
        });

        videoConfLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),VideoConference.class));
            }
        });

        return view;
    }
}