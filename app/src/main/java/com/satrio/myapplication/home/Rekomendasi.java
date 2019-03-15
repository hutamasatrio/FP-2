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
import com.satrio.myapplication.adapter.RecyclerAdapterPromo;
import com.satrio.myapplication.adapter.RecyclerAdapterRecom;
import com.satrio.myapplication.model.Item;
import com.satrio.myapplication.R;
import com.satrio.myapplication.adapter.RecyclerViewAdapterItem;
import com.satrio.myapplication.model.ItemPromo;
import com.satrio.myapplication.model.ItemRecom;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class Rekomendasi extends AppCompatActivity {

    List<ItemRecom> Produk ;
    DatabaseReference database;
    private RecyclerAdapterRecom mRArecom;
    private RecyclerView mRA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rekomendasi);

        database = FirebaseDatabase.getInstance().getReference();
        mRA = findViewById(R.id.recyclerrekom);
        RecyclerAdapterRecom myAdapter = new RecyclerAdapterRecom(this, Produk);
        mRA.setLayoutManager(new GridLayoutManager(this, 2));
        readFromFireBase();
    }
    private void readFromFireBase(){
        database.child("Item").child("produkRecom");
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Produk = new ArrayList<>();
                for (DataSnapshot contentsSnapshot : dataSnapshot.child("Item").child("produkRecom").getChildren()) {
                    ItemRecom content = contentsSnapshot.getValue(ItemRecom.class);
                    content.setKey(contentsSnapshot.getKey());
                    Produk.add(content);
                }

                mRArecom = new RecyclerAdapterRecom(Rekomendasi.this, Produk);
                mRA.setAdapter(mRArecom);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}
