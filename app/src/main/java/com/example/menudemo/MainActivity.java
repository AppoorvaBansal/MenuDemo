package com.example.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;



public class MainActivity extends AppCompatActivity {
LinearLayout ll;
    ListView listView1;

    String contacts[]={"Ajay","Sachin","Sumit","Tarun","Yogesh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


listView1=findViewById(R.id.list1);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>( this,android.R.layout.simple_list_item_1,contacts);

        listView1.setAdapter(adapter);



        // Register the ListView  for Context menu

        registerForContextMenu(listView1);
        ll=findViewById(R.id.ll);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select The Action");
        MenuInflater mf=getMenuInflater();
        mf.inflate(R.menu.menulist,menu);
        menu.add(0, v.getId(), 0, "Call");//groupId, itemId, order, title

        menu.add(0, v.getId(), 0, "SMS");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getTitle()=="Call"){

            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();

        }

        else if(item.getTitle()=="SMS"){

            Toast.makeText(getApplicationContext(),"sending sms code",Toast.LENGTH_LONG).show();

        }else{

            return false;

        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mf=getMenuInflater();
        mf.inflate(R.menu.menulist,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.it1:
                // calll the fragment show the particluar
                Snackbar snack= Snackbar.make(ll,"New Group is called",Snackbar.LENGTH_LONG);
                snack.show();
                Toast.makeText(MainActivity.this, "New Group is called", Toast.LENGTH_SHORT).show();
                return true ;
            case R.id.it2:
                Toast.makeText(MainActivity.this, "New Braodcast is called", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.it3:
                Toast.makeText(MainActivity.this, "Whatsapp Web is called", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.it4:
                PopupMenu pop=new PopupMenu(this,findViewById(R.id.it4));
                pop.getMenu().add("Reply");
                pop.getMenu().add("Email");
                pop.show();

                pop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        if(item.getTitle()=="Reply"){

                            Toast.makeText(getApplicationContext(),"REPLY",Toast.LENGTH_LONG).show();

                        }

                        else if(item.getTitle()=="Email"){

                            Toast.makeText(getApplicationContext(),"Email",Toast.LENGTH_LONG).show();

                        }else{

                            return false;

                        }

                        return true;
                    }
                });
                Toast.makeText(MainActivity.this, "Settings is called", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }
}
