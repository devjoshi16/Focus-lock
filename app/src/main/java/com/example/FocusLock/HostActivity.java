package com.example.FocusLock;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.FocusLock.R;

public class HostActivity extends AppCompatActivity {
    private Button host,join;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host);
        host=findViewById(R.id.btnhost);
        join=findViewById(R.id.btnjoin);
        host.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
    }
}
