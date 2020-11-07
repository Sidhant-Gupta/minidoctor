package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_user);

        EditText ayush=findViewById (R.id.ayush);

        Button verify=findViewById (R.id.verify_btn);
        Button puranedocs=(Button)findViewById (R.id.puranedocs_btn);
        TextView status = findViewById (R.id.status_verify);
        Button prescribedocs=findViewById (R.id.prescribe_btn);
        //TODO: activate button only if status==verified

        puranedocs.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (getApplicationContext (),PatientDocsActivity.class);
                startActivity (intent);
            }
        });

        prescribedocs.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (getApplicationContext (),Prescribe.class);
                startActivity (intent);
            }
        });
    }
}
