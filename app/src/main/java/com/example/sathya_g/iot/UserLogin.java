package com.example.sathya_g.iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


        Intent mIntent= getIntent();
        String msg= mIntent.getStringExtra("DATA");


        //Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();


        Button mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAdminLogin();
            }
        });
        Button mButton1= (Button) findViewById(R.id.button2);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callUserHome();
            }
        });


    }

    private void callUserHome() {
        Intent intent = new Intent(UserLogin.this, AdminHome.class);
        String msg="user";
        intent.putExtra("DATA",msg);
        startActivity(intent);
    }


    private void callAdminLogin() {
        Intent intent = new Intent(UserLogin.this, AdminLogin.class);
        String msg="none";
        intent.putExtra("DATA",msg);
        startActivity(intent);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
