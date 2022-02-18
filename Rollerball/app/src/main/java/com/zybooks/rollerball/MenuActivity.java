package com.zybooks.rollerball;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView mContinueText = findViewById(R.id.continueText);
        mContinueText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){contineToNextActivity(v);}
        });
    }

    public void contineToNextActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}