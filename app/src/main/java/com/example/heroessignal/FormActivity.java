package com.example.heroessignal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button btSend = findViewById(R.id.btEnvoyer);
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (FormActivity.this, ChoiceHeroActivity.class);
                startActivity(intent);
            }
        });
    }

    public void buttonchecked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.rbExtra:
                /*if (checked)
                    gender = getString(R.string.femme);
                userSingleton.getUser().setGender(gender);*/
                break;
            case R.id.rbApocalypse:
                /*if (checked)
                    gender = getString(R.string.homme);
                userSingleton.getUser().setGender(gender);*/
                break;
        }
    }
}
