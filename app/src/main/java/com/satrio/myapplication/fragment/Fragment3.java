package com.satrio.myapplication.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.satrio.myapplication.R;
import com.satrio.myapplication.TambahDistributor;
import com.satrio.myapplication.adapter.RecyclerAdapterDistributor;
import com.satrio.myapplication.room.Distributor;

import java.util.ArrayList;
import java.util.List;

import static com.satrio.myapplication.AppAplication.db;

public class Fragment3 extends Fragment {
    List<Distributor> lstRiwayat = new ArrayList<>();
    RecyclerAdapterDistributor mrecyclerviewDistributor;
    RecyclerView mRecyclerView;
private FloatingActionButton floatingActionButton;
    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_fragment3, container, false);

        mRecyclerView = v.findViewById(R.id.RecyclerDistributor);
        floatingActionButton = v.findViewById(R.id.tambah);
        fetchDataFromRoom();
        initReceyclerView();
        setAdapter();
        floatingActionBtn();
        return v;

    }

    private void floatingActionBtn() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TambahDistributor.class);
                getActivity().startActivity(intent);
            }
        });
    }

    private void fetchDataFromRoom(){
        lstRiwayat = db.userDao().getAll();
    }
    private void initReceyclerView(){
        mrecyclerviewDistributor = new RecyclerAdapterDistributor(lstRiwayat, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
    }
    private void setAdapter(){
        mRecyclerView.setAdapter(mrecyclerviewDistributor);
    }
@Override
    public void onResume(){
        super.onResume();
    initReceyclerView();
    setAdapter();
    fetchDataFromRoom();
}

}