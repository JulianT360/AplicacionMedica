package com.fime.lidm.aplicacionmedica;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Utils extends AppCompatActivity {



    public void setChangeActivity(View v, Context from, Class to) {
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(from, to);
                startActivity(intent);
            }
        });
    }

    public void setBackButtonFunction(View btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
