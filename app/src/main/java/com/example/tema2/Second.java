package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Second extends AppCompatActivity {

    private static final String TAG = "Second";
    private ArrayList<String> mText = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Log.d(TAG,"onCreate:started.");

        List<User> users = MainActivity.myAppDatabase.userDao().getAll();
        String info = "";
        for(User usr:users){
            int nota = usr.getMark();
            String name = usr.getName();
            int id = usr.getId();
            info =  "Id :" + id + "\n" + "Nume: " + name + "\n" + "Nota = " + nota + "\n\n";
            mText.add(info);
        }
//        String a ="" + mText.size();
//        Toast.makeText(getBaseContext(), a,
//                Toast.LENGTH_LONG).show();
        initRecycleView();
    }

    private void initRecycleView(){
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mText);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
