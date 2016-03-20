package com.example.sathya_g.iot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);


        String msg;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                msg= null;
            } else {
                msg= extras.getString("msg");
            }
        } else {
            msg= (String) savedInstanceState.getSerializable("msg");
        }


        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

        Button mButton = (Button) findViewById(R.id.button3);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callUserLogin();
            }
        });
        Button mButton1 = (Button) findViewById(R.id.button4);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callAdminHome();
            }
        });



    }

    private void callAdminHome() {
        Intent intent = new Intent(AdminLogin.this, AdminHome.class);
        String msg="none";
        intent.putExtra("mgs",msg);
        startActivity(intent);

    }

    private void callUserLogin() {
        Intent intent = new Intent(AdminLogin.this, UserLogin.class);
        String msg="none";
        intent.putExtra("mgs",msg);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin_login, menu);
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