package com.example.myapp3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private String[] pdt_name;
    private int pdt_photo[];
    private int pdt_price[];
    private int pdt_count[];

    ItemAdapter(Context context, String pdt_name[], int pdt_photo[], int pdt_price[], int pdt_count[]){
        this.context = context;
        this.pdt_name = pdt_name;
        this.pdt_photo = pdt_photo;
        this.pdt_price = pdt_price;
        this.pdt_count = pdt_count;
    }

    // 몇개 만들거냐
    @Override
    public int getCount() {
        return pdt_name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    // 보여줄 내용
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view = inflater.inflate(R.layout.row_item, null);
        }
        // 변수와 화면을 연결
        ImageView item_photo = view.findViewById(R.id.item_photo);
        TextView item_name = view.findViewById(R.id.item_name);
        TextView item_price = view.findViewById(R.id.item_price);
        TextView item_count = view.findViewById(R.id.item_count);
        Button item_plus = view.findViewById(R.id.item_plus);
        Button item_minus = view.findViewById(R.id.item_minus);

        item_photo.setImageResource(pdt_photo[i]);
        item_name.setText(pdt_name[i]);
        item_price.setText("가격 : "+pdt_price[i]+"원");
        item_count.setText(""+pdt_count[i]);

        item_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 플러스 버튼 누르면 동작하는 함수
                if(pdt_count[i] < 99){
                    ++pdt_count[i];
                    item_count.setText(""+pdt_count[i]);
                    ItemActivity.total_price += pdt_price[i];
                    ItemActivity.item_total.setText("총 가격 : "+ItemActivity.total_price+"원");
                }
            }
        });

        item_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 마이너스 버튼 누르면 동작하는 함수
                if(pdt_count[i] > 0){
                    --pdt_count[i];
                    item_count.setText(""+pdt_count[i]);
                    ItemActivity.total_price -= pdt_price[i];
                    ItemActivity.item_total.setText("총 가격 : "+ItemActivity.total_price+"원");
                }
            }
        });

        return view;
    }

    public String addComma(int number){
        String result = "";
        StringBuffer sb = new StringBuffer();
        result = ""+number;
        sb.append(result);
        if(number < 1000){
        }else if(number < 1000000){
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
    }
}
