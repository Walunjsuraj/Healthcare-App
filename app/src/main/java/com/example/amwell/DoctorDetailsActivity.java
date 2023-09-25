package com.example.amwell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private  String[][] doctor_detials1 = {
            {"doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp :5yrs", "Mobile No : 9898989898","600"},
            {"doctor Name : Suraj Walunj", "Hospital Address : Akurdi", "Exp :12yrs", "Mobile No : 989898982384","900"},
            {"doctor Name : deepak metkar", "Hospital Address : pune", "Exp :10yrs", "Mobile No : 98982349898","300"},
            {"doctor Name : ashok mane", "Hospital Address : katraj", "Exp :2yrs", "Mobile No : 9898449898","400"}

    };
    private  String[][] doctor_detials2 = {
            {"doctor Name : Ajit ss", "Hospital Address : Pimpri", "Exp :5yrs", "Mobile No : 9898989898","600"},
            {"doctor Name : Suraj walunje", "Hospital Address : Akurdi", "Exp :12yrs", "Mobile No : 989898982384","900"},
            {"doctor Name : deepak", "Hospital Address : pune", "Exp :10yrs", "Mobile No : 98982349898","300"},
            {"doctor Name : ashok mane", "Hospital Address : katraj", "Exp :2yrs", "Mobile No : 9898449898","400"}

    };
    private  String[][] doctor_detials3 = {
            {"doctor Name : Ajit saste", "Hospital Address : Pimpri", "Exp :5yrs", "Mobile No : 9898989898","600"},
            {"doctor Name : Suraj walunj", "Hospital Address : Akurdi", "Exp :12yrs", "Mobile No : 989898982384","900"},
            {"doctor Name : deepak", "Hospital Address : pune", "Exp :10yrs", "Mobile No : 98982349898","300"},
            {"doctor Name : ashok mane", "Hospital Address : katraj", "Exp :2yrs", "Mobile No : 9898449898","400"}

    };
    private  String[][] doctor_detials4 = {
            {"doctor Name : Ajit saste", "Hospital Address : Pimpri", "Exp :5yrs", "Mobile No : 9898989898","600"},
            {"doctor Name : Suraj walunj", "Hospital Address : Akurdi", "Exp :12yrs", "Mobile No : 989898982384","900"},
            {"doctor Name : deepak", "Hospital Address : pune", "Exp :10yrs", "Mobile No : 98982349898","300"},
            {"doctor Name : ashok mane", "Hospital Address : katraj", "Exp :2yrs", "Mobile No : 9898449898","400"}

    };
    private  String[][] doctor_detials5 = {
            {"doctor Name : Ajit saste", "Hospital Address : Pimpri", "Exp :5yrs", "Mobile No : 9898989898","600"},
            {"doctor Name : Suraj walunj", "Hospital Address : Akurdi", "Exp :12yrs", "Mobile No : 989898982384","900"},
            {"doctor Name : deepak", "Hospital Address : pune", "Exp :10yrs", "Mobile No : 98982349898","300"},
            {"doctor Name : ashok mane", "Hospital Address : katraj", "Exp :2yrs", "Mobile No : 9898449898","400"}

    };

     TextView tv;
     Button btn;
     String[][] doctor_detials = {};
     HashMap<String,String>item;
     ArrayList list;
     SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewBMCartTitle);
        btn = findViewById(R.id.buttonBMDAddToCart);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_detials = doctor_detials1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_detials = doctor_detials2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_detials = doctor_detials3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_detials = doctor_detials4;
        else

            doctor_detials = doctor_detials5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });

        list =  new ArrayList();
        for(int i=0; i<doctor_detials.length;i++ ){
            item = new HashMap<String,String>();
            item.put("line1", doctor_detials[i][0]);
            item.put("line2", doctor_detials[i][1]);
            item.put("line3", doctor_detials[i][2]);
            item.put("line4", doctor_detials[i][3]);
            item.put("line5", "Cons Fees" +doctor_detials[i][4]+" /-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
                );
        ListView lst =  findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_detials[i][0]);
                it.putExtra("text3",doctor_detials[i][1]);
                it.putExtra("text4",doctor_detials[i][3]);
                it.putExtra("text5",doctor_detials[i][4]);
                startActivity(it);
            }
        });
    }
}