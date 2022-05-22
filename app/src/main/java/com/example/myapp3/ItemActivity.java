package com.example.myapp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class ItemActivity extends AppCompatActivity {

    String m_id = "";
    static TextView item_total;
    GridView grid_view;
    static int total_price = 0;
    Button item_payment;

    String[] pdt_name = {"상품1", "상품2", "상품3", "상품4", "상품5", "상품6", "상품7", "상품8", "상품9"};
    int pdt_photo[] = {R.drawable.fruits, R.drawable.logo, R.drawable.fruits, R.drawable.fruits, R.drawable.fruits,
            R.drawable.fruits, R.drawable.fruits, R.drawable.fruits, R.drawable.fruits};
    int pdt_price[] = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000};
    int pdt_count[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 상태바 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_item);

        item_total = findViewById(R.id.item_total);
        grid_view = findViewById(R.id.grid_view);
        item_payment = findViewById(R.id.item_payment);

        getData();

        item_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(ItemActivity.this, PayActivity.class);
                // KG 혹은 아임포트에서 요구하는 값들을 변수에 담아 PayActivity에 넘기기
                //startActivity(intent);
                Toast.makeText(ItemActivity.this, ""+total_price+"원 결제완료", Toast.LENGTH_SHORT).show();
            }
        });

        item_total.setText("총 가격 : "+addComma(total_price)+"원");

        ItemAdapter adapter = new ItemAdapter(ItemActivity.this, pdt_name, pdt_photo, pdt_price, pdt_count);
        grid_view.setAdapter(adapter);
    }

    // 인텐트 전달값 받기
    public void getData(){
        if(getIntent().hasExtra("my_id")){
            m_id = getIntent().getStringExtra("my_id");
        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    public String addComma(int number){
        String result = "";
        StringBuffer sb = new StringBuffer();
        result = ""+number;
        sb.append(result);
        if(number < 1000){}
        else if(number < 1000000){
            // 1000,9999,99999,999999
            if(number < 10000){
                // 9999
                sb.insert(1, ",");
            }else if(number < 100000){
                // 99999
                sb.insert(2, ",");
            }else{
                // 999999
                sb.insert(3, ",");
            }
        }else if(number < 1000000000){
            if(number < 10000000){
                // 9999999
                sb.insert(4, ",");
                sb.insert(1,",");
            }else if(number < 100000000){
                // 99999999
                sb.insert(5, ",");
                sb.insert(2,",");
            }else{
                // 999,999,999
                sb.insert(6, ",");
                sb.insert(3,",");
            }
        }
        return sb.toString();
    }       // addComma
}