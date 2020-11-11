package com.dmwm.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
           Button btnSend ;
           EditText chatText;
           LinearLayout lr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        chatText=(EditText) findViewById(R.id.editTextChat);
        lr=(LinearLayout) findViewById(R.id.lr);
        btnSend = findViewById(R.id.buttonSend);
        chatText=findViewById(R.id.editTextChat);
        String str2=chatText.getText().toString();



        Intent j = getIntent();
        String msg=j.getStringExtra("msg");

        TextView chat=new TextView(getApplicationContext());
        chat.setText(msg+" : stranger");
        chat.setTextDirection(View.TEXT_DIRECTION_RTL);
        chat.setPadding(800,0,0,0);
        chat.setTextColor(getColor(R.color.black));
        chat.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
        lr.addView(chat);




        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TextView chat = new TextView(getApplicationContext());
                String str = chatText.getText().toString();
                chat.setText("me : " + str);
                chat.setPadding(20, 0, 0, 0);
                chat.setTextColor(getColor(R.color.black));
                chat.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                lr.addView(chat);

                Intent ires = new Intent();
                ires.putExtra("res",str);
               setResult(RESULT_OK,ires);
               finish();
            }
        });




    }



}