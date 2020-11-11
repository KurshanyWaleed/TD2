package com.dmwm.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  Button btnsend ;
  EditText chattext;
  LinearLayout lr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsend = (Button) findViewById(R.id.buttonSend);
        chattext = (EditText) findViewById(R.id.editTextChat);
        lr = (LinearLayout) findViewById(R.id.lr);


        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView chat = new TextView(getApplicationContext());
                String str = chattext.getText().toString();
                chat.setText("me : " + str);
                chat.setPadding(20, 0, 0, 0);
                chat.setTextColor(getColor(R.color.black));
                chat.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                lr.addView(chat);
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("msg", str)
                ;
                startActivityForResult(i, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1){
            if (resultCode== Activity.RESULT_OK){
                String strResult=data.getStringExtra("res");
                TextView chat = new TextView(getApplicationContext());
                chat.setText(strResult+": stranger");
                chat.setTextDirection(View.TEXT_DIRECTION_RTL);
                chat.setPadding(700,0,0,0);
                chat.setTextColor(getColor(R.color.black));
                chat.setTextSize(TypedValue.COMPLEX_UNIT_DIP,20);
                lr.addView(chat);

            }
        }

    }
}

