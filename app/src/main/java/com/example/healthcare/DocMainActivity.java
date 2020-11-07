package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class DocMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_doc_main);

        ImageButton btn=(ImageButton)findViewById (R.id.btn);

        btn.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (getApplicationContext (),AddUser.class);
                startActivity (intent);
            }
        });
    }

}
