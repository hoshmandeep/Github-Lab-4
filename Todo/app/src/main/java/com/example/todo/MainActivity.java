package com.example.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;



public class MainActivity<adapter> extends AppCompatActivity {
    private ArrayList<String> items;
    private ArrayAdapter<String> Adaptor_for_things;
    private ListView Items;


    private void setupListViewListener() {
        Items.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item at position in the array.
                        items.remove(pos);
                        // Recharge the adapter.
                        Adaptor_for_things.notifyDataSetChanged();
                        // The lengthy click event is consumed when you return true.
                        return true;
                    }

                });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Items = (ListView) findViewById(R.id.Items);
        items = new ArrayList<String>();
        Adaptor_for_things = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        Items.setAdapter(Adaptor_for_things);
        items.add("Item1"); // To add item 1
        items.add("Item2"); // To add item 2
        setupListViewListener();
    }
    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        Adaptor_for_things.add(itemText);
        etNewItem.setText("");

    }






}