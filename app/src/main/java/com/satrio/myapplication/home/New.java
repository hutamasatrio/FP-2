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
import com.satrio.myapplication.model.Item;
import com.satrio.myapplication.R;
import com.satrio.myapplication.adapter.RecyclerAdapterNew;
import com.satrio.myapplication.model.ItemNew;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class New extends AppCompatActivity {
    List<ItemNew> Produk ;
    DatabaseReference database;
    private RecyclerAdapterNew mRAnew;
    private RecyclerView mRA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


        database = FirebaseDatabase.getInstance().getReference();
        mRA = findViewById(R.id.recyclernew);
        RecyclerAdapterNew myAdapter = new RecyclerAdapterNew(this, Produk);
        mRA.setLayoutManager(new GridLayoutManager(this, 2));
        readFromFireBase();
    }
    private void readFromFireBase(){
        database.child("Item").child("produkNew");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Produk = new ArrayList<>();
                for (DataSnapshot contentsSnapshot : dataSnapshot.child("Item").child("produkNew").getChildren()) {
                    ItemNew content = contentsSnapshot.getValue(ItemNew.class);
                    content.setKey(contentsSnapshot.getKey());
                    Produk.add(content);
                }

                mRAnew = new RecyclerAdapterNew(New.this, Produk);
                mRA.setAdapter(mRAnew);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
