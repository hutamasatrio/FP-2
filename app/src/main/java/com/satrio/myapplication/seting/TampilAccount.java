package com.satrio.myapplication.seting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.satrio.myapplication.Login;
import com.satrio.myapplication.MainActivity;
import com.satrio.myapplication.R;
import com.satrio.myapplication.adapter.PreferenceHelper;

public class TampilAccount extends AppCompatActivity {

    PreferenceHelper INSTANCE;
    TextView username, email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_account);

        INSTANCE = PreferenceHelper.getInstance(getApplicationContext());

        username = (TextView) findViewById(R.id.username);
        email = (TextView) findViewById(R.id.email);
        password = (TextView) findViewById(R.id.password);

        username.setText(INSTANCE.getName());
        email.setText(INSTANCE.getEmail());
        password.setText(INSTANCE.getPass());

    }

    public void logout(View view) {
        INSTANCE.setLogin(false);
        startActivity(new Intent(this, Login.class));
        finish();

    }
    public void onBackPressed (){
        super.onBackPressed();
        Intent intent = new Intent(TampilAccount.this, MainActivity.class );
        startActivity(intent);

    }
}
