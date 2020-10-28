package com.example.crud_roomdb_operation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;

import com.example.crud_roomdb_operation.database.MyAppDatabase;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class,"userdb")
                .allowMainThreadQueries()
                .build();


        // Null checking of container
        if(findViewById(R.id.fragment_container)!=null){

            if(savedInstanceState!=null){
                return;
            }

            fragmentManager.beginTransaction().add(R.id.fragment_container,new MainFragment()).commit();
        }

    }
    }
