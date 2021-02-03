package com.geektech.aya_recycler_view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ContactAapter adapter = new ContactAapter();
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(adapter);

        final ArrayList<Contact> contactList = new ArrayList<>();

        contactList.add(new Contact("Aya", R.drawable.ic_person));
        contactList.add(new Contact("Alisa", R.drawable.ic_launcher_foreground));
        contactList.add(new Contact("Alina", R.drawable.ic_launcher_background));
        contactList.add(new Contact("Islam", R.drawable.ic_launcher_background));
        contactList.add(new Contact("Nurbek", R.drawable.ic_launcher_foreground));

        adapter.setData(contactList);


        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int pos = viewHolder.getAdapterPosition();
                int targetPos = target.getAdapterPosition();
                Collections.swap(adapter.getData(), pos, targetPos);
                adapter.notifyItemMoved(pos, targetPos);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                adapter.deleteByPos(position);
            }
        };


        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        findViewById(R.id.button_add)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        adapter.addItem(new Contact("name", R.drawable.ic_person));
                        recyclerView.scrollToPosition(0);
                    }
                });


        adapter.setListener(new OnContactClickListener() {
            @Override
            public void onContactClick(int pos) {
                Toast.makeText(MainActivity.this, contactList.get(pos).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
