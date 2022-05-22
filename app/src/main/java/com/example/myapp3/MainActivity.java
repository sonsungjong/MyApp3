package com.example.myapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // AppCompatActivity 복사 붙여넣기
    EditText edit1;
    EditText edit2;
    Button button1;
    String m_id = "thstjdwhd";
    String m_pass = "1234";
    String input1 = "", input2 = "";
    TextView text1;
    ImageView logo1;
    int logo_flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 상태바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // 화면과 자바변수를 연결
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        button1 = findViewById(R.id.button1);
        text1 = findViewById(R.id.text1);
        logo1 = findViewById(R.id.logo1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input1 = edit1.getText().toString();
                input2 = edit2.getText().toString();
                if(input1.equals(m_id) && input2.equals(m_pass)){
                    Toast.makeText(getApplicationContext(), "로그인 성공!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                    intent.putExtra("my_id", m_id);
                    startActivity(intent);
                    finish();
                    //text1.setText("로그인");
                }else{
                    Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    text1.setText("실패");
                }
            }
        });

        logo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage(logo_flag);
            }
        });
    }
    void changeImage(int flag){
        // 클릭할때 logo_flag의 값을 더하기를 해주고
        // if문으로 해당 값에 대한 이미지를 나오게 해주세요
        logo1.setImageResource(R.drawable.fruits);
    }

    @Override
    protected void onDestroy() {
        //Toast.makeText(getApplicationContext(), "빠이빠이!", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}











