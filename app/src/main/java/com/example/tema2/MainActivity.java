package com.example.tema2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    private EditText Username,mark;
    private Button addUser;
    private Button deleteUser;
    public static MyAppDatabase myAppDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myAppDatabase = Room.databaseBuilder(getApplicationContext(),MyAppDatabase.class,"userdb").allowMainThreadQueries().build();

        Username = findViewById(R.id.editText);
        mark = findViewById(R.id.editText2);
        addUser = findViewById(R.id.button);
        deleteUser = findViewById(R.id.button2);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nota = Integer.parseInt(mark.getText().toString());
                String username = Username.getText().toString();

                User user = new User();
                user.setMark(nota);
                user.setName(username);

                myAppDatabase.userDao().addUser(user);
                Toast.makeText(getBaseContext(), "User added successfully!",
                        Toast.LENGTH_LONG).show();

                Username.setText("");
                mark.setText("");



            }
        });
        Button btnFragment = (Button) findViewById(R.id.button3);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getBaseContext(), Second.class);
                in.putExtra("some","some data");
                startActivity(in); // Am pus afisarea intr-o alta activitatea deoarece mi se parea mult mai clean si oricum nu mai aveam prea mult loc in activitatea principala.
            }
        });
        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = Username.getText().toString();

                User user = new User();
                user.setName(username);

                myAppDatabase.userDao().deleteAllByNames(username);
                Toast.makeText(getBaseContext(), "User "+username+ " was successfully delete!",
                        Toast.LENGTH_LONG).show();

                Username.setText("");
                mark.setText("");



            }
        });
    }
}
