package com.example.healthcare;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolderContact extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView img;
    TextView tvHeading,tvSubHeading;
    AdapterContacts.onNoteListener onNoteListener;
//    Button btn;

    public ViewHolderContact(@NonNull View itemView, AdapterContacts.onNoteListener onNoteListener) {
        super(itemView);
        img=(ImageView)itemView.findViewById(R.id.img_contact);
        tvHeading=(TextView)itemView.findViewById(R.id.tv_heading);
        tvSubHeading=(TextView)itemView.findViewById(R.id.tv_subheading);
//        btn = (Button)itemView.findViewById (R.id.gotomap);

        this.onNoteListener = onNoteListener;
        itemView.setOnClickListener (this);
    }

    @Override
    public void onClick(View view) {
        onNoteListener.onNoteClick (getAdapterPosition ());
    }



}
