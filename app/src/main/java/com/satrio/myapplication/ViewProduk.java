package com.satrio.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.satrio.myapplication.model.Item;

import java.util.List;

import static java.lang.String.valueOf;

public class ViewProduk extends AppCompatActivity {
    private TextView tvtitle,tvdescription,tvcategory, pricetextview, tvharga;
    private ImageView img;
    int quantity=0;
    int harga;
    int total ;
    String  judul,nama,desc, price,imgbarang;


    private Context mContext ;
    private List<Item> Produk ;
    Item dataContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_produk);
        tvtitle = (TextView) findViewById(R.id.merk);
        tvdescription = (TextView) findViewById(R.id.description);
        tvcategory = (TextView) findViewById(R.id.category);
        img = (ImageView) findViewById(R.id.gambarL);
        tvharga = (TextView) findViewById(R.id.hargabarang);

        // Recieve data
        Intent intent = getIntent();
        final Long Harga = intent.getExtras().getLong("Harga");
        final String Title = intent.getExtras().getString("Title");
        final String Description = intent.getExtras().getString("Description");
        final String image = intent.getExtras().getString("img_url") ;

        // Setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        setDisplayImage(image, this);
        tvharga.setText(String.valueOf(Harga));


        Button button = (Button) findViewById(R.id.bt_alert);

        // Show toast message when button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = String.valueOf(Title);
                imgbarang = image;
                price= String.valueOf(Harga);
                desc = String.valueOf(Description);


               //BitmapDrawable bitmapDrawable = ((BitmapDrawable) img.getDrawable());
               //imgbarang = (BitmapDrawable)img.getDrawable()).getBitmap();
               Intent i = null;
               i = new Intent(ViewProduk.this, Product_Beli.class);

               Bundle b = new Bundle();
               b.putString("parse_nama",nama );
               b.putString("parse_desc",desc );
               b.putString("parse_price",price );
               b.putString("gambar",imgbarang);

               i.putExtras(b);
               startActivity(i);

//                Intent intent = new Intent(ViewProduk.this ,Product_Beli.class);
//                // passing data to the book activity
//                intent.putExtra("Title",Produk.get(position).getTitle());
//                intent.putExtra("Description",Produk.get(position).getDescription());
//                intent.putExtra("img_url",Produk.get(position).getImg_url());
//                intent.putExtra("Harga",Produk.get(position).getHarga());
//                // start the activity
//                Toast.makeText(getApplicationContext(), "anda akan memesan barang ini", Toast.LENGTH_LONG).show();/
//                mContext.startActivity(intent);




               // Set your own toast  message

                //startActivity(intent);
            }
        })
        ;
    }


    private void setDisplayImage(String imageUrl, Context context) {

        ImageView image = findViewById(R.id.gambarL);

        Glide.with(context)
                .load(imageUrl)
                .into(image);
    }

    public void beli(View view) {
    }


}
