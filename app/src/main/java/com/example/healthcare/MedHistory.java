package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MedHistory extends AppCompatActivity implements AdapterContacts.onNoteListener{

    private AdapterContacts adapter;
    private RecyclerView recyclerView;
    ArrayList<ModelContacts> restList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_med_history);

        // create instance of Random class
        Random rand = new Random ();

        // Generate random integers in range 0 to 4
        int rand_int1 = rand.nextInt(5);
        String tagline[] = new String[]{"We wish you a great Health", "May your day be very prosperous", "Thank you for checking In", "We care for you.", "Don't be scared. We are all together"};
        Toast.makeText (this, tagline[rand_int1], Toast.LENGTH_LONG).show ( );

        restList = new ArrayList<> ( );

        restList = dataqueue ( );
        recyclerView = (RecyclerView) findViewById (R.id.rv_contactDep);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));
        adapter = new AdapterContacts (this, restList, this);
        recyclerView.setAdapter (adapter);
//        recyclerView.setOnClickListener (new AdapterView<AdapterContacts>.OnItemClickListener (){

//        });

    }

    public ArrayList<ModelContacts> dataqueue() {
        ArrayList<ModelContacts> holder = new ArrayList<> ( );
        ModelContacts ob1 = new ModelContacts ( );
        ob1.setHeading ("Dr. Ajay Gupta");
        ob1.setSubHeading ("Child Specialist and Healthcare");
        ob1.setImgName (R.drawable.boythree);

        holder.add (ob1);


        ModelContacts ob2 = new ModelContacts ( );
        ob2.setHeading ("Dr. Sidhant Mittal");
        ob2.setSubHeading ("Neurologist and brain surgeon");
        ob2.setImgName (R.drawable.boythree);
        holder.add (ob2);


        ModelContacts ob3 = new ModelContacts ( );
        ob3.setHeading ("Dr. Pranjal Garg");
        ob3.setSubHeading ("Neuro surgeon practioner");
        ob3.setImgName (R.drawable.boythree);
        holder.add (ob3);

        ModelContacts ob4 = new ModelContacts ( );
        ob4.setHeading ("Dr. Giri Raj Gupta");
        ob4.setSubHeading ("Dental Health");
        ob4.setImgName (R.drawable.boythree);
        holder.add (ob4);

    return holder;


    }

    @Override
    public void onNoteClick(int position) {
//        Log.d (TAG, "onNoteClick: Clicked");

        Toast.makeText (this, restList.get (position).getHeading (), Toast.LENGTH_SHORT).show ( );
//        System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrr");
//        System.out.println (restList.get (position).getHeading ());
        Intent t =  new Intent(this, MainActivity.class);
        t.putExtra("obj", restList.get (position).getHeading ());
        startActivity (t);


    }
}
