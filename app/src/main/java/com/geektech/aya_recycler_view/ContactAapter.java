package com.geektech.aya_recycler_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactAapter extends RecyclerView.Adapter<ContactViewHolder> {

    private List<Contact> data = new ArrayList<>();

    private OnContactClickListener listener;

    public void setListener(OnContactClickListener listener) {
        this.listener = listener;
    }

    public List<Contact> getData() {
        return data;
    }

    public void setData(List<Contact> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void addItem(Contact contact){
        data.add(0, contact);
        notifyItemInserted(0);
    }

    public void deleteByPos(int pos){
        data.remove(pos);
        notifyItemRemoved(pos);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.onBind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
