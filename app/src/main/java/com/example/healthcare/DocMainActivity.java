package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DocMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_doc_main);

        ImageButton btn=(ImageButton)findViewById (R.id.btn);

        ListView lv;

        lv=findViewById (R.id.lv);

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> your_array_list = new ArrayList<String> ();
        your_array_list.add("1234567");
        your_array_list.add("9364506");
        your_array_list.add("8295203");
        your_array_list.add("4344234");
        your_array_list.add("9385621");
        your_array_list.add("5664506");
        your_array_list.add("0934767");
        your_array_list.add("6264674");
        your_array_list.add("1259318");
        your_array_list.add("1636641");
        your_array_list.add("4911690");
        your_array_list.add("9364349");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );

        lv.setAdapter(arrayAdapter);


        btn.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent (getApplicationContext (),AddUser.class);
                startActivity (intent);
            }
        });
    }

}
