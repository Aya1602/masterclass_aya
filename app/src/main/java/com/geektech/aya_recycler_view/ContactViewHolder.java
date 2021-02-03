package com.geektech.aya_recycler_view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {

    public ContactViewHolder(@NonNull View itemView, final OnContactClickListener listener) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onContactClick(getAdapterPosition());
            }
        });
    }

    public void onBind(Contact contact){
        TextView textViewName = itemView.findViewById(R.id.text_view_name);
        ImageView imageViewAvatar = itemView.findViewById(R.id.iv_avatar);

        textViewName.setText(contact.getName());
        imageViewAvatar.setImageResource(contact.getAvatarResoursId());
    }

}
