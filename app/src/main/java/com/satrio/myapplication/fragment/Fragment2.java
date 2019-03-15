package com.satrio.myapplication.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.satrio.myapplication.model.Item;
import com.satrio.myapplication.R;
import com.satrio.myapplication.adapter.RecyclerViewAdapterItem;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Fragment2 extends Fragment {
    RecyclerView recyclerViewHome;
    RecyclerView myrv;
    DatabaseReference database;
    List<Item> Produk ;
    ArrayList<Item> item;

    public static Fragment2 newInstance() {
        Fragment2 fragment = new Fragment2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment2, container, false);
        item = new ArrayList<>();
//        Produk = new ArrayList<>();
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));
//        Produk.add(new Item("The Vegitarian", "Categorie Book", "Description book", R.drawable.baju, 10000));

        database = FirebaseDatabase.getInstance().getReference();

//        recyclerView = findViewById(R.id.recyclerfav);
        myrv = (RecyclerView) view.findViewById(R.id.recyclerall);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        readFromFireBase();
    return view;
    }

    private void readFromFireBase(){
        database.child("Item").child("produk");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Produk = new ArrayList<>();
                for (DataSnapshot contentsSnapshot : dataSnapshot.child("Item").child("produk").getChildren()) {
                    Item content = contentsSnapshot.getValue(Item.class);
                    content.setKey(contentsSnapshot.getKey());
                    Produk.add(content);
                }
                RecyclerViewAdapterItem myAdapter = new RecyclerViewAdapterItem(getActivity(), Produk);
                myrv.setAdapter(myAdapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}

