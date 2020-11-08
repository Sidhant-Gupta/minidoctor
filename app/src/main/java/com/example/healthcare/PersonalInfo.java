package com.example.healthcare;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        ImageView img1=(ImageView)findViewById(R.id.img_contact);
        TextView name=(TextView)findViewById(R.id.tv_heading);
        TextView subhead=(TextView)findViewById(R.id.tv_subheading);

        ImageView img2=(ImageView)findViewById(R.id.img_feedback);
        TextView age1=(TextView)findViewById(R.id.tv_fback);
        TextView age=(TextView)findViewById(R.id.tv_fbackdesc);

        ImageView img3=(ImageView)findViewById(R.id.img_bug);
        TextView genderq=(TextView)findViewById(R.id.tv_bug);
        TextView gender=(TextView)findViewById(R.id.tv_bugdesc);

        ImageView img4=(ImageView)findViewById(R.id.img_weight);
        TextView weightq=(TextView)findViewById(R.id.tv_weight);
        TextView weight=(TextView)findViewById(R.id.tv_weightdesc);

        ImageView img5=(ImageView)findViewById(R.id.img_temperature);
        TextView tempq=(TextView)findViewById(R.id.tv_temperature);
        TextView temp=(TextView)findViewById(R.id.tv_tempdesc);
        ImageView img6=(ImageView)findViewById(R.id.img_temperaturecheck);

        TextView temq=(TextView)findViewById(R.id.tv_ayush);
        TextView tep=(TextView)findViewById(R.id.tv_amt);

    }
}
