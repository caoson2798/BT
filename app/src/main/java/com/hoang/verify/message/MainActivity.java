package com.hoang.verify.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    EditText edtInputMessage;
    TextView btnSend;
    ArrayList<Chat> arrayMessage ;
    AdapterMessage adapterMessage= new AdapterMessage();

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


        arrayMessage= new ArrayList<>();
        adapterMessage.arrayMessage = arrayMessage;
        adapterMessage.context = MainActivity.this;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));
        recyclerView.setAdapter(adapterMessage);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rd=new Random();
                String content=edtInputMessage.getText().toString();

                if (!content.isEmpty()) {
                    adapterMessage.check=rd.nextInt(2);
                    arrayMessage.add(0, new Chat(content,rd.nextInt(2)));
                    edtInputMessage.setText("");

                }
                adapterMessage.notifyDataSetChanged();
            }
        });



    }

    void init() {
        recyclerView = findViewById(R.id.rv_message);
        edtInputMessage = findViewById(R.id.edt_input_message);
        btnSend = findViewById(R.id.btn_send);
    }
}
