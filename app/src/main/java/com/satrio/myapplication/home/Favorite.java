package com.satrio.myapplication.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.satrio.myapplication.adapter.RecyclerAdapterFav;
import com.satrio.myapplication.adapter.RecyclerAdapterNew;
import com.satrio.myapplication.model.Item;
import com.satrio.myapplication.R;
import com.satrio.myapplication.adapter.RecyclerViewAdapterItem;
import com.satrio.myapplication.model.ItemFav;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Favorite extends AppCompatActivity {
    List<ItemFav> Produk ;
    DatabaseReference database;
    private RecyclerAdapterFav mRAFav;
    private RecyclerView mRA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

//        recyclerView = findViewById(R.id.recyclerfav);
        database = FirebaseDatabase.getInstance().getReference();
//        recyclerView = findViewById(R.id.recyclerfav);
        mRA = findViewById(R.id.recyclerfav);
        RecyclerAdapterFav myAdapter = new RecyclerAdapterFav(this, Produk);
        mRA.setLayoutManager(new GridLayoutManager(this, 2));
        //myrv.setAdapter(myAdapter);
        readFromFireBase();
    }
    private void readFromFireBase(){
        database.child("Item").child("produkFav");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Produk = new ArrayList<>();
                for (DataSnapshot contentsSnapshot : dataSnapshot.child("Item").child("produkFav").getChildren()) {
                    ItemFav content = contentsSnapshot.getValue(ItemFav.class);
                    content.setKey(contentsSnapshot.getKey());
                    Produk.add(content);
                }

                mRAFav = new RecyclerAdapterFav(Favorite.this, Produk);
                mRA.setAdapter(mRAFav);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
    }
