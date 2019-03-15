package com.satrio.myapplication;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.satrio.myapplication.model.Request;


public class Product_Beli extends AppCompatActivity {
    private Button beli;
    private Spinner spinner;
    private ImageView gamabrz;
    private TextView pricetextview,judulz, deskz, jumlah, totalharga;
    int quantity = 0;
    DatabaseReference database;
    private ProgressDialog loading;
    private EditText alamat;

    int total ;
    String totalHarga, namabarang, desc, price,gambar, gambarstring,alamat1;
    private String[] ATM = {
            "BRI",
            "BCA",
            "BNI",
            "Bank Mandiri"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaksi);




        //totalHarga = (TextView) findViewById(R.id.total);
        alamat = (EditText) findViewById(R.id.alamatakhir);
        jumlah = (TextView) findViewById(R.id.quantity);
        beli = (Button) findViewById(R.id.beli);
        judulz = (TextView) findViewById(R.id.titleakhir);
        deskz = (TextView) findViewById(R.id.deskakhir);
        pricetextview = (TextView) findViewById(R.id.hargaakhir);
        gamabrz = (ImageView) findViewById(R.id.gambarakhir);

        Bundle b = getIntent().getExtras();
        namabarang = b.getString("parse_nama");
        desc = b.getString("parse_desc");
        price = b.getString("parse_price");
        gambar = b.getString("gambar");


        judulz.setText(namabarang);
        deskz.setText(desc);
        pricetextview.setText("Rp. "+price);
        setDisplayImage(gambar, this);
        spinner = (Spinner) findViewById(R.id.spinner);


        database = FirebaseDatabase.getInstance().getReference();

        tombolbeli ();


        // inisialiasi Array Adapter dengan memasukkan string array di atas
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, ATM);

        // mengeset Array Adapter tersebut ke Spinner
        spinner.setAdapter(adapter);

        // mengeset listener untuk mengetahui saat item dipilih
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // memunculkan toast + value Spinner yang dipilih (diambil dari adapter)
                String pilihan=spinner.getSelectedItem().toString();
                Toast.makeText(Product_Beli.this, "Selected "+ adapter.getItem(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        }

        );



    }
    private void setDisplayImage(String imageUrl, Context context) {

        ImageView image = findViewById(R.id.gambarakhir);

        Glide.with(context)
                .load(imageUrl)
                .into(image)
        ;
    }







    //tambah-tambahan///////////////////////////////////////////////////////////////////

    public void increment(View view){//perintah tombol tambah
            if(quantity==100){
                Toast.makeText(this,"pesanan maximal 100",Toast.LENGTH_SHORT).show();
                return;
            }
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {//perintah tombol tambah
        if (quantity == 1) {
            Toast.makeText(this, "pesanan minimal 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }


    public void konvert() {
        Bundle b = getIntent().getExtras();
        pricetextview = (TextView) findViewById(R.id.total);
        price = b.getString("parse_price");
        int mprice = Integer.parseInt(price);
        total = mprice * quantity;

    }

    @SuppressLint("SetTextI18n")
    public void Submitorder(View view) {
        konvert();
        totalHarga = Integer.toString(total);
        pricetextview.setText("Rp. " + total);
    }


    //method ini untuk mencetak hasil perintah yang di tampilkan dengan inisial quantity_textview di textview 0
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
        quantityTextView.setText("" + number);

    }
    public void tombolbeli (){
        beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (

                        total != 0
//                        !judulz.getText().toString().isEmpty()&&!deskz.getText().toString().isEmpty()&&
//                        !pricetextview.getText().toString().isEmpty()&&!spinner.getSelectedItem().toString().isEmpty()
//                        && !gambar.toString().isEmpty()
                        ){

//                    historyDB = new HistoryDB();
//                    historyDB.setNamabarang(judulz.getText().toString());
//                    historyDB.setGambar(gambar.toString());
//                    historyDB.setDeskripsi(deskz.getText().toString());
//                    historyDB.setHarga(pricetextview.getText().toString());
//                    historyDB.setATM(spinner.getSelectedItem().toString());


                    loading = ProgressDialog.show(Product_Beli.this,
                            null, "please wait",true,false);

                    submituser (new Request (
                        judulz.getText().toString().toLowerCase(),
                        pricetextview.getText().toString().toLowerCase(),
                            gambar.toString().toLowerCase(),
                        alamat.getText().toString().toLowerCase(),
                            spinner.getSelectedItem().toString().toLowerCase(),
                        deskz.getText().toString().toLowerCase(),
                            jumlah.getText().toString().toLowerCase()


                            ));




                    //Insert data in database
                    //db1.userDaoH().insertAll(historyDB);
                    //Toast.makeText(getApplicationContext(), "Berhasil di Tambahkan", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Mohon tampilkan harga terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void submituser(Request request){
        database.child("Item").child("Request")
                .push()
                .setValue(request)
                .addOnSuccessListener(this, new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        loading.dismiss();

                        Toast.makeText(Product_Beli.this,"produk berhasil dibeli",Toast.LENGTH_SHORT).show();
                    }
                });


    }};







