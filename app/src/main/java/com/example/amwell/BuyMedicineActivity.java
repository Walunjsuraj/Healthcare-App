package com.example.amwell;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"uprise-D3 1000IU", "", ""," ", "50"},
                    {"Healthvit Chromium Piclimate 200mcg", " ", " ", " "," ", "305"},
                    {"Vitamin B Complex", " ", " ", " ", "448"," "},
                    {" InLife Vitamin E Complex", " ", " ", " ", "448"," "},
                    {"Dolo 650 Tablet", " ", " ", " ", "50"," "},
                    {"Crocin 650 Advance Tablet", " ", " ", " ", "30"," "},
                    {"Strepsils Ma=edicinew Lozenges for Sore Thoroat", " ", " ", " ", "448"," "},
                    {"Tata img Faronia -XT Tablet", " ", " ", " ", "130"," "},
            };

    private String[] packages_details = {
            "buliding and keeping Bonew and Teeth strong\n" +
                    "Reducing Fatigue/stress and muscals pains\n" +
                    "Boosting immunity and increasing resisitance against infaction\n" +
                    "Provides relief from vitamin B deficieices\n" +
                    "Helps in firmation of red Blood cell\n" +
                    "maintain health nervous system ," +
                    "It promotes health as well as skin benefit.\n" +
                    "It helps reduce skin blemish and pigmetation\n" +
                    "It act as safeguard the skin from protect against sun",
            "dolo 650 Tablet helos releive pain and fever by blocking the release of some certain chemical massages ",
            "Helps relive fever and bring down a high temperature\n"+
                    "suitable for peaple with a heart condition or high blood pressure",
            "Relives the symptoms of a bacteria throat infection and recory process\n"+
                    "promotes mobility and flexibility of joints",
            "Helps to redice the iron deficiency due to chronic blood loss or low intake iron"

    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewHA);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,HouseActivity.class));
            }
        });
        list =  new ArrayList();
        for (int i=0; i<packages.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5","Total cost :"+packages[i][4]);
            list.add(item);

        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

       lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent it  = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
               it.putExtra("text1",packages[i][0]);
               it.putExtra("text2",packages_details[i]);
               it.putExtra("text3", packages[i][4]);
               startActivity(it);
           }
       });

    }
}