package com.example.myapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {
    TextView menu_text1;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu_text1 = findViewById(R.id.menu_text1);
        getData();
    }

    // 함수 정의 (생성)
    void getData(){
        id = getIntent().getStringExtra("myId");
        menu_text1.setText(id);
    }
}