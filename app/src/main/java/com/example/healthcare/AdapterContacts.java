package com.example.healthcare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterContacts extends RecyclerView.Adapter<ViewHolderContact> {

    ArrayList<ModelContacts> data;
    LayoutInflater inflater;

    private onNoteListener monNoteListener;
    public AdapterContacts(Context context, ArrayList<ModelContacts> data, onNoteListener onNoteListener) {
        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.monNoteListener = onNoteListener;
    }


    @NonNull
    @Override
    public ViewHolderContact onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.single_row_contact,parent,false);
        return new ViewHolderContact(view,monNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderContact holder, final int position) {
        holder.tvHeading.setText(data.get(position).getHeading());
        holder.tvSubHeading.setText(data.get(position).getSubHeading());
        holder.img.setImageResource(data.get(position).getImgName());
//        holder.btn.setOnClickListener (new View.OnClickListener (){
//
//            @Override
//            public void onClick(View view) {
//                String t = data.get(position).getHeading();
//                Toast.makeText (Context, t, Toast.LENGTH_SHORT).show ( );
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface onNoteListener{
        void onNoteClick(int position);
    }
}
