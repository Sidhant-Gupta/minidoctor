package com.example.healthcare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcare.RetrofitModel.ModelMedHistory;
import com.example.healthcare.RetrofitModel.ModelPrescriptions;
import com.example.healthcare.RetrofitModel.RetrofitApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MedHistory extends AppCompatActivity implements AdapterContacts.onNoteListener{

    private AdapterContacts adapter;
    private RecyclerView recyclerView;
    ArrayList<ModelContacts> restList;


    interface DataReceivedListener{
        void onDataReceived(ArrayList<ModelContacts> timetable);
    }

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

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(RetrofitApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitApi api=retrofit.create(RetrofitApi.class);
        Call<ModelMedHistory> call=api.getallPrescriptions(1);
        System.out.println("pqpqpqpqpqpq holllllllllllaaaaaaaaaaaa");
        call.enqueue(new Callback<ModelMedHistory>() {
            @Override
            public void onResponse(Call<ModelMedHistory> call, Response<ModelMedHistory> response) {
                System.out.println("sssssssssssssssssss holllllllllllaaaaaaaaaaaa");
                ModelMedHistory medHistory=response.body();
                List<ModelPrescriptions> appointments=new ArrayList<ModelPrescriptions>();
                appointments=medHistory.getPrescriptionsAll();

                ArrayList<ModelContacts> holder1 = new ArrayList<> ( );
                for (int i = 0; i < appointments.size(); i++) {
                    System.out.println("sssssssssssssssssss " + appointments.get(0).getDoctorName());
                    ModelContacts ob1 = new ModelContacts ( );
                    ob1.setHeading (appointments.get(i).getDoctorName());
                    ob1.setSubHeading (appointments.get(i).getTimestamp() +
                            "\nProblem-`"+appointments.get(i).getTitle());
                    ob1.setImgName (R.drawable.boythree);

                    holder1.add (ob1);
                }
                onDataRecieved(holder1);

            }

            @Override
            public void onFailure(Call<ModelMedHistory> call, Throwable t) {
                System.out.println("ERoorrrr "+t.getMessage());
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

//        ModelContacts ob1 = new ModelContacts ( );
//        ob1.setHeading ("Barcelo's Grill");
//        ob1.setSubHeading ("Quality non-veg, "+"mandatory picture spot" +
//                "\nRating: 3.7");
//        ob1.setImgName (R.drawable.boythree);
//
//        holder.add (ob1);


//        ModelContacts ob2 = new ModelContacts ( );
//        ob2.setHeading ("Pizza Hut");
//        ob2.setSubHeading ("Affordable, " + "Nice ambiance"+
//                "\nRating: 4");
//        ob2.setImgName (R.drawable.boythree);
//        holder.add (ob2);
//
//
//        ModelContacts ob3 = new ModelContacts ( );
//        ob3.setHeading ("The Vintage Cafe");
//        ob3.setSubHeading ("Affordable, " + "Nice ambiance"+
//                "\nRating: 4");
//        ob3.setImgName (R.drawable.boythree);
//        holder.add (ob3);
//
//        ModelContacts ob4 = new ModelContacts ( );
//        ob4.setHeading ("C Seven Hotel");
//        ob4.setSubHeading ("Affordable, " + "Nice ambiance"+
//                "\nRating: 4");
//        ob4.setImgName (R.drawable.boythree);
//        holder.add (ob4);
//
//        ModelContacts ob5 = new ModelContacts ( );
//        ob5.setHeading ("The Meridien");
//        ob5.setSubHeading ("Affordable, " + "Nice ambiance"+
//                "\nRating: 4");
//        ob5.setImgName (R.drawable.boy);
//        holder.add (ob5);
//
//        ModelContacts ob6 = new ModelContacts ( );
//        ob6.setHeading ("Mezban Hotel and Restaurant");
//        ob6.setSubHeading ("Affordable, " + "Nice ambiance"+
//                "\nRating: 4");
//        ob6.setImgName (R.drawable.boythree);
//        holder.add (ob6);
        return holder;
    }

    public void onDataRecieved(ArrayList<ModelContacts> restList){
        System.out.println("On DATAA Recieved");
        recyclerView = (RecyclerView) findViewById (R.id.rv_contactDep);
        recyclerView.setLayoutManager (new LinearLayoutManager (this));
        adapter = new AdapterContacts (this, restList, this);
        recyclerView.setAdapter (adapter);
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
