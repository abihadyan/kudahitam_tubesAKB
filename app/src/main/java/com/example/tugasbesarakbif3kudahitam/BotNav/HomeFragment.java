package com.example.tugasbesarakbif3kudahitam.BotNav;
//NIM     : 10119119
//NAMA    : MUHAMMAD HADYAN NUR ADABI
//KELAS   : IF-3
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tugasbesarakbif3kudahitam.Adapter.RecyclerViewConfig;
import com.example.tugasbesarakbif3kudahitam.Model.Tempat;
import com.example.tugasbesarakbif3kudahitam.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;




public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    RecyclerViewConfig adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_places);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<Tempat> options =
                new FirebaseRecyclerOptions.Builder<Tempat>()
                        .setQuery(
                                FirebaseDatabase.getInstance().getReference().child("location"),
                                Tempat.class
                        )
                        .build();
        adapter = new RecyclerViewConfig(options);
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}