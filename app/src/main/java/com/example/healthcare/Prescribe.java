package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Prescribe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_prescribe);
        Button btn=findViewById (R.id.btn2);


        final ListView lv;

        lv=findViewById (R.id.lview);

        // Instanciating an array list (you don't need to do this,
        // you already have yours).
        List<String> your_array_list = new ArrayList<String> ();
        your_array_list.add("Combiflam");
        your_array_list.add("Vicks");
        your_array_list.add("Acetaminophen (Tylenol, others)");
        your_array_list.add("Ibuprofen (Advil, Motrin IB)");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                your_array_list );


        btn.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View view) {
                lv.setAdapter(arrayAdapter);
            }
        });
    }

}
