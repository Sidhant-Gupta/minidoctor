package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class preregister extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_preregister);

        System.out.println("qqqqqqqqqq");
        Button user=(Button)findViewById (R.id.user);
        Button doc=(Button)findViewById (R.id.doc);
        Button chem=(Button)findViewById (R.id.chem);

        user.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent reg=new Intent(getApplicationContext(),register.class);
                reg.putExtra ("who", "user");
                startActivity(reg);
            }
        });

        doc.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent (getApplicationContext (), register.class);
                reg.putExtra ("who", "doc");
                startActivity (reg);
            }
        });
        chem.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent (getApplicationContext (), register.class);
                reg.putExtra ("who", "chem");
                startActivity (reg);
            }
        });
    }
}
