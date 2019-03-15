package com.satrio.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.satrio.myapplication.room.Distributor;

import static com.satrio.myapplication.AppAplication.db;

public class TambahDistributor extends AppCompatActivity {

    private Button insertData;
    private EditText etAlamat;
    private EditText etKota;
    private EditText etNama;
    private EditText etNIK;
    private EditText telepon;
    Distributor distributor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_distributor);
        insertData = findViewById(R.id.btInsert);
        etAlamat = findViewById(R.id.etAlamat);
        etKota = findViewById(R.id.etKota);
        etNIK = findViewById(R.id.etNik);
        etNama = findViewById(R.id.etNama);
        telepon = findViewById(R.id.etTelepon);

        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etAlamat.getText().toString().isEmpty()&&!etKota.getText().toString().isEmpty()&&
                        !etNama.getText().toString().isEmpty()&&!etNIK.getText().toString().isEmpty()){

                    distributor = new Distributor();
                    distributor.setAlamat(etAlamat.getText().toString());
                    distributor.setKota(etKota.getText().toString());
                    distributor.setNama(etNama.getText().toString());
                    distributor.setNik(etNIK.getText().toString());
                    distributor.setTelepon(telepon.getText().toString());
                    //Insert data in database
                    db.userDao().insertAll(distributor);
                    Toast.makeText(getApplicationContext(), "Berhasil di Tambahkan", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "Mohon masukkan dengan benar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
