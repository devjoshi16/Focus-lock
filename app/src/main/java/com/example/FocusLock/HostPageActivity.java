package com.example.FocusLock;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HostPageActivity extends AppCompatActivity {
    private ArrayList<String> device_name,device_address;
    private  Button discoverbtn;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.host_page);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));

        discoverbtn=(Button)findViewById(R.id.btndiscover);
        device_name=new ArrayList<>();
        device_address=new ArrayList<>();
        discoverbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                device_name.add("devdfgd");
                device_address.add("1542321441321");
                device_name.add("devfdg");
                device_address.add("1542321321");
                device_name.add("devhg");
                device_address.add("1542321321");
                device_name.add("devdvv");
                device_address.add("51632");
                AdapterDevice adapter = new AdapterDevice(HostPageActivity.this, device_name ,device_address);
                recyclerView.setAdapter(adapter);
                Toast.makeText(HostPageActivity.this,"end of function",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
