package com.satrio.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.satrio.myapplication.adapter.PreferenceHelper;

public class Login extends AppCompatActivity {
    PreferenceHelper instance;
    Toolbar toolbar;
    EditText email,password;
    CheckBox checkBox;
    ImageButton signin;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        instance = PreferenceHelper.getInstance(getApplicationContext());


        CheckLogin();

        toolbar = (Toolbar) findViewById(R.id.toolbar);


        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        checkBox = (CheckBox)findViewById(R.id.checkbox);

        signin =(ImageButton)findViewById(R.id.signin);
        signup = (Button) findViewById(R.id.signup);

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Pass = password.getText().toString();
                String mEmail = instance.getEmail();
                String mPass = instance.getPass();
                boolean cekEmail = Email.equals(mEmail);
                boolean cekPass = Pass.equals(mPass);

                if ( cekEmail && cekPass ) {
                    //jika login berhasil
                    instance.setLogin(true);
                    Toast.makeText( getApplicationContext(), "Login Berhasil",
                            Toast.LENGTH_SHORT ).show();
                    Intent intent = new Intent( Login.this, MainActivity.class );
                    startActivity( intent );
                    Toast.makeText(Login.this,"Sign In sukses",Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Alamat E-mail atau Password Anda salah!")
                            .setNegativeButton("Retry", null).create().show();
                }

//                Toast.makeText(Login.this,"Sign In Button Clicked",Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(Login.this, MainActivity.class);
//                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Bundle BundleLogin = new Bundle();
                BundleLogin.putString("dataEmail", email.getText().toString());
                BundleLogin.putString("dataPassword", password.getText().toString());
                Intent i = new Intent(Login.this, SignUpActivity.class);
                i.putExtras(BundleLogin);
                startActivity(i);
            }
        });
    }

    private void CheckLogin() {
        CheckBox cekLogin = (CheckBox) findViewById(R.id.checkbox);
        cekLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b){
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }else{
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
    }


}