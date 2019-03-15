package com.satrio.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.satrio.myapplication.adapter.PreferenceHelper;

public class SignUpActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText email,password,name;
    CheckBox checkBox;
    ImageButton signup;
    Button signin;
    PreferenceHelper instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        checkBox = (CheckBox)findViewById(R.id.checkbox);
        signup =(ImageButton)findViewById(R.id.signup);
        signin = (Button) findViewById(R.id.signin);

        Bundle BundleRegistrasi = getIntent().getExtras();
        email.setText(BundleRegistrasi.getString("dataEmail"));
        password.setText((BundleRegistrasi.getString("dataPassword")));
        name.setText(BundleRegistrasi.getString("nama"));

        instance = PreferenceHelper.getInstance(getApplicationContext());



        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (!email.getText().toString().isEmpty()&&
                        !password.getText().toString().isEmpty()&&
                        !name.getText().toString().isEmpty()
                        ){
                    String Email = email.getText().toString();
                    String Nama = name.getText().toString();
                    String Pass = password.getText().toString();
                    instance.setEmail(Email);
                    instance.setName(Nama);
                    instance.setPass(Pass);

                    Toast.makeText(SignUpActivity.this,"Sign Up Sukses",Toast.LENGTH_LONG).show();
                    //finish();

                }else {Toast.makeText(SignUpActivity.this,"Sign Up Gagal",Toast.LENGTH_LONG).show();
                    };

            }
        });

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this,Login.class);
                startActivity(i);
            }
        });


    }
}