package com.satrio.myapplication.seting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.satrio.myapplication.R;
import com.satrio.myapplication.adapter.RecyclerAdapterFav;
import com.satrio.myapplication.adapter.RecyclerAdapterHistory;
import com.satrio.myapplication.home.Favorite;
import com.satrio.myapplication.model.ItemFav;
import com.satrio.myapplication.model.Request;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class History extends AppCompatActivity {
    List<Request> Produk ;
    DatabaseReference database;
    private RecyclerAdapterHistory mRAHis;
    private RecyclerView mRA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

//        recyclerView = findViewById(R.id.recyclerfav);
        database = FirebaseDatabase.getInstance().getReference();
//        recyclerView = findViewById(R.id.recyclerfav);
        mRA = findViewById(R.id.recyclerhistory);
        RecyclerAdapterHistory myAdapter = new RecyclerAdapterHistory(this, Produk);
        mRA.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false ));
        //myrv.setAdapter(myAdapter);
        readFromFireBase();
    }
    private void readFromFireBase(){
        database.child("Item").child("Request");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Produk = new ArrayList<>();
                for (DataSnapshot contentsSnapshot : dataSnapshot.child("Item").child("Request").getChildren()) {
                    Request content = contentsSnapshot.getValue(Request.class);
                    content.setKey(contentsSnapshot.getKey());
                    Produk.add(content);
                }

                mRAHis = new RecyclerAdapterHistory(History.this, Produk);
                mRA.setAdapter(mRAHis);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
