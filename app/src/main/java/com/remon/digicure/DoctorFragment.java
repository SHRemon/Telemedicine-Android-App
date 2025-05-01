package com.remon.digicure;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class DoctorFragment extends Fragment {

    MainDashboard mainActivity;

    public DoctorFragment() {

    }

    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_doctor, container, false);

        mainActivity = (MainDashboard) getActivity();

        recyclerView = view.findViewById(R.id.recyclerView);
        searchView = view.findViewById(R.id.search);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();
        androidData = new DataClass("Dr. Sarwar Ahmed", R.string.appoint,  R.drawable.recycler_doc_1);
        dataList.add(androidData);
        androidData = new DataClass("Dr. Munira Akter", R.string.appoint,  R.drawable.recycler_doc_2);
        dataList.add(androidData);
        androidData = new DataClass("Dr. Apu Das Orgho", R.string.appoint,  R.drawable.recycler_doc_3);
        dataList.add(androidData);
        androidData = new DataClass("Dr. Mahiba Nafia", R.string.appoint,  R.drawable.recycler_doc_4);
        dataList.add(androidData);
        androidData = new DataClass("Dr. Shahariar Remon", R.string.appoint,  R.drawable.recycler_doc_5);
        dataList.add(androidData);
        adapter = new MyAdapter(getActivity(), dataList);
        recyclerView.setAdapter(adapter);

        return view;
    }
    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(mainActivity, "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }

    }
}