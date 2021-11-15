 package com.example.android_hw_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;





 public class MainActivity extends AppCompatActivity {
        private Button Send;
        private EditText gmail, theme,sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gmail = findViewById(R.id.gmail);
        theme = findViewById(R.id.theme);
        sms = findViewById(R.id.sms);

        Button Send =findViewById(R.id.Send);
        Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                senMail();
            }

            private void senMail() {
                String recipientList = gmail.getText().toString();
                String[] recipients = recipientList.split(",");

                String thems = theme.getText().toString();
                String message = sms.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,recipients);
                intent.putExtra(Intent.EXTRA_SUBJECT,thems);
                intent.putExtra(Intent.EXTRA_TEXT,message);
                intent.setType("message/999");
                startActivity(Intent.createChooser(intent,"Choose an Email: "));


            }
        });
    }


 }