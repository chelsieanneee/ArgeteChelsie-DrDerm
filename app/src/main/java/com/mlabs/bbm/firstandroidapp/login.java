package com.mlabs.bbm.firstandroidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.regex.Pattern;
import android.widget.Toast;

/**
 * Created by chelsieanneee on 22 Jul 2016.
 */
public class login extends AppCompatActivity {

    EditText Email;
    EditText Password;
    Button LogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Email=(EditText) findViewById(R.id.tfEmail);
        Password=(EditText) findViewById(R.id.tfPassword);
        LogIn=(Button) findViewById(R.id.btLogIn);
        LogIn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Pattern.compile("^\\w+.*\\w*@[a-zA-Z_]+?\\.[0-9a-zA-Z]{2,}$").matcher(Email.getText()).matches() && Password.length()>=8){
                        Intent intent= new Intent(login.this,MainActivity.class);
                        startActivity(intent);
                    }
                else{
                    Toast.makeText(getBaseContext(),"Email or Password is Incorrect",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
    @Override
    protected  void onPause(){
        super.onPause();
        finish();
    }
}
