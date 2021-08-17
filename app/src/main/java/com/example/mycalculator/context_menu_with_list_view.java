package com.example.mycalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class context_menu_with_list_view extends AppCompatActivity {

    private ListView listView;
    private String MyContacts[] = {"kishore", "mahe", "selva", "ranjuthan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu_with_list_view);
        listView = findViewById(R.id.list_view);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, MyContacts);
        listView.setAdapter(myAdapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
        menu.setHeaderTitle("select the action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.call){
            Toast.makeText(getApplicationContext(), "called", Toast.LENGTH_SHORT).show();
        }
        else if(item.getItemId() == R.id.sms){
            Toast.makeText(getApplicationContext(), "sms sent", Toast.LENGTH_SHORT).show();
        }
        else{
            return false;
        }
        return true;
    }

}
